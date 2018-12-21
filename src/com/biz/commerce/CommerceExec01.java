package com.biz.commerce;

import com.biz.commerce.service.CommerceService;

public class CommerceExec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String strFile = "src/com/biz/commerce/매입매출데이터 2018.12.21.txt";
		String strFile2 = "src/com/biz/commerce/상품정보 2018-12-21 .txt";
		String strFile3 = "src/com/biz/commerce/매입매출정보.txt";
		
		
		CommerceService bs = new CommerceService(strFile, strFile2, strFile3);
		
	
		bs.view();
		
	    

	}

}
