package homework.Recursion_Function;

import java.util.Scanner;

/**
 * 주어진 양의 정수의 계승을 출력
 * @author 김이든
 */
public class Factorial2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int count = 0;
        System.out.print("n: ");
        int n= input.nextInt();
        System.out.print(n+"! = "+ factorial(n, count));
    }

    /**
     * 주어진 양의 정수의 계승을 재귀 알고리즘으로 계산한다.
     * 재귀 호출의 가장 깊은 곳에 다다르면 재귀호출의 깊이를 출력한다
     * @param n 주어진 양의 정수
     * @param count 재귀 호출의 깊이
     * @return n!
     */
    public static long factorial(int n, int count){
        if(n<=1){
            System.out.println("재귀호출의 깊이 = "+ count);
            return 1;
        }
        else {
            count++;
            return n * factorial(n - 1, count);
        }
    }
}
