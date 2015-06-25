package com.xjj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间、日期 工具类
 * @author XuJijun
 *
 */
public class DateUtils {
	
	public final static String DFyyyyMM = "yyyy-MM";
	public final static String DFyyyyMMdd = "yyyy-MM-dd";
	public final static String DFyyyyMMddHH = "yyyy-MM-dd HH";
	public final static String DFyyyyMMddHHmm = "yyyy-MM-dd HH:mm";
	public final static String DFyyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
	public final static String DFyyyyMMddHHmmss2 = "yyyyMMddHHmmss";
	public final static String DFyyyyMMddHHmmssS = "yyyy-MM-dd HH:mm:ss.S";
	public final static String DFHHmmssSSS = "HH:mm:ss.SSS";

	public final static long millisecondsPerMinute = 60L * 1000L;
	public final static long millisecondsPerHour = 60L * millisecondsPerMinute;
	public final static long millisecondsPerDay = 24L * millisecondsPerHour;
	public final static long millisecondsPerWeek = 7L * millisecondsPerDay;
	
	/**
	 * 把Date转换为字符串 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToString(Date date, String format) {
		if (date == null || format == null) {
			return null;
		}
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * 把字符串转换为Date 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date stringToDate(String date, String format) {
		if (date == null || format == null || date == "") {
			return null;
		}
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException ex) {
			return null;
		}
	}
	
	/**
	 * 返回指定格式的当前时间字符串 
	 * @param format
	 * @return
	 */
	public static String getCurrentDateString(String format) {
		return dateToString(new Date(), format);
	}
	
	public static void main(String[] args) {
		System.out.println(dateToString(new Date(), DateUtils.DFHHmmssSSS));
		
		System.out.println(System.currentTimeMillis());
		System.out.println(Calendar.getInstance().getTimeInMillis());
	}
}
