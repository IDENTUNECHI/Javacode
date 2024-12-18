package OldRepository.java1.Practice.w12;

import java.util.Scanner;
/**
 * 임의의 정수 x와 k가 주어졌을 때, x * 2^를 출력하는 프로그램
 * @author 김이든
 */
public class MultiPlyByPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("32-bit integer: ");
        int input = scan.nextInt();
        System.out.print("k: ");
        int k = scan.nextInt();

        System.out.printf("%d * 2의%d승 = %d", input, k, multiplyByPower(input, k));
        scan.close();
    }

    /** multiplyByPower
     * 정수 input을 2의 k승으로 곱한 값 반환한다.
     * @param input 2의 n승에 곱해지는 수
     * @param k 2의 k승
     * @return result 최종 결과
     */
    public static int multiplyByPower(int input, int k){
        int result = input<<k;
        return result;
    }
}
