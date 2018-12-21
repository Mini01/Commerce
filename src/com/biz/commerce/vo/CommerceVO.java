package com.biz.commerce.vo;

public class CommerceVO {
	
	private String strDate;
	private String strIO;
	private String strID;
	private String strName;
	private int intDan;
	private int intSu;
	private int intCash;
	private int intCash2;
	public int getIntCash2() {
		return intCash2;
	}
	public void setIntCash2(int intCash2) {
		this.intCash2 = intCash2;
	}
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getStrIO() {
		return strIO;
	}
	public void setStrIO(String strIO) {
		this.strIO = strIO;
	}
	public String getStrID() {
		return strID;
	}
	public void setStrID(String strID) {
		this.strID = strID;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public int getIntDan() {
		return intDan;
	}
	public void setIntDan(int intDan) {
		this.intDan = intDan;
	}
	public int getIntSu() {
		return intSu;
	}
	public void setIntSu(int intSu) {
		this.intSu = intSu;
	}
	public int getIntCash() {
		return intCash;
	}
	public void setIntCash(int intCash) {
		this.intCash = intCash;
	}
	@Override
	public String toString() {
		return "CommerceVO [strDate=" + strDate + ", strIO=" + strIO + ", strID=" + strID + ", strName=" + strName
				+ ", intDan=" + intDan + ", intSu=" + intSu + ", intCash=" + intCash + ", intCash2=" + intCash2 + "]";
	}


}
