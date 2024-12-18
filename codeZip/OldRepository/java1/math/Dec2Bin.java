package OldRepository.java1.math;

import java.util.Scanner;

/**
* 10진수를 2진수로 변환하는 프로그램     
 remain값을 문자열로 변환한 다음 binary에 저장.
    다시 binary를 뒤에 배치함으로써 역순으로 출력이 가능했다.
*
*@author 김이든
*/
public class Dec2Bin {
	public static void main(String[] args){
		
		System.out.print("자연수 하나를 십진수로 입력하시오: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String binary = "";
		
		while (n > 0){
			int remain = n % 2;
			binary = remain + binary;
			n /= 2;
		}
		System.out.println(binary);
	
	}
}
