package 컬렉션프레임워크;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class 영단어맞추기 {
	
	//퀴즈:한글보고 영어단어 맞추기
	//1.korDict라는 <String,String>맵을 만들고 2.랜덤으로 한글단어를 보여주고 3.Scanner로 유저가 영어를 입력하면
	//4맞다 아니다를 보여주세요.힌트)get함수를 써서 "키"로 값을 가져올 수 있다

	
	
	public static void main(String[] args) {
	
	
		HashMap<String,String>korDict = new HashMap<String,String>();
			korDict.put("tiger","호랑이");
			korDict.put("lion","사자");
			korDict.put("whale","고래");
			korDict.put("monkey","원숭이");
			korDict.put("human","인간");
			
			int 랜덤인덱스 = new Random().nextInt(korDict.size());
			String randomKey = (String)korDict.keySet().toArray()[랜덤인덱스];
			String answerWord = korDict.get(randomKey);
			
			
			Scanner sc = new Scanner(System.in);
			
			System.out.printf("%s에 해당하는 영단어를 입력해주세요:",answerWord);	
			String userInput = sc.nextLine();//엔터를 기준으로 끊음
			if(userInput.equals(randomKey)) {System.out.println("정답입니다.");}
			else {System.out.println("오답입니다.");			}
		}
				
}		
	
		

