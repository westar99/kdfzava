package 컬렉션프레임워크;

import java.util.HashSet;
import java.util.TreeSet;

public class 셋 {

	public static void main(String[] args) {
		
		HashSet<String>포유류 = new HashSet<String>();
		포유류.add("사자");
		포유류.add("코끼리");
		포유류.add("고래");
		포유류.add("원숭이");
		포유류.add("고래");//중복해도 더 안들어감
		포유류.add("고래");
		
		for(String 동물: 포유류) {
			System.out.println(동물);
		}
		
		System.out.println("길이:"+포유류.size());//원소갯수확인
		System.out.println(포유류.contains("고릴라"));//포함여부 ->없다.
		System.out.println(포유류.contains("코끼리"));
		포유류.remove("원숭이");//원소삭제
		System.out.println(포유류.contains("원숭이"));//없다.
		System.out.println("길이:"+포유류.size());
		
		TreeSet<Integer>intSet = new TreeSet<Integer>();
		intSet.add(7);
		intSet.add(8);
		intSet.add(5);
		intSet.add(1);
		intSet.add(13);
		System.out.println(intSet.last());//제일높은값
		System.out.println(intSet.first());//제일낮은값
		System.out.println(intSet.higher(4));//F3을 누르면 정의가 나옴:4다음으로 높은 수
		System.out.println(intSet);
		System.out.println("-----------------");
		
		for(Integer 숫자:intSet) {
			System.out.println(숫자);
		}
		System.out.println("-----------------");
		System.out.println(intSet);
	}

}
