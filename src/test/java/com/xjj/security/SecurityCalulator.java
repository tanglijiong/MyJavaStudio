package com.xjj.security;

import java.text.NumberFormat;

import org.junit.Test;

public class SecurityCalulator {
	
	/**
	 * 交费时限：10年
	 * 每年缴费：10000元
	 * 每月返回：248.9元
	 * 返回年限：终身
	 */
	@Test
	public void product1(){
		double totalInvest = 0;
		double totalIncome = 0;
		for (int year = 1; year <= 40; year++) {
			if(year<=10){
				totalInvest += 10000;
			}
			totalIncome += 248.9*12;
			double rate = totalIncome/totalInvest;
			NumberFormat percent = NumberFormat.getPercentInstance(); // 建立百分比格式化用
			percent.setMaximumFractionDigits(3); // 百分比小数点最多3位
			NumberFormat currency = NumberFormat.getCurrencyInstance(); // 建立货币格式化引用
			
			System.out.println("第" + year + "年：总投入：" + currency.format(totalInvest) + "，总收益：" + currency.format(totalIncome));
			System.out.println("总回报率：" +  percent.format(rate) + "，平均年化回报率：" +  percent.format(rate/year));
			//System.out.println("===============================我是分割线===================================");
		}
	}
}
