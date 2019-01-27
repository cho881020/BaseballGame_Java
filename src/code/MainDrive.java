package code;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
//		컴퓨터가 낸 문제를 471로 정의.
		int[] computerQuestionArr = {4, 7, 1};
		
//		사용자에게 3자리 숫자를 입력받자.
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			
			System.out.print("3자리 숫자를 입력하세요 : ");
			int userInput = scan.nextInt();
			
//			사용자가 입력한 세자리 숫자를 저장할 배열.
			int[] userInputNumArr = new int[3];
			
//			1. 맨 앞자리 숫자를 0번칸에 저장한다. 423 => 4을 0번칸에 저장.
			userInputNumArr[0] = userInput / 100;
			
//			2. 가운데 숫자를 1번칸에 저장. 423 => 2를 1번칸에.
			userInputNumArr[1] = userInput / 10 % 10;
			
//			3. 마지막 숫자를 2번칸에 저장. 423 => 3을 2번칸에.
			userInputNumArr[2] = userInput % 10;
			
//			0을 포함하고 있는지?
//			0이 없다고 전제 => 하나라도 발견하고 있다면 말을 바꿀것임.
			boolean isContainZero = false;
			
			for (int i=0 ; i < userInputNumArr.length ; i++) {
				if (userInputNumArr[i] == 0) {
//					0을 발견!
					isContainZero = true;
					
				}
			}
			
//			중복을 허가하지 않을것. 중복인지? 검사결과 저장.
//			112, 122, 121 허가안함.
			boolean hasDup1Num = (userInputNumArr[0] == userInputNumArr[1])
					|| (userInputNumArr[1] == userInputNumArr[2])
					|| (userInputNumArr[0] == userInputNumArr[2]);
			
//			0도 없고, 동시에 중복도 없다면?
			if (!isContainZero && !hasDup1Num) {
//				입력을 제대로 했다! => 그만 입력하도록 break;
				
				for (int i=0 ; i < userInputNumArr.length ; i++) {
					System.out.println(userInputNumArr[i]);
				}
				
				break;
			}
					
					
			
		}
		
		

		
	}
}
