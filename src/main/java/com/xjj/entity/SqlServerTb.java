package com.xjj.entity;


public class SqlServerTb {

	private String cVCRID;
	private String cVTYPE;
	private String cVCRETR;
	
	public String getcVCRID() {
		return cVCRID;
	}
	public void setcVCRID(String cVCRID) {
		this.cVCRID = cVCRID;
	}
	public String getcVTYPE() {
		return cVTYPE;
	}
	public void setcVTYPE(String cVTYPE) {
		this.cVTYPE = cVTYPE;
	}
	public String getcVCRETR() {
		return cVCRETR;
	}
	public void setcVCRETR(String cVCRETR) {
		this.cVCRETR = cVCRETR;
	}
	
	@Override
	public String toString() {
		return "SqlServerTb [cVCRID=" + cVCRID + ", cVTYPE=" + cVTYPE
				+ ", cVCRETR=" + cVCRETR + "]";
	}
	
}
