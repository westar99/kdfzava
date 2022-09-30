package 쓰래드;

public class CheckThread implements Runnable{

	String name = "";
	
	//생성자
	public CheckThread(String name) {
		this.name = name;
		
	}
	
	
	@Override
	public void run() {
		for(int i =5; i>0; i--) {
			System.out.println(this.name + "이찍은 "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	
	
}
