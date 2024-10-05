package java1.Practice.w13;

import java.util.Scanner;

/**
 * 주어진 두 개의 정수 사이의 합을 출력
 * @author 김이든
 */

public class Summation2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("정수 두 개 입력: ");
        int m = input.nextInt();
        int n = input.nextInt();
        System.out.print("sum = "+sum(m, n));
    }

    /**
     * 주어진 두 개의 정수 사이의 모든 정수들의 합을 재귀알고리즘으로 구현
     * 두 개의 주어진 정수를 포함하여 계산한다.
     * 첫 정수가 두 번째 정수보다 같거나 작아야 한다.
     * @param m 주어진 양의 정수(m<=n)
     * @param n 주어진 양의 정수.
     * @return m부터 n까지의 합
     */
    public static long sum(int m, int n){
        if(n==m)
            return n;

        if(m<n){
            return n + sum(m, n-1);
        }
        else{
            return m + sum(m-1,n);
        }

    }
}

