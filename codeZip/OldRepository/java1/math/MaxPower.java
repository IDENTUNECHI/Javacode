package OldRepository.java1.math;

import java.util.Scanner;

/**
	*주어진 수보다 작거나 같은 2의 거듭제곱수들 중 가장 큰 수를 구하는 프로그램
	* while의 범위를 power*2로 설정함으로써
		나누기 생략 가능
	*
	*@author 김이든
	*/
public class MaxPower {
	public static void main(String[] args){
		
		System.out.print("자연수 하나를 입력하시오: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int power = 1;
		
		while (power*2<=n){
			power = power*2;
		}
		
		System.out.println(n + "보다 작거나 같은 2의 거듭제곱수들 중 가장 큰 수 = "+ power);
	
	}
}