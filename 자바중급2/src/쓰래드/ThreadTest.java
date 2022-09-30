package 쓰래드;

public class ThreadTest {

	public static void main(String[] args) {
		Runnable d1 = new CheckThread("딸기");
		Runnable d2 = new CheckThread("초코");
		Runnable d3 = new CheckThread("멜론");
		Runnable d4 = new CheckThread("망고");
		Runnable d5 = new CheckThread("오렌지");

		Thread t1 = new Thread(d1);
		Thread t2 = new Thread(d2);
		Thread t3 = new Thread(d3);
		Thread t4 = new Thread(d4);
		Thread t5 = new Thread(d5);
		
		t1.start();//호출할 떄는 스타트 정의할때는 오버라이딩된 런
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
	}

}
