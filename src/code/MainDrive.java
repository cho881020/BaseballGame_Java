package code;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {

//		컴퓨터가 문제를 랜덤으로 내도록
//		100~999숫자 랜덤으로 생성, 생성된 숫자가 0을 포함 하거나 중복이 있다면 다시 만들도록.  이 과정이 몇번일 지 모르므로 'while 사용'
		
		int[] computerQuestionArr = new int[3];
		while(true) {
//			랜덤숫자를 돌려주는 자바의 math 클래스가 가진 random() 함수 활용 - 0.0이상 1.0미만의 소수를 랜덤으로 생성
//			0<= randomVal <1
//			randomVal 에 900을 곱하면? 0<= randomVal*900 <900
//			randomVal*900 에 100을 더하면? 100<= (randomVal*900+100) <1000 : 100~999
//			범위는 ok, 하지만 double 실수 이므로 형변환 필요.
			
			double randomVal = Math.random();
			int randomNumber = (int)(randomVal*900+100);
			System.out.println(randomNumber);


			computerQuestionArr[0] =  randomNumber /100; //			456랜덤 생성 이라면 4를 computerQuestionArr 배열 0번칸에 저장
			computerQuestionArr[1] =  (randomNumber /10)%10;//			456랜덤 생성 이라면 5를 computerQuestionArr 배열 1번칸에 저장
			computerQuestionArr[2] =  randomNumber %10;//			456랜덤 생성 이라면 6를 computerQuestionArr 배열 2번칸에 저장
			
			boolean isQuestionContainZero = false; // 0이 없다고 전제
			
			for(int i=0; i<computerQuestionArr.length;i++) {
				if(computerQuestionArr[i]==0) { // 0이 발견
					isQuestionContainZero = true;
					break;
				}
			}
			
			boolean hasQuestionDuplNum = (computerQuestionArr[0] ==computerQuestionArr[1])
													||(computerQuestionArr[1] ==computerQuestionArr[2])
													||(computerQuestionArr[0] ==computerQuestionArr[2]);
			
			//중복도 ,0도 없다면 문제 그만 생성
			if(!isQuestionContainZero && !hasQuestionDuplNum) { //문제가 올바르게 출제 되었다.
				break;
			}
			
		}

		

//		사용자에게 3자리 숫자 입력받자
		Scanner scan = new Scanner(System.in);

//		사용자가 123 입력 => {1,2,3} 배열로 저장
//		사용자가 입력한 세자리 숫자 저장할 배열
		int[] userInputNumArr = new int[3];
		
//		몇 번 정답을 입력했는지 기록하는 변수 
		int inputCount = 0;
		

//		3S가 될때까지 계속 입력하도록.
		while (true) {

//			올바른 숫자를 입력해야만 검사하러 넘어감.
			while (true) {
				System.out.print("3자리 숫자 입력하세요: ");
				int userInput = scan.nextInt();

//				1. 맨 앞자리 숫자를 0번칸에 저장. 123->1을 0 번 칸에 저장.
				userInputNumArr[0] = userInput / 100;
//				2. 가운데 숫자를 1번 칸에 저장. 456 ->5를 1번칸에
				userInputNumArr[1] = (userInput / 10) % 10;
//				3. 마지막 숫자를 2번 칸에 저장. 456-> 6을 2번 칸에
				userInputNumArr[2] = userInput % 10;

//				0을 포함하고 있는지 체크하는 변수, 0 이 없다고 전제해두고 하나라도 발견하면 있다고 할 것.
				boolean isContainZero = false;

				for (int i = 0; i < userInputNumArr.length; i++) {
					if (userInputNumArr[i] == 0) { // 0 발견
						isContainZero = true;
					}
				}

//				중복 허가x , 중복인지 체크하는 변수 (112,122,121 불가능)
				boolean hasDuplNum = (userInputNumArr[0] == userInputNumArr[1])
						|| (userInputNumArr[1] == userInputNumArr[2]) || (userInputNumArr[0] == userInputNumArr[2]);

//				0도 없고, 동시에 중복도 없다면, -> 입력을 제대로 했다 -> 그만 입력하게 break;
				if (!isContainZero && !hasDuplNum) {
//				제대로 입력한 부분, 입력 횟수도 1 증가!
					inputCount++;
					
					for (int i = 0; i < userInputNumArr.length; i++) {
						System.out.println(userInputNumArr[i]);
					}
					break;
				}
			}
//				입력을 제대로 받았으니, ?S?B인지 검사하기

//				S,B 갯수 기록할 변수 생성
			int strikeCount = 0;
			int ballCount = 0;

//				반복요소
//				1) 사용자가 입력한 숫자를 택하는 반복: 덜 바쁜 애, 바깥쪽, i
//				2) 숫자를 가지고 문제와 비교해서 S.B 판단: 더 바쁜 애 , 안쪽, j

			for (int i = 0; i < userInputNumArr.length; i++) {
				for (int j = 0; j < computerQuestionArr.length; j++) {

//						사용자가 입력한 값중 i 번째 숫자와
//						컴퓨터의 숫자 중 j 번째 숫자가 같은가?
					if (userInputNumArr[i] == computerQuestionArr[j]) // 숫자가 같다! ->이제 S인가 ,B인가 판단 필요
						if (i == j) { // 두 배열의 index 가 같다는 뜻, -> 위치도 같다. 스트라이크 갯수 증가
							strikeCount++;
						} else { // 숫자는 같으나, index 다르다. 위치가 다르다 -> 볼 갯수 증가
							ballCount++;
						}
				}
			}

			System.out.println(String.format("%d S, %d B 입니다.", strikeCount, ballCount));
			
//			게임 종료의 조건? 3S를 맞췄다면! break;

			if (strikeCount == 3) {
				System.out.println("정답입니다!");

//				몇번만에 정답 입력했나 출력
				System.out.println(String.format("%d번 만에 맞췄습니다!", inputCount));
				break;
			}
		}

	}

}
