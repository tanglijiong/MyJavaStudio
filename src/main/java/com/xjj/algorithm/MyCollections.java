package com.xjj.algorithm;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

public class MyCollections {

	/**
	 * 交集
	 * @author XuJijun
	 */
	@Test
	public void intersection() {
		Set<String> set1 = new LinkedHashSet<>();
		Set<String> set2 = new LinkedHashSet<>();
		
		set1.add("1");
		set1.add("2");
		set1.add("3");
		set1.add("4");
		
		set2.add("1");
		set2.add("3");
		set2.add("6");
		set2.add("8");
		
		System.out.println(set1);
		set1.retainAll(set2);
		System.out.println(set1);
	}
	
	/**
	 * 并集
	 * @author XuJijun
	 */
	@Test
	public void union() {
		Set<String> set1 = new LinkedHashSet<>();
		Set<String> set2 = new LinkedHashSet<>();
		
		set1.add("1");
		set1.add("2");
		set1.add("3");
		set1.add("4");
		
		set2.add("1");
		set2.add("3");
		set2.add("6");
		set2.add("8");
		
		System.out.println(set1);
		set1.addAll(set2);
		System.out.println(set1);
	}
	
}
