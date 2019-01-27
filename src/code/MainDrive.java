package code;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
//		정대호 브런치
		
////		컴퓨터가 낸 문제를 471로 정의.
//		int[] computerQuestionArr = {4, 7, 1} ;
//		

//		컴퓨터가 문제를 랜덤으로 내도록 설정.
//		100 ~ 999의 숫자를 랜덤으로 생성.
//		생성된 숫자가 0을 포함하거나, 중복이 있다면 다시 만들도록.  => 언제 만들어질지 모르기때문에 while
		
		int[] computerQuestionArr = new int[3];

		while(true) {
//////		랜덤 숫자를 던져주는 자바의 Math 클래스가 가진 random() 기능 활용.
//			0.0 보다 크거나 같고, 1.0보다 작은 소수를 랜덤으로 생성. (실행시마다 새로 생성) 
//			0<= 랜덤값 < 1  
//			=> randomVal에 900을 곱해보자.
//			0 <= randomVal * 900 < 900
//			900을 곱한 randomVal에 100을 더해보자.
//			100  <= randomVal * 900 +100 < 1000  : 100이상 1000 미만 : 100 ~ 999
//			계산 결과는 여전히 실수, 강제로 int로 변환해서 정수 추출. 형변환(Casting)

			double randomVal = Math.random();  
			int randomNumber = (int) ( randomVal*900 +100);
			System.out.println(randomNumber);
			
//			랜덤 456 생성 => 4를 문제배열 0번칸에 저장.
			computerQuestionArr[0] = randomNumber/100;
			
//			랜덤 456 생성 => 5를 1번칸에 저장.
			computerQuestionArr[1] = randomNumber / 10 % 10;
			
//			랜덤 456 생성 => 6를 2번칸에 저장.
			computerQuestionArr[2] = randomNumber % 10 ;
			
//			0포함 여부 검사 => 0 포함시 true
			boolean isQuestionContainZero = false;
			
			for(int i = 0 ; i < computerQuestionArr.length ; i++) {
				
				if (computerQuestionArr[i] == 0) {
					isQuestionContainZero = true;
					break;
				}
			}
			
			
//			중복된 숫자 검사 => 중복시 true
			
			boolean hasQuestionDuplNum = computerQuestionArr[0] == computerQuestionArr[1] 
					|| computerQuestionArr[0] == computerQuestionArr[2] 
					|| computerQuestionArr[1] == computerQuestionArr[2] ;
					
			
			
			
			break;
		}

		
		
		
		
		
//		사용자가 123 => {1,2,3} 배열로 저장.
//		사용자가 입력한 세자리 숫자를 저장할 배열.
		
		Scanner scan = new Scanner(System.in);
		int[] userInputNumArr = new int[3];
		
//		몇번 정답을 입력해봤는지 기록하는 변수. 
//		유효성 검사를 통과한 경우에만 카운트 증가
		int inputCount = 0;
		
		
//		3S가 될때까지 계속 입력하도록.
		while(true) {
			
//			올바른 숫자를 입력해야 넘어감.
			while(true) {
//				사용자에게 3자리 숫자를 입력받자.

				System.out.print("3자리 숫자를 입력하세요 : ");
				int userInput = scan.nextInt();
				
				
//				1. 맨 앞자리 숫자를 0번칸에 저장한다. 123 => 1을 0번칸에 저장.
				userInputNumArr[0] = userInput / 100 ;
				
//				2. 가운데 숫자를 1번칸에 저장. 423 => 2를 1번칸에
				userInputNumArr[1] = ( userInput / 10 ) % 10 ;
				
//				3. 마지막 숫자를 2번칸에 저장. 423 => 3을 2번칸에.
				userInputNumArr[2] = userInput % 10 ;
				
				
//				0을 포함하고 있는지?
//				0이 없다고 전제 => 하나라도 발견되면 있다고 말을 바꿀것임.
				boolean isContainZero = false ;
				for(int i = 0 ; i < userInputNumArr.length ; i++) {
					if (userInputNumArr[i] == 0) {
						isContainZero = true ;
					}
				}
				
//				중복을 허가하지 않을 것. 중복인지? 검사 결과 저장.
				boolean hasDuplNum = userInputNumArr[0] == userInputNumArr[1] 
										|| userInputNumArr[0] == userInputNumArr[2] 
										|| userInputNumArr[1] == userInputNumArr[2];
				
//				0도 없고, 동시에 중복도 없다면?			
				if (!isContainZero && !hasDuplNum) {
//					입력을 제대로 했다! => 그만 입력하도록 break;
					
//					입력 횟수도 1증가
					inputCount++;
					for (int i = 0 ; i < userInputNumArr.length ; i++) {
						System.out.println(userInputNumArr[i]);
					}
					
					break;
				}			
				
			} // while 끝  // 사용자 입력 값 유효성 검사 및 출력
			
//			입력을 제대로 받았으니, ?S ?B 인지 검사.
			
//			S, B 갯수를 기록할 변수 생성.
			int strikeCount = 0;
			int ballCount = 0 ;
			
//			반복 요소
//			1) 사용자가 입력한 숫자를 택하는 반복 : 바깥 : i
//			2) 숫자를 가지고 문제와 비교해서 S/B 판단 : 안쪽 : j
			for(int i = 0 ; i < userInputNumArr.length ; i++) {
				
				for (int j = 0 ; j < computerQuestionArr.length ; j++) {
					
					if(userInputNumArr[i] == computerQuestionArr[j]) {
//						숫자가 같다! 발견 => S인지, B인지 판단.
						if ( i == j ) {
//							두 배열의 index가 같다? => 위치도 같다.
//							스트라이트 갯수를 증가.
							strikeCount++;						
						}
						else {
//							숫자는 같지만, 위치가 다르다.
//							볼 갯수를 증가.
							ballCount++;						
						}					
						
					}
					
				} // j for
				
			} // i for
			
			System.out.println(String.format("%d S, %d B 입니다", strikeCount, ballCount));
			
//			게임 종료의 조건? 3S를 맞췄다면! break;
			if(strikeCount == 3) {
				System.out.println("정답입니다!");
				
//				몇번만에 정답을 입력했는지 출력
				System.out.println(String.format("%d번 만에 맞췄습니다!", inputCount));
				
				break; // (3S가 되어 while문 종료)  
			}
			
			
		} // while (3S가 될때까지 계속 입력하도록.)
		
		
		
		
	}
}









