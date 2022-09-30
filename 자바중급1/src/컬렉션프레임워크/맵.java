package 컬렉션프레임워크;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class 맵 {

	public static void main(String[] args) {
		//맵은 키와 밸류의 쌍
		Map<String,String>dict = new HashMap<String,String>();
		
		dict.put("apple","사과");
		dict.put("banana","바나나");
		dict.put("peach","복숭아");
		dict.put("pear","배");
		dict.put("pineapple","파인에플");
		
		//키를 통해서 값을 가져온다.
		System.out.println(dict.get("banana"));
		//반복 1. foreach사용
//		dict.forEach(
//				(strKey,strValue)->{
//					System.out.println(strKey+":"+strValue);
//				}
//				//JS에는 화살표함수,자바에서는 람다식
//		);
		
		//반복 2. Iterator사용
//		Iterator<String>keys = dict.keySet().iterator();
//		while(keys.hasNext()) {
//			String key = keys.next();
//			String value = dict.get(key);
//			System.out.println(key+":"+value);
//		}
		//반복 3. keySet활용
		for(String key:dict.keySet()) {
			System.out.println(key+":"+dict.get(key));
		}
		
		
		
		
		
	}
}
