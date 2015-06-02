package com.xjj.cache.guava;

import java.util.concurrent.TimeUnit;

/**
 * 实现和测试LoadingCache
 * @author Xu
 *
 */
public class MyLoadingCache extends MyAbstractLoadingCache<String, String> {
	private static final int MAXIMUM_SIZE = 1000;	//最大缓存条数
	private static final int REFRESH_AFTER_WRITE_DURAION = 200;	//刷新数据时间
	private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;	//时间单位（秒）
	
	//饿汉式单例模式
	private static final MyLoadingCache lc = new MyLoadingCache();
	private MyLoadingCache(){
		super(MAXIMUM_SIZE, REFRESH_AFTER_WRITE_DURAION, TIME_UNIT);
	};
	
	public static MyLoadingCache getInstance(){
		return lc;
	}
	
	@Override
	protected String fetchData(String key) {
        System.out.println("fetchData method..."+key);  

        //返回缓存数据（模拟从数据库获取数据）
        return "{key:"+key+", value:"+key+"'s value}"; 
	}

	public static void main(String[] args) {
		//MyLoadingCache lc = new MyLoadingCache();
		
		try {
			for (int i = 0; i < 100; i++) {
				String value = lc.getCache().get("I am a key"+i);
				System.out.println(value);
			}
			Thread.sleep(3000);
			System.out.println("==========================================");
			for (int i = 0; i < 101; i++) {
				String value = lc.getCache().get("I am a key"+i);
				System.out.println(value);
				Thread.sleep(500);
			}
			
			for (int i = 101; i >= 0; i--) {
				String value = lc.getCache().get("I am a key"+i);
				System.out.println(value);
				Thread.sleep(200);
			}
			
			System.out.println("stats: "+lc.getCache().stats());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
