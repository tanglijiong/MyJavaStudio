package com.xjj.cache;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xjj.cache.local.CacheObject;
import com.xjj.cache.local.MyCacheManager;
import com.xjj.cache.spring.DictService;
import com.xjj.cache.spring.LocalCache;

@RunWith(SpringJUnit4ClassRunner.class)  //使用Spring Junit4进行测试  
@ContextConfiguration ("classpath:/spring/applicationContext-localcache.xml") //加载配置文件
public class LocalCacheTest {
	static public Logger logger = LoggerFactory.getLogger(MyCacheManager.class);

	@Autowired
	DictService dictService;
	@Autowired
	//LocalCacheManager cacheManager;
	SimpleCacheManager cacheManager;
	
	/**
	 * 直接存取数据
	 * @author XuJijun
	 */
	@Test
	public void putAndGetPaymentMethods(){
		try {
			MyCacheManager.putPaymentMethods();
			
			Map<String, String> pm = MyCacheManager.getPaymentMethods();
			System.out.println("数据：" + pm);

			for(int i=0;i<24;i++){
				String number = String.valueOf(i);
				System.out.println("number: " + number + "; value: " + MyCacheManager.getPaymentMethodName(number));
			}
			
			for (int i = 0; i < 20; i++) {
				Thread.sleep(1000*8);
				System.out.println("数据(" + ((i+1)*8) +  "s)：" + MyCacheManager.getPaymentMethods());	
			}
			
			//Thread.sleep(1000*100);
			
			System.out.println("Done!");
		} catch (Exception e) {
			logger.error("注意，有异常！", e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void springCacheTest(){
		try {
			LocalCache lc = new LocalCache();
			String key = "paymentMethods";
			long age = 60;
			Map<String, String> methods = new LinkedHashMap<>();
			methods.put("0", "支付宝");
			methods.put("1", "微信支付");
			methods.put("2", "银联");
			methods.put("3", "连连支付");
			methods.put("5", "苹果支付");
			methods.put("9", "余额支付");
			methods.put("10", "优惠券支付");
			methods.put("21", "他人支付-支付宝");
			methods.put("22", "他人支付-财付通");
			
			lc.put(key, new CacheObject(methods, age));
			System.out.println("cache：" + lc.getNativeCache());
			
			
			CacheObject co = (CacheObject) lc.get(key).get();
			Map<String, String> m = (Map<String, String>) co.getValue();
			System.out.println("数据：" + m);
			
			for(int i=0;i<24;i++){
				String number = String.valueOf(i);
				System.out.println("number: " + number + "; value: " + m.get(number));
			}
			
			for(int i=0;i<20;i++){
				Thread.sleep(1000*8);
				if(lc.get(key)==null){
					m = null;
				}else {
					co = (CacheObject) lc.get(key).get();
					if(co==null){
						m = null;
					}else{
						m = (Map<String, String>) co.getValue();
					}
				}
				
				System.out.println("数据(" + ((i+1)*8) +  "s)：" + m);
			}
			
		} catch (Exception e) {
			logger.error("注意，有异常！", e);
		}
	}
	
	@Test
	public void xmlCacheTest(){
		try {
			String classCode = "paymentMethods";
			System.out.println("第一次");
			CacheObject co = dictService.getPaymentMehtodsByClassCode(classCode);
			System.out.println(co);
			//Map<String, String> pm = dictService.getPaymentMethods();
			//System.out.println("数据：" + pm);
			
			System.out.println("Cache Name: " + cacheManager.getCacheNames());
			//System.out.println("Native Cache: " + cacheManager.getCache("dataDict").getNativeCache());
			//cacheManager.getCache("dataDict").put(classCode, new CacheObject("content", 20));
			
			System.out.println("第二次");
			co = dictService.getPaymentMehtodsByClassCode(classCode);
			System.out.println(co);
			
			Thread.sleep(1000*100);
		} catch (InterruptedException e) {
			logger.error("注意，有异常！", e);
		}
	}
}
