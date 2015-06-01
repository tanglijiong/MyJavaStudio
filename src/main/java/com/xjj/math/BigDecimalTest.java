package com.xjj.math;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal bigLoanAmount = new BigDecimal("9999999999999999999999"); // 创建BigDecimal对象
		BigDecimal bigInterestRate = new BigDecimal("0.03289");
		BigDecimal bigInterest = bigLoanAmount.multiply(bigInterestRate); // BigDecimal运算
		NumberFormat currency = NumberFormat.getCurrencyInstance(); // 建立货币格式化引用
		NumberFormat percent = NumberFormat.getPercentInstance(); // 建立百分比格式化用
		percent.setMaximumFractionDigits(3); // 百分比小数点最多3位
		// 利用BigDecimal对象作为参数在format()中调用货币和百分比格式化
		System.out.println("Loan amount:\t" + currency.format(bigLoanAmount));
		System.out.println("Interest rate:\t" + percent.format(bigInterestRate));
		System.out.println("Interest:\t" + currency.format(bigInterest));
		
		//最好利用String来初始化一个BigDecimal：
		System.out.println(new BigDecimal(0.1));
		System.out.println(new BigDecimal("0.1"));
	}
}
