package code;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {

//		컴퓨터가 낸 문제를 471로 정의.
//		int[] computerQuestionArr = {4, 7, 1};
		
//		컴퓨터가 100 ~ 999까지 랜덤으로 문제를 냄. 중복X, 0이 포함되면 안되고, 같은 숫자반복X
		int[] computerQuestionArr = new int[3];
		
		while(true) {
//			랜덤 숫자를 던져주는 자바의 math 클래스가 가진 random() 기능 활용.
//			0.0보다 크거나 같고 1.0보다 작은 소수를 랜덤으로 생성
//			100 <= randomVal*900 + 100 < 1000
			
			
			double randomVal = Math.random();
			int randomNumber = (int) randomVal * 900 + 100;
			System.out.println(randomVal);
			
			computerQuestionArr[0] = randomNumber / 100;
			computerQuestionArr[1] = randomNumber / 10;
			computerQuestionArr[2] = randomNumber % 10;
			
			boolean isQuestionZero = false;
			
			for(int i=0; i<computerQuestionArr.length; i++) {
				if(computerQuestionArr[i] == 0) {
					isQuestionZero = true;
					break;
				}
			}
			
		}
		

		

//		사용자에게 3자리 숫자를 입력받자.
		Scanner scan = new Scanner(System.in);
		
//		사용자가 123 입력 => {1,2,3} 배열로 저장.
//		사용자가 입력한 세자리 숫자를 저장할 배열. 
		int[] userInputNumArr = new int[3];
		
//		정답까지 시도한 횟수를 저장할 변수
		int inputCount = 0;

		
//		3S가 될때까지 계속 입력하도록.
		while (true) {
			
//			올바른 숫자를 입력해야만 검사하러 넘어감.
			while (true) {
				System.out.print("3자리 숫자를 입력하세요 : ");
				int userInput = scan.nextInt();
				
				
//				1. 맨 앞자리 숫자를 0번칸에 저장한다. 423 => 4을 0번칸에 저장.
				userInputNumArr[0] = userInput / 100;
			
//				2. 가운데 숫자를 1번칸에 저장. 423 => 2를 1번칸에
				userInputNumArr[1] = userInput / 10 % 10;
				
//				3. 마지막 숫자를 2번칸에 저장. 423 => 3을 2번칸에.
				userInputNumArr[2] = userInput % 10;
				
				
//				0을 포함하고 있는지?
//				0이 없다고 전제 => 하나라도 발견하면 있다고 말을 바꿀것임.
				boolean isContainZero = false;
				
				for (int i=0 ; i <userInputNumArr.length ; i++) {
					if (userInputNumArr[i] == 0) {
//						0을 발견!
						isContainZero = true;
					}
				}
				

//				중복을 허가하지 않을것. 중복인지? 검사 결과 저장.
//				112, 122, 121 허가 안함.
				boolean hasDuplNum = (userInputNumArr[0] == userInputNumArr[1]) 
						|| (userInputNumArr[1] == userInputNumArr[2])
						|| (userInputNumArr[0] == userInputNumArr[2]);
				
//				0도 없고, 동시에 중복도 없다면?
				if (!isContainZero && !hasDuplNum) {
//					입력을 제대로 했다! => 그만 입력하도록 break;
					
//					입력횟수도 1증가
					inputCount++;
					
					for (int i=0 ; i < userInputNumArr.length ; i++) {
						System.out.println(userInputNumArr[i]);
					}
					break;
				}
				
				
				
			}
			
			
//			입력을 제대로 받았으니, ?S ?B인지 검사.
			
//			S, B 갯수를 기록할 변수 생성.
			int strikeCount = 0;
			int ballCount = 0;
			
//			반복 요소
//			1) 사용자가 입력한 숫자를 택하는 반복 : 바깥 : i
//			2) 숫자를 가지고 문제와 비교해서 S/B 판단 : 안쪽 : j
			
			for (int i=0 ; i < userInputNumArr.length ; i++) {
				
				for (int j=0 ; j < computerQuestionArr.length ; j++) {
					
//					사용자가 입력한 값중 i번째 숫자와
//					컴퓨터가 낸 문제의 값중 j번째 숫자가 같은지?
					if (userInputNumArr[i] == computerQuestionArr[j]) {
//						숫자가 같다! 발견 => S인지, B인지 판단.
						
						if (i == j ) {
//							두 배열의 index가 같다? => 위치도 같다.
//							스트라이크 갯수를 증가.
							strikeCount++;
						}
						else {
//							숫자는 같은데, 위치가 다르다.
//							볼 갯수를 증가.
							ballCount++;
						}
						
						
					}
					
				}
				
			}
			
			System.out.println(String.format("%d S, %d B 입니다.", strikeCount, ballCount));
			
//			게임 종료의 조건? 3S를 맞췄다면! break;
			
			if (strikeCount == 3) {
				System.out.println("정답입니다!");
				
//				몇번만에 정답을 입력했는지 출력.
				System.out.println(String.format("%d번만에 정답을 맞췄습니다.", inputCount));
				break;
			}
			
			
		}
		
		
		
	}
}

















