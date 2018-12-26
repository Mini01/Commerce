package com.biz.commerce.vo;

public class CommerceVO {
	/*
	 *  거래일자 : 상품코드 :거래구분 : 단가: 수량  형식의
	 *  데이터를 읽어서
	 *  각 member 변수에 저장
	 *  
	 *  각 member 변수는 정보은닉과 캡슐화를 하기위해
	 *  private으로 선언한다
	 */
	private String strDate; //거래일자
	private String strIO; // 거래구분
	private String strID; // 상품코드
	private String strName; // 상품이름
	private int intDan; // 상품단가
	private int intSu; // 상품 수량
	private int intCash;
	private int intCash2;
	
	/* 
	 *  private 으로 선언된 변수는
	 *  외부에서 직접 접근 할 수 없으므로
	 *  getter 와 setter 메소드를 생성해서
	 *  변수에 값을 저장하고, 읽을 수 있도록 
	 *  통로를 만든다.
	 */
	
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
