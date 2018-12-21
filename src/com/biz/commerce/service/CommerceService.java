package com.biz.commerce.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.biz.commerce.vo.CommerceVO;

public class CommerceService {
	
	List<CommerceVO> CommerList;
	
	String strFile;
	String strFile2;
	String strFile3;
	
	public CommerceService(String strFile ,String strFile2, String strFile3) {
		CommerList = new ArrayList();
		
		this.strFile = strFile;
		this.strFile2 = strFile2;
		this.strFile3 = strFile3;
		
	}
	
	public void view() {
		
		
		FileWriter fr;
		PrintWriter pw;
		
		
		
		this.ReadFile1();
		this.ReadFile2();
		
		try {
			fr = new FileWriter(strFile3);
			pw = new PrintWriter(fr);
			
			for(CommerceVO vo :CommerList) {
				String strIo = "";
				int iTotal =0;
				int oTotal =0;
				if(vo.getStrIO().equals("1")) {
					strIo ="매입";
				    iTotal = vo.getIntDan() * vo.getIntSu();
				}else {
				     strIo = "매출";
					 oTotal = vo.getIntDan() * vo.getIntSu();
	
				}
				pw.print(vo.getStrDate() +"\t");
				pw.print(strIo+"\t");
				pw.print(vo.getStrID()+"\t");
				pw.print(vo.getStrName()+"\t");
				pw.print(vo.getIntDan()+"\t");
				pw.print(vo.getIntSu()+"\t");
				pw.print(iTotal +"\t");
				pw.print(oTotal+ "\n");
			
		
				
				 		
			}
			pw.close();
			fr.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
	}
	

	
	public void ReadFile2() {
		FileReader fr;
		BufferedReader br;
		
		try {
			fr = new FileReader(strFile2);
			br = new BufferedReader(fr);
			int i =0;
			while(true) {
				
				  String reader = br.readLine();
				  if(reader == null)break;
				  String[] sl  = reader.split(":");
				  
				  CommerceVO vo = CommerList.get(i);
				  i++;
				  
				  vo.setStrName(sl[1]);
				  
				  vo.setStrID(sl[0]);
				  
				  
				  
				
				 
				  
				  
				  
				  
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void ReadFile1() {
		
		FileReader fr;
		BufferedReader br;
		
		
		try {
			fr = new FileReader(strFile);
			br = new BufferedReader(fr);
			while(true) {
			  String reader = br.readLine();
			  if(reader == null)break;
			  String[] sl  = reader.split(":");
			  CommerceVO vo = new CommerceVO();
			  
			  
			  vo.setStrDate(sl[0]);
			  vo.setStrID(sl[1]);
			  vo.setStrIO(sl[2]);
			  vo.setIntDan(Integer.valueOf(sl[3]));
			  vo.setIntSu(Integer.valueOf(sl[4]));
			  
			  CommerList.add(vo);
			  
					  
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
