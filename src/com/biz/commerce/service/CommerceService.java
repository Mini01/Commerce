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
	/*
	 *  각 데이터를 관리할 List변수들 선언
	 */
	
	List<CommerceVO> CommerList;
	
	/*
	 *  CommerceService 클래스로 객체를 생성할때
	 *  호출되는 생성자를 선언
	 *  
	 *  이 클래스는 Text 파일을 읽어서
	 *  매입매출 관련 업무를 수행할 것이므로
	 *  생성자에서는 Text 파일의 경로정보를 매개변수로 
	 *  받아서 변수에 저장하는 코드를 수행한다.
	 */
	
	String strFile;
	String strFile2;
	String strFile3;
	
	public CommerceService(String strFile ,String strFile2, String strFile3) {
		/*
		 * 매개변수로 받은 strFile , strFile2 strFile3의 내용을
		 * this.strFile
		 * this.strFile2
		 * this.strFile3member 변수에 저장하여
		 * 다른 method에서 사용할 수 있도록 준비
		 */
		
		/*
		 * 매입매출정보의 list를 담을 Commerlist를 초기화한다
		 */
		CommerList = new ArrayList();
		
		this.strFile = strFile;
		this.strFile2 = strFile2;
		this.strFile3 = strFile3;
		
	}
	
	public void view() {
		
		
		FileWriter fr;
		PrintWriter pw;
		
		/*
		 * 파일을 쓰기위한 Print준비
		 */
		
		
		
		this.ReadFile1();
		this.ReadFile2();
		
		/*
		 * 작성해놓았던 ReadFile1과 ReadFile2를 읽어온다.
		 */
		
		try {
			fr = new FileWriter(strFile3);
			pw = new PrintWriter(fr);
			
			
			/*
			 *  단가와 금액
			 *  매입매출데이터의 단가가 
			 *  거래구분이 1 이면 매입단가이고,
			 *  거래구분이 2 이면 매출단가 이다.
			 */
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
	

	/* 
	 *  매입매출데이터 .txt 파일에서 문자열을 읽어서 
	 *  iolist에 저장하는 메소드 선언
	 */
	public void ReadFile2() {
		/*
		 *  txt파일을 읽기위한 FileReader 객체 선언
		 *  FileReader 로 읽은 내용에서 문자열을 쉽게 추출할수있도록 연결되는
		 *  buffer 객체 선언
		 */
		FileReader fr;
		BufferedReader br;
		/*
		 *  생성자에서 값이 할당된 ioFile의 내용을 참조하여
		 *  파일을 읽기 위하여 open 하는 코드
		 *  
		 *  이 코드는 작동되는 과정에서 불가항력적인
		 *  문제가 발생할 소지가 있으므로 반드시 try..catch 문으로 감싸 주어야 한다
		 */
		
		
		try {
			fr = new FileReader(strFile2);
			/*
			 *  FileReader로 open된 파일정보를
			 *  Buffer에 연결하여 준다
			 *  이 코드가 실행되면
			 *  BufferedReaer는 일단 파일을 읽어서
			 *  메모리의 buffer 영역에 저장해둔다.
			 */
			br = new BufferedReader(fr);
			
			/*
			 *  무한반복문을 이용해서
			 *  Buffer에 저장된 파일내용에서
			 *  한줄씩 (문자열로) 읽어서 처리한다.
			 */
			int i =0;
			while(true) {
				/*
				 *  buffer에서 한줄을 읽어서
				 *  reader 변수에 저장
				 */
				
				  String reader = br.readLine();
				  
				  /*
				   * 만약 reader에 저장된 값이 null이면
				   * 모든 문자열을다 읽었다는 것이므로
				   * 반복문을 종료한다.
				   */
				  if(reader == null)break;
				  /*
				   * 반복문이 종료되지 않았으므로
				   * (reader 변수에 문자열이 담겨 있다는 것)
				   * 코드가 실행되어 문자열을 표시한다.
				   */
				  
				  /*
				   * reaer 문자열을 콜론(:)으로 분리해서 
				   * vo에 담고 리스트에저장한다
				   */
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
		
		/*
		 * ReadFile2 와 같은 원리
		 */
		FileReader fr;
		BufferedReader br;
		
		
		try {
			fr = new FileReader(strFile);
			br = new BufferedReader(fr);
			while(true) {
			  String reader = br.readLine();
			  if(reader == null)break;
			  String[] sl  = reader.split(":");
				/*
				 * 새로운 vo를 생성 & 초기화
				 */
			  CommerceVO vo = new CommerceVO();
			  
			  
			  vo.setStrDate(sl[0]);
			  vo.setStrID(sl[1]);
			  vo.setStrIO(sl[2]);
				/*
				 * intDan과 intSu는 int형 변수이므로 문자열을 int로 변환한다
				 */
			  vo.setIntDan(Integer.valueOf(sl[3]));
			  vo.setIntSu(Integer.valueOf(sl[4]));
				
				/*
				 * member변수가 setting된 vo를 CommerList에 추가
				 */
			  
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
