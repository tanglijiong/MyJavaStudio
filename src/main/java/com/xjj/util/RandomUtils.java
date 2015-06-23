package com.xjj.util;

import java.util.Random;

/**
 * 随机数工具，单例模式
 * @author XuJijun
 *
 */
public class RandomUtils {
	private Random random;

	public Random getRandom() {
		if(random==null){
			synchronized (this) {
				if(random==null){
					random =new Random();
				}
			}
		}
		
		return random;
	}

	/**
	 * 活动一个[0,max)之间的整数。
	 * @param max
	 * @return
	 */
	public int getRandomInt(int max) {
		return Math.abs(getRandom().nextInt())%max;
	}
	
	/**
	 * 活动一个[0,max)之间的整数。
	 * @param max
	 * @return
	 */
	public long getRandomLong(long max) {
		return Math.abs(getRandom().nextInt())%max;
	}
}
