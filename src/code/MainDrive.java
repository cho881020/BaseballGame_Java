package code;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
//		컴퓨터가 낸 문제를 471로 정의
		int[] computerQuestionArr = {4,7,1};
		
//		사용자에게 3자리 숫자 입력받자
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("3자리 숫자 입력하세요: ");
			int userInput = scan.nextInt();
			
//			사용자가 123 입력 => {1,2,3} 배열로 저장
			
//			사용자가 입력한 세자리 숫자 저장할 배열
			int[] userInputNumArr = new int[3];
			
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
	
			for(int i=0; i<userInputNumArr.length;i++) {
				System.out.println(userInputNumArr[i]);
			}
			
		}
		
		
		
	}
}
