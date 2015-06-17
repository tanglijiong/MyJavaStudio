package com.xjj.constant;

/**
 * 地区类型，和数据库area表中的类型一致
 * @author Xu
 *
 */
public enum AreaType {
	COUNTRY(0),		//国家
	PROVINCE(1),	//省
	CITY(2),		//城市
	DISTRICT(3),	//区
	STREET(4);		//街道
	
	private AreaType(int value){
		this.setValue(value);
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	private int value;
}
