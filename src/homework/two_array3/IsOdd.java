package homework.two_array3;

import java.util.Scanner;

/**
 * 홀수 여부 판별하기
 * @author 김이든
 */
public class IsOdd {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("32-bit integer: ");
        int input = scan.nextInt();

        if (isOdd(input)) System.out.println("홀수");
        else System.out.println("홀수 아님");
        scan.close();
    }

    /** isOdd
     * 정수 input이 홀수이면 true, 짝수이면 false를 반환한다.
     * @param input 주어진 32bit 정수
     * @return
     */
    public static boolean isOdd(int input) {
        boolean done = true;

        if(input%2==0){
            done = false;
            return done;
        }
        else{
            return done;
        }
    }
}