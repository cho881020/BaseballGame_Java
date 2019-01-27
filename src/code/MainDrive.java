package code;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
//		정대호 브런치
		
//		컴퓨터가 낸 문제를 471로 정의.
		int[] computerQuestionArr = {4, 7, 1} ;
		Scanner scan = new Scanner(System.in);
		
		
//		사용자가 123 => {1,2,3} 배열로 저장.
//		사용자가 입력한 세자리 숫자를 저장할 배열.
		int[] userInputNumArr = new int[3];
		
		while(true) {
//			사용자에게 3자리 숫자를 입력받자.

			System.out.print("3자리 숫자를 입력하세요 : ");
			int userInput = scan.nextInt();
			
			
//			1. 맨 앞자리 숫자를 0번칸에 저장한다. 123 => 1을 0번칸에 저장.
			userInputNumArr[0] = userInput / 100 ;
			
//			2. 가운데 숫자를 1번칸에 저장. 423 => 2를 1번칸에
			userInputNumArr[1] = ( userInput / 10 ) % 10 ;
			
//			3. 마지막 숫자를 2번칸에 저장. 423 => 3을 2번칸에.
			userInputNumArr[2] = userInput % 10 ;
			
			
//			0을 포함하고 있는지?
//			0이 없다고 전제 => 하나라도 발견되면 있다고 말을 바꿀것임.
			boolean isContainZero = false ;
			for(int i = 0 ; i < userInputNumArr.length ; i++) {
				if (userInputNumArr[i] == 0) {
					isContainZero = true ;
				}
			}
			
//			중복을 허가하지 않을 것. 중복인지? 검사 결과 저장.
			boolean hasDuplNum = userInputNumArr[0] == userInputNumArr[1] 
									|| userInputNumArr[0] == userInputNumArr[2] 
									|| userInputNumArr[1] == userInputNumArr[2];
			
//			0도 없고, 동시에 중복도 없다면?			
			if (!isContainZero && !hasDuplNum) {
//				입력을 제대로 했다! => 그만 입력하도록 break;
				for (int i = 0 ; i < userInputNumArr.length ; i++) {
					System.out.println(userInputNumArr[i]);
				}
				
				break;
			}			
			
		} // while 끝  // 사용자 입력 값 유효성 검사 및 출력
		
//		입력을 제대로 받았으니, ?S ?B 인지 검사.
		
//		S, B 갯수를 기록할 변수 생성.
		int strikeCount = 0;
		int ballCount = 0 ;
		
//		반복 요소
//		1) 사용자가 입력한 숫자를 택하는 반복 : 바깥 : i
//		2) 숫자를 가지고 문제와 비교해서 S/B 판단 : 안쪽 : j
		for(int i = 0 ; i < userInputNumArr.length ; i++) {
			
			for (int j = 0 ; j < computerQuestionArr.length ; j++) {
				
				if(userInputNumArr[i] == computerQuestionArr[j]) {
//					숫자가 같다! 발견 => S인지, B인지 판단.
					if ( i == j ) {
//						두 배열의 index가 같다? => 위치도 같다.
//						스트라이트 갯수를 증가.
						strikeCount++;						
					}
					else {
//						숫자는 같지만, 위치가 다르다.
//						볼 갯수를 증가.
						ballCount++;						
					}					
					
				}
				
			} // j for
			
		} // i for
		
		System.out.println(String.format("%d S, %d B 입니다", strikeCount, ballCount));
		
	}
}









