package com.xjj.http;

public class SimpleGetTest {

	public static void main(String[] args) {
		HttpResult result = HttpHelper.doGet("http://blog.csdn.net/clementad/article/details/46592557");
		if(result.getCode()==200){
			
		}
		System.out.println(result.getMsg());
	}
}
