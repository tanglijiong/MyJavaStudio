package com.xjj.misc;

import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		Random random = new Random(); //以时间为种子的随机数生成器
		
		int randomInt = Math.abs(random.nextInt()%2); //[0,2)之间的整数
		
		System.out.println(randomInt);
	}
}
