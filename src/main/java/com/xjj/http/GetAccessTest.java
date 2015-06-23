package com.xjj.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xjj.util.FileAccessUtils;
import com.xjj.util.RandomUtils;

public class GetAccessTest {
	private static Logger logger = LoggerFactory.getLogger(GetAccessTest.class);
	
	public static void main(String[] args) {
		RandomUtils xjjRandom = new RandomUtils();
		int howLongMinutes = 5;	//Minutes
		int maxIntervalMinutes = 1; //Minutes
		ArrayList<String> hosts = FileAccessUtils.readByLines("D:/hosts.txt");
		Map<String, Integer> urlHitCount = new HashMap<>(hosts.size());
		for(String host : hosts){
			urlHitCount.put(host, 0);
		}
		
		long endTime = System.currentTimeMillis() + howLongMinutes*60*1000;
		long maxInterval = maxIntervalMinutes*60*1000;
		int succCount = 0;
		int failCount = 0;
		
		while ( System.currentTimeMillis() < endTime) {
			String url = hosts.get(xjjRandom.getRandomInt(hosts.size()));
			HttpResult result = HttpHelper.doGet(url);
			if(result.getCode()==200){
				succCount ++;
				logger.info("{} request succeeded. No.{}", url, succCount);
				urlHitCount.put(url, urlHitCount.get(url)+1);
			}else {
				failCount ++;
				logger.info(result.toString());
			}
			
			long interval = Math.abs(xjjRandom.getRandomLong(maxInterval));
			
			if(System.currentTimeMillis()+interval > endTime){
				break;
			}
			
			long currentTimeInSecond = System.currentTimeMillis()/1000;
			logger.info("Time to the end: {}'{}\". Next request in {} seconds...", (endTime/1000-currentTimeInSecond)/60, (endTime/1000-currentTimeInSecond)%60, interval/1000);
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		logger.info("Completed. Succeeded: {}, Failed: {}", succCount, failCount);
		for(Map.Entry<String, Integer> entry : urlHitCount.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
