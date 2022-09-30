package 파일입출력;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class 파일읽기 {

	public static void main(String[] args) {
		FileReader fr;
		try {
			fr = new FileReader("C:\\temp\\애국가1절.txt");
			int i ;
			while(  (i=fr.read()  ) !=-1) {//파일에서 다음 문자에 읽을게 있으면 계속 읽어라.
				System.out.print((char)i);//println을 하면 한칸씩 띄우니 조심
			}
		} catch (IOException e) {
			
				e.printStackTrace();
				}
		
		
		}

}
