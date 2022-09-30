package 가위바위보게임;

public class GameTimer extends Thread{
	int gameCount=0;
	
	
	public GameTimer(int now) {	//몇번째 게임에 만들어진 타이머인가
		super();
		this.gameCount = now;
	}
	
	@Override
	public void run() {
		for(int i=5; i>=1; i--){
			/* 여러번 경기를 할때 어려움이 발생하는 지점 
			 * inputCheck를 true로 하면 다음 타이머 작동안하고,
			 * false로 하면 이전것이 살아있어서 남아있는 초를 출력하게 된다.
			 * 타이머는 5초를 셀 뿐이다. 타이머의 제어는 타이머의 외부에서 일어나도록 하자. 객체지향적으로
			 */

			if(GameControl.inputCheck==true || gameCount!=GameControl.totalGameCount){
				//유저가 입력했거나  타이머가 자동한게임회차와 본게임의 회차가 다르면
				return;	//run함수를 나가버리면 쓰레드는 자신이 가지고있는 자원을 정상적으로 반납하며 종료된다.
			}
			try {
				System.out.println(i);	//타임 출력
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//System.exit(0);	//타이머가 끝났다고 시스템이 끝나면안되지.
		System.out.println(this.getName()+" 시간초과");
	}

	
}
