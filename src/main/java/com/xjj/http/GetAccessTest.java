package com.xjj.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.xjj.util.DateUtils;
import com.xjj.util.FileAccessUtils;
import com.xjj.util.RandomUtils;
import com.xjj.util.RegexUtils;

public class GetAccessTest {
	private static String getTimeString() {
		return DateUtils.getCurrentDateString(DateUtils.DFHHmmssSSS);
	}
	
	private static void logMsg(String format, Object... args){
		System.out.println(getTimeString() + " [myLog] " + String.format(format, args));
	}
	
	public static void main(String[] args) {
		RandomUtils xjjRandom = new RandomUtils();
		int howLongMinutes = 35;	//Minutes
		int maxIntervalMinutes = 1; //Minutes
		String hostFileName = "D:/httphosts.txt";
		
		if(args.length > 0){ //First Param: How long 
			howLongMinutes = Integer.parseInt(args[0]);
		}

		if(args.length > 1){ //Second Param: Interval
			maxIntervalMinutes = Integer.parseInt(args[1]);
		}

		if(args.length > 2){ //Third Param: File Path and Name
			hostFileName = args[2];
		}
		
		ArrayList<String> hosts = FileAccessUtils.readByLines(hostFileName);
		Map<String, Integer> urlHitCount = new HashMap<>(hosts.size());
		for(String host : hosts){
			urlHitCount.put(host, 0);
		}
		
		logMsg("Program started, will last for %s minutes, with maximum interval %s minutes", howLongMinutes, maxIntervalMinutes);
		
		long endTime = System.currentTimeMillis() + howLongMinutes*60*1000;
		long maxInterval = maxIntervalMinutes*60*1000;
		int succCount = 0;
		int failCount = 0;
		
		while ( System.currentTimeMillis() < endTime) {
			String url = hosts.get(xjjRandom.getRandomInt(hosts.size()));
			HttpResult result = HttpHelper.doGet(url);
			if(result.getCode()==200){
				succCount ++;
				String websiteHitCount = RegexUtils.getFirstMatch(result.getMsg(), "\\d+人阅读");
				logMsg("%s request succeeded, %s. No.%s", url, websiteHitCount, succCount);
				urlHitCount.put(url, urlHitCount.get(url)+1);
			}else {
				failCount ++;
				logMsg("%s %s", url, result.toString());
			}
			
			long interval = Math.abs(xjjRandom.getRandomLong(maxInterval));
			
			if(System.currentTimeMillis()+interval > endTime){
				break;
			}
			
			long currentTimeInSecond = System.currentTimeMillis()/1000;
			logMsg("Time to the end: %s'%s\". Next request in %s seconds...", (endTime/1000-currentTimeInSecond)/60, (endTime/1000-currentTimeInSecond)%60, interval/1000);
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		logMsg("Completed. Succeeded: %s, Failed: %s", succCount, failCount);
		for(Map.Entry<String, Integer> entry : urlHitCount.entrySet()){
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
