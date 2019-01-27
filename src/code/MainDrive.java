package code;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {

//		컴퓨터가 문제를 랜덤으로 내도록.
//		100~999의 숫자를 랜덤으로 생성
//		생성된 숫자가 0을 포함하거나, 중복이 있다면 다시 만들도록
		
		int[] computerQuestionArr = new int[3];
		
		while(true) {
//		랜덤 숫자를 던져주는 자바의 Math 클래스가 가진 random() 기능 활용
//		0.0보다 크거나 같고, 1.0보다 작은 소수를 랜덤으로 생성
//		0 <= randomVal < 1
//		randomVal에 900을 곱해보자.
//		0 <= randomVal*900 < 900
//		900을 곱한 randomVal에 100을 더해보자
		
//		100 <= randomVal * 900 +100< 1000 : 100이상 1000미만 : 100~999
//		계산 결과는 여전히 실수. 강제로 int로 변환해서 정수 추출. 형변환(Casting)
		double randomVal = Math.random();
		int randomNumber = (int)(randomVal*900 + 100);
		System.out.println(randomNumber);
		
		

//		456 랜덤 생성 => 4를 문제배열의 0번칸에 저장
		computerQuestionArr[0] = randomNumber / 100;
//		456 랜덤 생성 => 5를 1번칸에 저장
		computerQuestionArr[1] = randomNumber / 10 % 10;
//		456 랜덤 생성 => 6를 2번칸에 저장
		computerQuestionArr[2] = randomNumber % 10;
		
		
		boolean isQuestionContainZero = false; // 0이 없다고 전제
		
		for(int i = 0 ; i< computerQuestionArr.length ; i++) {
			if(computerQuestionArr[i] == 0) {
//				0을 발견
				isQuestionContainZero = true;
				break;
			}
		}
		
//		중복된 숫자가 있는지 검사
		boolean hasQuestionDuplNum = (computerQuestionArr[0] ==computerQuestionArr[1]
				||computerQuestionArr[1] ==computerQuestionArr[2]
				|| computerQuestionArr[0] ==computerQuestionArr[2]);
		
		}

//		사용자에게 3자리 숫자를 입력받자
		Scanner scan = new Scanner(System.in);
		int[] userInputNumArr = new int[3];

//		몇 번 정답을 입력해봤는지 기록하는 변수
		int inputCount = 0;
		
//		3S가 될때까지 계속 입력하도록
		while (true) {

//			올바른 숫자를 입력해야만 검사하러 넘어감
			while (true) {
				System.out.print("3자리 숫자를 입력하세요 : ");
				int userInput = scan.nextInt();

//				사용자가 123 입력 => {1,2,3} 배열로 전환
//				사용자가 입력한 세자리 숫자를 저장할 배열

//				1. 맨 앞자리 숫자를 0번 칸에 저장한다. 123=> 1을 0번 칸에 저장
				userInputNumArr[0] = userInput / 100;

//				2. 가운데 숫자를 1번칸에 저장. 423 => 2를 1번 칸에
				userInputNumArr[1] = userInput / 10 % 10;

//				3. 마지막 숫자를 2번칸에 저장. 423 => 3을 2번 칸에
				userInputNumArr[2] = userInput % 10;

//				0을 포함하고 있는지?
//				0이 없다고 전제 => 하나라도 발견하면 있다고 말을 바꿀 것임
				boolean isContainZero = false;

				for (int i = 0; i < userInputNumArr.length; i++) {
					if (userInputNumArr[i] == 0) {
//						0을 발견!
						isContainZero = true;
					}
				}

//				중복을 허가하지 않을 것. 중복인지? 검사 결과 저장
//				112, 122, 121 허가 안함
				boolean hasDuplNum = (userInputNumArr[0] == userInputNumArr[1]
						|| userInputNumArr[1] == userInputNumArr[2] || userInputNumArr[0] == userInputNumArr[2]);

//				0도 없고 동시에 중복도 업다면
				if (!isContainZero && !hasDuplNum) {
//					입력을 제대로 했다! => 그만 입력하도록 break;

//					입력 횟수도 1 증가
					inputCount++;
					
					for (int i = 0; i < userInputNumArr.length; i++) {
						System.out.println(userInputNumArr[i]);
					}
					break;
				}

			}

//			입력을 제대로 받았으니, ?S ?B인지 검사

//			S, B 갯수를 기록할 변수 생성.
			int strikeCount = 0;
			int ballCount = 0;

//			반복 요소
//			1) 사용자가 입력한 숫자를 택하는 반복 : 바깥 : i
//			2) 숫자를 가지고 문제와 비교해서 S/B 판단 : 안쪽 : j		

			for (int i = 0; i < userInputNumArr.length; i++) {

				for (int j = 0; j < computerQuestionArr.length; j++) {

					if (userInputNumArr[i] == computerQuestionArr[j]) {
//						숫자가 같다! 발견 => S인지, B인지 판단
						if (i == j) {
//							두 배열의 index가 같다? => 위치도 같다.
//							스트라이크 갯수를 증가.
							strikeCount++;
						} else {
//							숫자는 같은데, 위치가 다르다
//							볼 갯수 증가
							ballCount++;
						}
					}

				}
			}
			System.out.println(String.format("%d S, %d B 입니다.", strikeCount, ballCount));

//			게임 종료 조건? 3S를 맞췄다면 ! break;
			if (strikeCount == 3) {
				System.out.println("정답입니다!");
				
//				몇 번 만에 정답을 입력했는지 출력
				System.out.println(String.format("%d번 만에 맞췄습니다.", inputCount));
				break;
			}
		}

	}
}
