package com.xjj.cache.local;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyCacheManager {
	private static Logger logger = LoggerFactory.getLogger(MyCacheManager.class);
	private static MyCache localCache;
	
	private static MyCache getCache(){
		if(localCache==null){
			logger.debug("Creating local cache instance...");
			localCache = new MyCache();
		}
		return localCache;
	}
	
	//第三方支付方式：0支付宝 1微信支付 2银联 3连连支付 5苹果支付 9余额支付 10优惠券支付 21他人支付-支付宝 22他人支付-财付通
	public static void putPaymentMethods() {
		String key = "paymentMethods";
		long age = 60;
		Map<String, String> methods = new LinkedHashMap<String, String>();
		methods.put("0", "支付宝");
		methods.put("1", "微信支付");
		methods.put("2", "银联");
		methods.put("3", "连连支付");
		methods.put("5", "苹果支付");
		methods.put("9", "余额支付");
		methods.put("10", "优惠券支付");
		methods.put("21", "他人支付-支付宝");
		methods.put("22", "他人支付-财付通");
		
		getCache().put(key, methods, age);
		//getCache().put(key, methods);
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, String> getPaymentMethods() {
		CacheObject co = getCache().get("paymentMethods");
		if (co != null) {
			return (Map<String, String>) co.getValue();
		}else {
			return null;
		}
	}
	
	public static String getPaymentMethodName(String number){
		Map<String, String> pm = getPaymentMethods();
		if(pm != null){
			return pm.get(number);
		}else {
			return null;
		}
	}
}
