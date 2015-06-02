package com.xjj.cache.spring;


import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import com.xjj.cache.local.CacheObject;

public class LocalCache implements Cache {
	public static Logger logger = LoggerFactory.getLogger(LocalCache.class);
	
	private String name;
	private ConcurrentMap<String, CacheObject> store = new ConcurrentHashMap<>();
	
	private int auditIntervalInSeconds = 20;
	
	public LocalCache() {
		System.out.println("LocalCache()");
		Timer taskTimer = new Timer(true);
		taskTimer.scheduleAtFixedRate(new LocalCacheAuditor(), 1000*3, auditIntervalInSeconds*1000);

		logger.info("Local cache instance and auditor created.");
	}
	
	public LocalCache(String name) {
		this();
		System.out.println("LocalCache(name): name: " + name);
		this.name = name;
	}

	@Override
	public final String getName() {
		System.out.println("getName: name: " + name);
		return this.name;
	}

	public void setName(String name) {
		System.out.println("setName: name: " + name);
		this.name = name;
	}

	@Override
	public ConcurrentMap<String, CacheObject> getNativeCache() {
		return store;
	}

	@Override
	public ValueWrapper get(Object key) {
		System.out.println("get: key: " + key);
		Object value = this.store.get(key);
		return new SimpleValueWrapper(value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(Object key, Class<T> type) {
		System.out.println("getKeyType: key: " + key);
		return (T) store.get(key);
	}

	@Override
	public void put(Object key, Object value) {
		System.out.println("put: key: " + key + " value: " + value);
		store.put((String) key, (CacheObject) value);
	}

	@Override
	public ValueWrapper putIfAbsent(Object key, Object value) {
		System.out.println("putIfAbsent: key: " + key + " value: " + value);
		Object existing = store.putIfAbsent((String) key, (CacheObject) value);
		return new SimpleValueWrapper(existing);
	}

	@Override
	public void evict(Object key) {
		store.remove(key);
	}

	@Override
	public void clear() {
		store.clear();
	}

	/**
	 * 清理过期的cacheObject
	 */
	class LocalCacheAuditor extends TimerTask {
		public void run() {
			logger.info("Clear the expired data from local cache...");
			Set<String> keySet = getNativeCache().keySet();
			for (Object key : keySet) {
				CacheObject co = (CacheObject) getNativeCache().get(key);
				if(!co.isAvailable()) {
					evict(key);
					logger.info("Local Cache Auditor: remove expired data [{}] from local cache.", key);
					//logger.debug("Cache Data after audit: {}", getNativeCache());
				}
			}
		}
	}
}
