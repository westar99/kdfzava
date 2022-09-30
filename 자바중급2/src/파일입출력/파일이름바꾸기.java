package 파일입출력;

import java.io.File;
import java.util.Scanner;

public class 파일이름바꾸기 {

	public static void main(String[] args) {
		//디렉토리 경로 가져오기
		//= 운영체제에서 파일이나 디렉터리나 결국은 파일이다.
		File dir = new File("C:\\temp");
		
		
		
		
		//파일 가져오기
		File[] fileList = dir.listFiles();
		//System.out.println(fileList);//디렉터리 주소가 나옴[Ljava.io.File;@606d8acf
//		for(File ele :fileList) {
//			System.out.println(ele);//이제 디렉터리가 나옴.C:\temp\애국가1절.txt
//		};
		
		if (fileList != null && fileList.length>0) {
			System.out.println("총"+fileList.length+"개의 파일과 디렉터리가 있습니다.");
		}
		
		//파일 새이름 설정
		
		String preFix = "수정_";//원래 파일 명 앞에 붙임

		//원래 파일을 새이름으로 바꾸기
		for(File file:fileList) {
//			String []originFullName = file.getName().split("\\.");
//			String oriFileName = originFullName[0];
//			String newFileName = preFix+oriFileName;
			File newFile = new File(dir+"\\"+preFix+file.getName());
			System.out.println(newFile);
			file.renameTo(newFile);
			
		}
		System.out.println("파일이름바꾸기 끝남");

	}

}
