package 가위바위보게임;

import java.util.Scanner;


/* 먼저 3번을 이기면 끝나는 가위바위보 게임 */
public class GameControl {

	public static boolean inputCheck = false;	//유저가 입력 했는지
	
	static int life = 999;			//남은목숨. 컴퓨터가 이기면 1감소
	static int totalGameCount = 1;	//총 게임진행횟수
	static int win=0;				//유저의 승리횟수
	static int draw=0;				//비김
	static int lose=0;				//유저의 패배횟수
	
	public static void main(String[] args) {
		GameTimer timer = null;
		GameControl gc = new GameControl();
		String computersChoice = null;	//컴퓨터의 선택
		String usersChoice = null;   // 유저의 선택
		
		// 난수를 이용하여 컴퓨터의 가위 바위 보를 정한다.
		String[] data = {"가위", "바위", "보"};
		
		while(win<3 && lose<3) {	//누구 하나라도 해당횟수의 승리를 하게되면 중단
			timer = new GameTimer(totalGameCount);	//게임진행횟수를 인자로줌. 매번 새로운 타이머 생성
			timer.start();
			usersChoice = gc.choiceRSP();	//유저입력 true로 바꾸는 작업도 안에서 한다.
			computersChoice = data[(int) (Math.random()*3)];  //0.000001~2.9999999니까 0,1,2
			System.out.println("\n"+gc.judge(usersChoice,computersChoice));
			gc.showScore();
			totalGameCount++;
		}
		gc.printGameOver();

	}
	
	//유저에게 가위바위보중 하나를 입력받도록 한다.
		public String choiceRSP() {
			System.out.println("\n****가위, 바위, 보 중 무엇을 내겠습니까?****");
			Scanner sc = new Scanner(System.in);
			String result = sc.nextLine();
			if(!result.equals("가위") && !result.equals("바위") && !result.equals("보")) {
				System.out.println("가위바위보 중에 하나를 입력해주세요.");
			}else {
				inputCheck = true;  // 정상적인 가위바위보를 냈을때 입력이 완료로 변경
			}
			return result;
		}
		
		//결과 판단하기
		public String judge(String usersChoice, String computersChoice) {
			System.out.printf("당신은 %s를 내고 컴퓨터는 %s를 냈습니다.", usersChoice, computersChoice);
			inputCheck = false;	//이것이 핵심이였음!!!!!!!!!!!!
			if( usersChoice.equals(computersChoice) ){
				draw++;
				return "비김";
			}else if( (usersChoice.equals("가위") && computersChoice.equals("보"))
					 || (usersChoice.equals("바위") && computersChoice.equals("가위"))
					 || (usersChoice.equals("보") && computersChoice.equals("바위")) ){
				win++;
				return "승리";
			}else{
				life--;
				lose++;
				return "패배";
			}
		}
		
		public void showScore() {
			System.out.printf("총%s판(%d승 %d무 %d패)\n", totalGameCount, win, draw, lose);
		}
		
		public void printGameOver() {
			System.out.println("게임이 끝났습니다.");
			if(win>lose) {
				System.out.println("당신이 이겼습니다.");
			}else {
				System.out.println("컴퓨터가 이겼습니다.");
			}
		}

}
