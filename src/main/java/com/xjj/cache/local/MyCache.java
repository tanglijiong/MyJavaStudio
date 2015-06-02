package com.xjj.cache.local;

import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyCache {
	static public Logger logger = LoggerFactory.getLogger(MyCache.class);
	
	/**
	 * 存放规则：{key, CacheObject(value, expireDt)}
	 * e.g. {class_code, CacheObject(Map{code, name}, expireDt)} 
	 */
	private Map<String, CacheObject> cache;
	
	private int auditIntervalInSeconds = 20;

	public MyCache() {
		cache = new ConcurrentHashMap<String, CacheObject>(); 
		
		Timer taskTimer = new Timer(true);
		taskTimer.scheduleAtFixedRate(new LocalCacheAuditor(), 1000*3, auditIntervalInSeconds*1000);

		logger.info("Local cache instance and auditor created.");
	}
	
	/**
	 * key是否存在
	 * @author XuJijun
	 * @param key
	 * @return
	 */
	public boolean keyExists(String key) {
		if (key == null || "".equals(key)) {
			logger.error("The key [{}] is empty.", key);
			return false;
		}
		return cache.containsKey(key);
	}
	
	public boolean put(String key, Object value) {
		if(key == null || "".equals(key)){
			return false;
		}
		
		CacheObject cacheObject = new CacheObject(value);
		cache.put(key, cacheObject);
		return true;
	}
	
	public boolean put(String key, Object value, long ageInSeconds) {
		if(key == null || "".equals(key)){
			return false;
		}
		
		CacheObject cacheObject = new CacheObject(value, ageInSeconds);
		cache.put(key, cacheObject);
		return true;
	}
	
	public CacheObject get(String key) {
		if(key == null || "".equals(key)){
			return null;
		}
		
		CacheObject co = cache.get(key);
		if(co==null){
			return null;
		}
		
		if(co.isAvailable()){
			return co;
		}else{
			//已经过期
			logger.debug("Remove expired data [{}] from local cache.", key);
			cache.remove(key);
			return null;
		}
		
	}
	
	
	@Override
	public String toString() {
		return "LocalCache [cacheDataMap=" + cache + "]";
	}
	
	/**
	 * 清理过期的cacheObject
	 * @author Xu
	 *
	 */
	class LocalCacheAuditor extends TimerTask {
		public void run() {
			logger.info("Clear the expired data from local cache...");
			Set<String> keySet = cache.keySet();
			for (String key : keySet) {
				if(!cache.get(key).isAvailable()) {
					cache.remove(key);
					logger.info("Local Cache Auditor: remove expired data [{}] from local cache.", key);
				}
			}
		}
	}
}
