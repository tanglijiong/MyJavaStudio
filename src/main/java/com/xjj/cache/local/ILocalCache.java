package com.xjj.cache.local;

/**
 * 本地缓存接口
 * @author XuJijun
 *
 * @param <K> Key的类型
 * @param <V> Value的类型
 */
public interface ILocalCache <K, V> {
	
	/**
	 * 从缓存中获取数据
	 * @param key
	 * @return value
	 */
	public V get(K key);
}
