package 컬렉션프레임워크;

import java.util.ArrayList;

public class 리스트 {

	public static void main(String[] args) {
		ArrayList<Integer>al = new ArrayList<Integer>();
		al.add(3);
		al.add(6);
		al.add(2);
		al.add(1);
		al.add(7);
		al.add(9);
		al.add(4);
//		al.add("콜라") 다른타입을 넣으려면 안된다.
		System.out.println(al);
		
		//n번째 인덱스 제거
		al.remove(3);
		System.out.println(al);
		
		//값이 있는지 검사->false
		System.out.println(al.contains(0));
//		System.out.println(al.lastIndexOf(7));위치는 3번째
		//정렬시키면 원본이 바뀜
		al.sort(null);
		System.out.println(al);
		
		//값의 위치를 표시 4(5번째)
		System.out.println(al.lastIndexOf(1000));//요소가 없으면 -1 이 프린트된다.
		System.out.println(al.lastIndexOf(7));
		//
		int total =0;
		for(int i=0;i<al.size();i++ ) {
			total += al.get(i);
		}
		System.out.println(total+"입니다");
		
		
		//비움
		al.clear();
		System.out.println(al);
		System.out.println(al.size());
	}
	

}
