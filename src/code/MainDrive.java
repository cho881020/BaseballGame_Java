package code;

import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class MainDrive {

	public static void main(String[] args) {
		
//		컴퓨터가 낸 문제를 471로 정의
		int [] computerQuestionArr = {4, 7, 1} ;
		
//		사용자에게 3자리 숫자를 입력받자.
		Scanner scan = new Scanner(System.in);
		System.out.print("3자리 숫자를 입력하세요 : ");
		int userInput = scan.nextInt();
		
//		사용자가 123 입력 => {1, 2, 3} 배열로 저장
//		사용자가 입력한 세자리 숫자를 저장할 배열.
		int [] userInputNumArr = new int[3];
		
//		1. 맨 앞자리 숫자를 0번칸에 저장한다. => 423 => 4을 0번칸에 저장. (100으로 나눈 몫을 구하면 되겠지)
		userInputNumArr[0] = userInput / 100;
		
//		2. 가운데 숫자를 1번칸에 저장. 423 => 2를 1번칸에 (뒤에껄 날리고 끝자리를 따겠다)
		userInputNumArr[1] = userInput / 10 % 10;
				
//		3. 마지막 숫자를 2번칸에 저장. 423 => 3을 2번칸에 (10으로 나눠서 나머지가 몇인지)
		userInputNumArr[2] = userInput % 10;
		
		for (int i=0 ; i < userInputNumArr.length ; i++) {
			System.out.println(userInputNumArr[i]);
			
		}
		
	}
}
