package homework.w13;
import java.util.Scanner;

/**
 * 1부터 주어진 양의 정수까지의 합을 출력
 * @author 김이든
 */

public class Summation {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("n: ");
        int n = input.nextInt();

        System.out.print("sum = "+ sum(n));
    }

    /**
     * 1부터 주어진 양의 정수까지의 합을 재귀알고리즘으로 구현한다.
     * @param n 주어진 양의 정수
     * @return 1부터 n까지의 합
     */
    public static long sum(int n){
        if(n==1)
            return 1;
        else
            return n + sum(n-1);
    }
}
