package java1.bitwise_operation;

//package week13;

import java.util.Scanner;

/**
 * 2의 거듭제곱 수인지 판별하는 프로그램
 * @author 김이든
 */

public class IsPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("32-bit integer: ");
        int input = scan.nextInt();

        System.out.printf("%b", isPower(input));
        scan.close();
    }

    /** isPower
     * 양의 정수 input이 2의 지수승이면 true, 아니면 false를 반환한다.
     * @param input 양의 정수
     * @return bool
     */
    public static boolean isPower(int input) {
        boolean bool = false;
        if((input & input-1) == 0){
            bool = true;
            return bool;
        }
        return bool;
    }
}
