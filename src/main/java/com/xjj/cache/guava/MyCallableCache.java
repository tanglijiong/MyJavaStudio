package com.xjj.cache.guava;


/**
 * 实现和测试CallableCache
 * @author Xu
 *
 */
public class MyCallableCache extends MyAbstractCallableCache<String, String, String> {
	//饿汉式单例模式
	private static final MyCallableCache cc = new MyCallableCache();
	private MyCallableCache(){};
	public static MyCallableCache getInstance(){
		return cc;
	}

	@Override
	public String fetchOrCalculateData(String key, String t) {
        System.out.println("fetchOrCalculateData method...");  

        //返回缓存数据（模拟从数据库获取数据）
        return "{key:" + key + ", value:" + key + "'s value, and args: " + t + "}"; 
	}

	
	public static void main(String[] args) {
		try {
			for (int i = 0; i < 15; i++) {
				String value = getInstance().getCacheData("I am key.", "I am arg.");
				System.out.println(value);
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
