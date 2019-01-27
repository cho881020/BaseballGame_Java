package code;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
//		컴퓨터가 문제를 랜덤으로 내도록 해보자.
//		100~999의 숫자를 랜덤으로 생성.
//		생성된 숫자가 0을 포함하거나 중복이있다면 다시 만들도록.
		int[] computerQuestionArr = new int[3];
		
//		랜덤 숫자를 던져주는 자바의 Math클래스가 가진 random() 기능 활용.
//		0.0보다 크거나 같고, 1.0보다 작은 소수를 랜덤으로 생성.
//		0<=랜덤값<1 =
//		=> randomVal에 900을 곱해보자.
//		0 <= 랜덤값*900 < 900
//		=> randomVal*900에 100을 더해보자
//		100<=랜덤값*900+100<1000
//		계산결과는 여전히 실수이므로 형변환하여 정수추출 (Casting)
		double randomVal = Math.random();
		int randomNumber = (int)(randomVal*900+100);
		System.out.println(randomNumber);
		
		boolean isContainZero=false; //0이 없다고 전제
		
//		456 랜덤생성 => 4를 문제배열 0번째 칸에 저장
		computerQuestionArr[0]=randomNumber/100;
//		456 랜덤생성 => 5를 문제배열 1번째 칸에 저장
		computerQuestionArr[1]=randomNumber/10%10;
//		456 랜덤생성 => 6을 문제배열 2번째 칸에 저장
		computerQuestionArr[2]=randomNumber%10;
		
		
//		사용자에게 3자리 숫자를 입력받자.
		Scanner scan = new Scanner(System.in);	

//		사용자가 1,2,3을 입력했다면 {1,2,3} 배열로 저장.	
//		사용자가 입력한 3자리 숫자를 저장할 배열을 만들자.
		int[] userInputNumArr =new int[3];
		
//		몇 번 정답을 입력해봤는지 기록하는 변수생성.
		int inputCount =0;
		
		while(true) {
		
//			올바른 숫자를 입력해야만 검사하러 넘어가는 while문
			while(true) {		
				
				System.out.print("세자리 숫자를 입력하세요.");
				int userInput = scan.nextInt();
							
	//			1. 맨 앞자리 숫자를 0번칸에 저장하자.
				userInputNumArr[0]=userInput/100;
				
	//			2. 가운데 숫자를 1번칸에 저장하자.
				userInputNumArr[1]=userInput/10%10;
				
	//			3. 마지막 숫자를 2번칸에 저장하자.
				userInputNumArr[2]=userInput%10;
				
	//			0을 포함하고 있는지?
	//			0이 없다고 전제했다가 하나라도 발견하면 있다고 바꿀것.
				boolean isContainZero = false;
				
				for(int i=0;i<userInputNumArr.length;i++) {
					if(userInputNumArr[i]==0) {
	//					0을 발견
						isContainZero = true;
					}
				}
				
	//			중복을 허가하지 않을 것.
				boolean hasDuplNum = (userInputNumArr[0] == userInputNumArr[1])
											   ||(userInputNumArr[1]==userInputNumArr[2])||(userInputNumArr[0]==userInputNumArr[2]);
				
	//			0도없고 동시에 중복도 없다면
				if(!isContainZero && !hasDuplNum) {
	//				입력을 제대로 했다. =>그만 입력하도록 break;				
					for(int i=0;i<3;i++) {
						System.out.print(userInputNumArr[i]);
					}		
					System.out.println();
					inputCount++;
					break;
				}	
			}
			
	//		입력을 제대로 받았으니 ?S ?B인지 검사하자.
			
	//		S,B갯수를 기록할 변수를 생성하자.
			int strikeCount = 0;
			int ballCount = 0;
			
	//		반복요소
	//		1) 사용자가 입력한 숫자를 택하는 반복 : i
	//		2) 숫자를 가지고 문제와 비교하여 S/B 판단 : j
			
			for(int i=0; i<userInputNumArr.length;i++) {
				for(int j=0;j<computerQuestionArr.length;j++) {
	//				사용자가 입력한 값 중 i번째 숫자와
	//				컴퓨터가 낸 문제의 값 중 j번째 숫자가 같은지?
					if(userInputNumArr[i]==computerQuestionArr[j]) {
	//					숫자가 같다는 것을 발견 => S인지 B인지?
						if(i==j) {
	//						두 배열의 index가 같다. => 숫자가 위치도 같다. =>S갯수 증가.
							strikeCount++;
						}else {
	//						숫자는 같은데, 위치가 다르다. => B갯수 증가.
							ballCount++;
						}
					}
				}
			}
			
			System.out.println(String.format("%d S, %d B입니다.", strikeCount,ballCount));
			
			
//			게임종료의 조건 : 3S를 맞추는 것. => break;
			if(strikeCount==3) {
				System.out.println(String.format("%d번의 시도끝에,", inputCount));
				System.out.println("축하합니다! 승리했습니다!");
				break;
			}
		}
		
	}
}
