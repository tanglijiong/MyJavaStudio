package com.xjj.http;

import java.util.Random;

public class GetAccessTest {
	public static void main(String[] args) {
		Random random = new Random();
		long howLong = 10*60*1000; //Milliseconds
		int maxInterval = 3*60*1000; //Milliseconds
		
		long beginTime = System.currentTimeMillis();
		int succCount = 0;
		
		while ( System.currentTimeMillis() < beginTime + howLong) {
			HttpResult result = HttpHelper.doGet("http://open.iciba.com/dsapi");
			if(result.getCode()==200){
				succCount ++;
				System.out.println("Request Succeeded. No." + succCount);
			}else {
				System.out.println(result);
			}
			
			int interval = Math.abs(random.nextInt())%maxInterval;
			
			if(System.currentTimeMillis()+interval > beginTime + howLong){
				break;
			}
			
			System.out.println("Next request in " + interval/1000 + " seconds...");
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Completed. " + succCount + "times in total.");
	}
}
