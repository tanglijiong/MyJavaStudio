package com.xjj.utils;

import org.springframework.util.StringUtils;

public class MyStringUtils {
	public static void main(String[] args) {
		String string="abcd efgh ijkl";
		
		//根据第一个空格来分解字符串
		String[] split = StringUtils.split(string, " ");
		
		for(String s : split){
			System.out.println(s);
		}
		//String str=String.format("Hi,%s:%s.%s", "王南","王力","王张"); 
		String fs = String.format("目前只开通%s地区", "赤岗、"+"客村等");
		System.out.println(fs);
	}
}
