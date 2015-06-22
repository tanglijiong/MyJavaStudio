package com.xjj.http;

import java.util.ArrayList;

import com.xjj.util.FileAccessUtils;
import com.xjj.util.XjjRandom;

public class GetAccessTest {
	
	
	
	public static void main(String[] args) {
		XjjRandom xjjRandom = new XjjRandom();
		int howLongMinutes = 30;	//Minutes
		int maxIntervalMinutes = 1; //Minutes
		ArrayList<String> hosts = FileAccessUtils.readByLines("D:/hosts.txt");
		
		long endTime = System.currentTimeMillis() + howLongMinutes*60*1000;
		long maxInterval = maxIntervalMinutes*60*1000;
		int succCount = 0;
		
		while ( System.currentTimeMillis() < endTime) {
			String url = hosts.get(xjjRandom.getRandomInt(hosts.size()));
			HttpResult result = HttpHelper.doGet(url);
			if(result.getCode()==200){
				succCount ++;
				System.out.println(url + " request succeeded. No." + succCount);
			}else {
				System.out.println(result);
			}
			
			long interval = Math.abs(xjjRandom.getRandomLong(maxInterval));
			
			if(System.currentTimeMillis()+interval > endTime){
				break;
			}
			
			long currentTimeInSecond = System.currentTimeMillis()/1000;
			System.out.println("Time to the end: " + (endTime/1000-currentTimeInSecond)/60 + "\'" + (endTime/1000-currentTimeInSecond)%60 + "\". Next request in " + interval/1000 + " seconds...");
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Completed. " + succCount + " times in total.");
	}
}
