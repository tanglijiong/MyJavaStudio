package com.xjj.cache.guava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * 抽象缓存类、缓存模板。
 * 子类需要实现fetchOrCalculateData从数据库或其他数据源中获取数据。
 * 
 * @author XuJijun
 *
 * @param <K>
 * @param <V>
 * @param <T>
 */
public abstract class MyAbstractCallableCache<K, V, T> {
	private int maximumSize = 1000;					//最大缓存条数
	private int refreshAfterWriteDuration = 10;		//刷新数据时间
	private TimeUnit timeUnit = TimeUnit.SECONDS;	//缺省时间单位（秒）
	
	// 创建缓存
	public Cache<K, V> cache;/* = CacheBuilder.newBuilder()
			// 缓存数据的条目
			.maximumSize(MAXIMUM_SIZE)
			// 根据键值对被创建或值被替换后多少时间后移除
			.expireAfterWrite(REFRESH_AFTER_WRITE_IN_SECONDS, TimeUnit.SECONDS)
			.build();*/

	public MyAbstractCallableCache() {
		cache = CacheBuilder.newBuilder().maximumSize(maximumSize) 		//缓存数据的最大条目
				.expireAfterWrite(refreshAfterWriteDuration, timeUnit)	//记录被创建或值被更新多少时间后被移除
				.build();
	}

	public MyAbstractCallableCache(int maximumSize,	int refreshAfterWriteDuration, TimeUnit timeUnit) {
		this.maximumSize = maximumSize;
		this.refreshAfterWriteDuration = refreshAfterWriteDuration;
		this.timeUnit = timeUnit;
		cache = CacheBuilder.newBuilder().maximumSize(maximumSize) 		//缓存数据的最大条目
				.expireAfterWrite(refreshAfterWriteDuration, timeUnit)	//记录被创建或值被更新多少时间后被移除
				.build();
	}



	public V getCacheData(final K key, final T t){  
        try {  
            return cache.get(key, new Callable<V>() {  
  
                public V call() throws Exception {  
                    //执行缓存数据方法  
                    return fetchOrCalculateData(key, t);  
                }  
            });  
        } catch (ExecutionException e) {  
            e.printStackTrace();  
            return null;  
        }  
    } 
    
    /**
     * 从数据库或其他数据源中获取数据、或计算数据
     * @author XuJijun
     * @param key
     * @param t 可以被用来进行计算的一个额外参数
     * @return
     */
    public abstract V fetchOrCalculateData(K key, T t);  
}
