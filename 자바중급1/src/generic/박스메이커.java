package generic;

public class 박스메이커 {

	public static void main(String[] args) {
		
		Box<String> box1 = new Box<String>();
		box1.setT("생활코딩");
		System.out.println(box1.getT());

		
		Cat meaw = new Cat();
		meaw.age = 2000;
		meaw.height = 120;
		meaw.weight =25;
		Box<Cat>box2 = new Box<Cat>();
		box2.setT(meaw);
		System.out.println(box2.getT());
		
		Box<Integer>box3=new Box<Integer>();
		box3.setT(3);
		System.out.println(box3.getT());;
		
		// 제네릭 : 문법<매개변수>
		// 매개변수는 암묵적으로 E,K,N ->참조형만 가능 int는 안들어가니 int를 객체화한 Integer만 가능
		
		NumberBox<Number>box4 = new NumberBox<Number>();//추상클래스가 가지고 있는 Number사용
		Integer[] arr = {1,2,3,4,5,6,7,8,9,10};
		Double[] arr2 = {1.1,2.2,3.2,4.4,5.6};
		System.out.println(box4.sum(arr));//sum위에 커서를 올려 놓으면 주석을 볼 수 있다.
		System.out.println(box4.sum(arr2)); 
		
	}

}
