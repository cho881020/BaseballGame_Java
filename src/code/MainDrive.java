package code;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
//		컴퓨터가 낸 문제를 471로 정의
		int[] computerQuestionArr = {4,7,1};
		
//		사용자에게 3자리 숫자를 입력받자.
		Scanner scan = new Scanner(System.in);
		System.out.print("세자리 숫자를 입력하세요.");
		int userInput = scan.nextInt();
		
//		사용자가 1,2,3을 입력했다면 {1,2,3} 배열로 저장.	
//		사용자가 입력한 3자리 숫자를 저장할 배열을 만들자.
		int[] userInputNumArr =new int[3];
		
//		1. 맨 앞자리 숫자를 0번칸에 저장하자.
		userInputNumArr[0]=userInput/100;
		
//		2. 가운데 숫자를 1번칸에 저장하자.
		userInputNumArr[1]=userInput/10%10;
		
		
//		3. 마지막 숫자를 2번칸에 저장하자.
		userInputNumArr[2]=userInput%10;
		
		for(int i=0;i<3;i++) {
			System.out.print(userInputNumArr[i]);
		}
		
	}
}
