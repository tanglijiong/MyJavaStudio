package com.xjj.string;

import org.springframework.util.StringUtils;

public class MyStringUtils {
	public static void main(String[] args) {
		String string="abcd efgh ijkl";
		
		//根据第一个空格来分解字符串
		String[] split = StringUtils.split(string, " ");
		
		for(String s : split){
			System.out.println(s);
		}
	}
}
