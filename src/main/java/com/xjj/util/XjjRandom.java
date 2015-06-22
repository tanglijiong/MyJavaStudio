package com.xjj.util;

import java.util.Random;

public class XjjRandom {
	private Random random;
	
	public XjjRandom() {
		this.random =new Random();
	}


	/**
	 * 活动一个[0,max)之间的整数。
	 * @param max
	 * @return
	 */
	public int getRandomInt(int max) {
		return Math.abs(random.nextInt())%max;
	}
	
	/**
	 * 活动一个[0,max)之间的整数。
	 * @param max
	 * @return
	 */
	public long getRandomLong(long max) {
		return Math.abs(random.nextInt())%max;
	}
}
