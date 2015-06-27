package com.xjj.regex;

import java.util.List;

import org.junit.Test;

import com.xjj.util.RegexUtils;

public class RegexTest {
	@Test
	public void getContentByPattern(){
		String INPUT = "我是123，不是678。";
		String REGEX = "\\d+";
		
		List<String> result = RegexUtils.getContentByPattern(INPUT, REGEX);
		System.out.println(result);
	}
	
	@Test
	public void getFirstMatch(){
		String INPUT = "我是123，不是678。";
		String REGEX = "不是\\d+";
		
		String result = RegexUtils.getFirstMatch(INPUT, REGEX);
		System.out.println(result);
	}
	
	@Test
	public void replaceContentByPattern(){
		String INPUT = "我是123，不是678。";
		String REGEX = "123";
		
		String result = RegexUtils.replaceContentByPattern(INPUT, REGEX, "100");
		System.out.println(result);
	}
	
	@Test
	public void findFirstNumber(){
		String INPUT = "我是123，不是678。";
		
		String result = RegexUtils.findFirstNumber(INPUT);
		System.out.println(result);
	}
}
