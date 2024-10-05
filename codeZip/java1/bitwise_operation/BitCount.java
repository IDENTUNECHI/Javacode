package java1.bitwise_operation;

//package week13;

import java.util.Scanner;

/**
 * 주어진 정수의 비트 표현에서 1의 갯수를 출력
 * @author 김이든
 */

public class BitCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("32-bit integer: ");
        int input = scan.nextInt();
        int count = bitCount(input);
        System.out.printf("%d has %d number of '1's", input, count);
        scan.close();

    }

    /** bitCount
     * 정수 input을 입력으로 받아 32비트 표현형에서 1의 개수를 세어 반환한다.
     * @param input input 주어진 32bit 정수
     * @return count 1의 갯수 카운트
     */
    public static int bitCount(int input) {
        int count = 0;
        int mask = 1 << 31;
        while(mask != 0) {

            if ((input & mask) != 0) {
            count++;
            }
            mask = mask >>> 1;
    }

        return count;
    }
}

