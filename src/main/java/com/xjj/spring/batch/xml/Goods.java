package com.xjj.spring.batch.xml;

import java.util.Date;

public class Goods {
	 /** isin号 */
    private String isin;
    /** 数量 */
    private int quantity;
    /** 价格 */
    private double price;
    /** 客户 */
    private String customer;
    /** 购入日期 */
    private Date buyDay;
    
	public String getIsin() {
		return isin;
	}
	public void setIsin(String isin) {
		this.isin = isin;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Date getBuyDay() {
		return buyDay;
	}
	public void setBuyDay(Date buyDay) {
		this.buyDay = buyDay;
	}
}
