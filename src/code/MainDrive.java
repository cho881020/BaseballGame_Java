package code;

import java.util.Scanner;

public class MainDrive {

	public static void main(String[] args) {
		
//		김성일의 작업 브런치입니다
//		컴퓨터가 낸 문제를 471로 정의
		int[] computerQuestionArr = {4,7,1};
		
//		사용자에게 3자리 숫자를 입력받자
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("3자리 숫자를 입력하세요 : ");
			int userInput = scan.nextInt();
			
//			사용자가 123 입력 => {1,2,3} 배영로 저장.
//			사용자가 입력한 세자리 숫자를 저장할 배열.
			int[] userInputNumArr = new int[3];
			
//			1. 맨 압자리 숫자를 0번칸에 저장한다. 123=> 1을 0번칸에 저장.
			userInputNumArr[0] = userInput / 100;
			
//			2. 가운데 숫자를 1번칸에 저장. 423 => 2를 1번칸에
			userInputNumArr[1] = userInput /10 % 10;
			
//			3. 마지막 숫자를 2번칸에 저장. 423 => 3을 2번칸에
			userInputNumArr[2] = userInput % 10;
			
			for (int i = 0; i < userInputNumArr.length; i++) {
				System.out.println(userInputNumArr[i]);
	
		}
					
			
		}
	}
}
