package code;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
//		컴퓨터가 낸 문제를 471로 정의
		int[] computerQuestionArr = {4,7,1};
		
//		사용자에게 3자리 숫자 입력받자
		Scanner scan = new Scanner(System.in);
		
//		사용자가 123 입력 => {1,2,3} 배열로 저장
//		사용자가 입력한 세자리 숫자 저장할 배열
		int[] userInputNumArr = new int[3];
		
		while(true) {
			System.out.print("3자리 숫자 입력하세요: ");
			int userInput = scan.nextInt();
			
			
//			1. 맨 앞자리 숫자를 0번칸에 저장. 123->1을 0 번 칸에 저장.
			userInputNumArr[0]=userInput/100;
//			2. 가운데 숫자를 1번 칸에 저장. 456 ->5를 1번칸에
			userInputNumArr[1] = (userInput/10)%10;
//			3. 마지막 숫자를 2번 칸에 저장. 456-> 6을 2번 칸에
			userInputNumArr[2] = userInput %10;
			
//			0을 포함하고 있는지 체크하는 변수, 0 이 없다고 전제해두고 하나라도 발견하면 있다고 할 것.
			boolean isContainZero = false;
			
			for(int i=0; i<userInputNumArr.length;i++) {
				if(userInputNumArr[i]==0) {  //0 발견
					isContainZero = true;
				}
			}
			
//			중복 허가x , 중복인지 체크하는 변수 (112,122,121 불가능)
			boolean hasDuplNum =(userInputNumArr[0] == userInputNumArr[1])
										||(userInputNumArr[1] == userInputNumArr[2])
										||(userInputNumArr[0] == userInputNumArr[2]);
			
//			0도 없고, 동시에 중복도 없다면, -> 입력을 제대로 했다 -> 그만 입력하게
			if ( !isContainZero && !hasDuplNum ) {
			
			
			for(int i=0; i<userInputNumArr.length;i++) {
				System.out.println(userInputNumArr[i]);
			}
			break;
			}
		
//			입력을 제대로 받았으니, ?S?B인지 검사하기
			
//			S,B 갯수 기록할 변수 생성
			int strikeCount = 0;
			int ballCount = 0;
			
			
//			반복요소
//			1) 사용자가 입력한 숫자를 택하는 반복: 덜 바쁜 애, 바깥쪽, i
//			2) 숫자를 가지고 문제와 비교해서 S.B 판단: 더 바쁜 애 , 안쪽, j
			
			for(int i=0; i<userInputNumArr.length; i++) {
				for(int j=0; j<computerQuestionArr.length; j++) {
					
//					사용자가 입력한 값중 i 번째 숫자와
//					컴퓨터의 숫자 중 j 번째 숫자가 같은가?
					if(userInputNumArr[i]==computerQuestionArr[j]) //숫자가 같다! ->이제 S인가 ,B인가 판단 필요
						if(i==j) { //  두 배열의 index 가 같다는 뜻, -> 위치도 같다. 스트라이크 갯수 증가
							strikeCount++;
						}
						else { //숫자는 같으나, index 다르다. 위치가 다르다 -> 볼 갯수 증가
							ballCount++;
						}
				}
			}
			
		}
		
		System.out.println(String.format("%d S, %d B 입니다.", strikeCount, ballCount));
	}
}
