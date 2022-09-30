package 파일입출력;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class 파일읽기_버퍼리더 {

	public static void main(String[] args) {
		BufferedReader bfr = null;
		try {
			bfr = new BufferedReader(new FileReader("C:\\temp\\애국가1절.txt"));
			String str ;
			while(  (str=bfr.readLine()  ) != null) {
				//파일에서 다음 문자에 읽을게 있으면 계속 읽어라.
				//즉 한라인을 읽는다(엔터친데까지)
				System.out.println(str);//println을 하면 한줄씩 됨
			}
		} catch (IOException e) {
			e.printStackTrace();
		 
		}finally {
			try {
				System.out.println("여기 실행됬나요?");
				bfr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		}

}
