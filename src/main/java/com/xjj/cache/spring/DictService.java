package com.xjj.cache.spring;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.xjj.cache.local.CacheObject;

@Component
public class DictService {
	@Cacheable(value="dataDictCache")
	public CacheObject getPaymentMehtodsByClassCode(String classCode) {
		System.out.println("开始读数据……");
		return getPaymentMehtodsFromDB(classCode);
	}
	
	public CacheObject getPaymentMehtodsFromDB(String classCode) {
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
		
		CacheObject co = new CacheObject(methods, 60);
		
		System.out.println("从数据库中取出……");
		
		return co;
	}
}
