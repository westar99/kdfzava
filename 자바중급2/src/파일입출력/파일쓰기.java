package 파일입출력;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class 파일쓰기 {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("C:\\temp\\포켓몬.txt");
			//어떤내용을 쓸지
			fw.write("피카츄 라이츄 파이리 꼬부기");
			fw.write("안녕ㅇㅇ 아아아 아아아 아아앙ㄱ");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			System.out.println("파일쓰기 완료");
			try {
				fw.close();//완료시키지 않으면 저장이 되질 않는다.
			}catch(IOException e) {
				e.printStackTrace();
			
			}
	
	
		}

	}
}