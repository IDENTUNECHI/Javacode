package java1.Recursion_Function;
import java.util.*;

/**
 * 주어진 양의 정수의 계승을 재귀 방식으로 계산
 * @author 김이든
 */

public class Factorial {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("n: ");
        int n = input.nextInt();

        System.out.print(n+"! = "+ factorial(n));

    }

    /**
     * 주어진 양의 정수의 계승을 재귀 알고리즘으로 계산한다.
     * @param n 주어진 양의 정수
     * @return n!
     */
    public static long factorial(int n){
        if(n==1)
            return 1;

        else
            return n*factorial(n-1);

    }
}
