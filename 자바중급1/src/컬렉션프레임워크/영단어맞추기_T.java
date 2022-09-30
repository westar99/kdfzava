package 컬렉션프레임워크;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class 영단어맞추기_T {
	
	//퀴즈:한글보고 영어단어 맞추기
	//1.korDict라는 <String,String>맵을 만들고 2.랜덤으로 한글단어를 보여주고 3.Scanner로 유저가 영어를 입력하면
	//4맞다 아니다를 보여주세요.힌트)get함수를 써서 "키"로 값을 가져올 수 있다

	
	
	public static void main(String[] args) {
	
	
		HashMap<String,String>korDict = new HashMap<String,String>();
			korDict.put("아침 인사","GoodM");
			korDict.put("점심 인사","GoodA");
			korDict.put("저녁 인사","3");
			korDict.put("노래","song");
			korDict.put("강아지","puppy");
			
		Set<String>set = korDict.keySet();//키값만 추출
		Object[]arr = set.toArray();//배열에 순서를 줌
		while(true) {
			int r = (int)(Math.random()*arr.length);//난수발생(0~1)
			String quizHan = (String)arr[r];//문제한글
			String ansEng = korDict.get(quizHan);//정답영어
			
			System.out.println(quizHan+"(이)란 영어로 무엇일까요?");	
			Scanner sc = new Scanner(System.in);
			String result = sc.nextLine();//공백을 기준을 끊기에 오답이 난다.nextLine사용
			
			if(result.equals(ansEng)) {System.out.println("정답입니다.");}
			else {System.out.println("오답입니다.");			}
		}
				
	}		
	
}			

