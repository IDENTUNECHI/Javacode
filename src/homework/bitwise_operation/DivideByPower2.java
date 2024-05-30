package homework.bitwise_operation;

import java.util.Scanner;

/**
 *  2의 거듭제곱수으로 나눈 후 몫과 나머지 구하는 프로그램
 *  배열에 저장하여 출력
 *  @author 김이든
 */

public class DivideByPower2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("32-bit integer: ");
        int input = scan.nextInt();
        System.out.print("k: ");
        int k = scan.nextInt();

        int[] results = getQuotientAndRemainder(input, k);

        System.out.printf("%d / 2의%d승 = %d\n", input, k, results[0]);
        System.out.printf("%d %% 2의%d승 = %d", input, k, results[1]);
        scan.close();
    }

    /** getQuotientAndRemainder
     * 정수 input을 2의 k승으로 나눈 후 몫을 반환한다.
     * @param input 주어진 수, 0 이상의 값
     * @param k 2의 몇 승으로 나눌 것인지. 0 이상의 정수
     * @return [quotient, remainder]
     */
    public static int[] getQuotientAndRemainder(int input, int k){
    int [] result = new int [2];
    int power = 1;
    result[0] = input >> k;
        for(int i=0; i<k; i++){
            power = power*2;
        }
        int remainder = input & (power-1);

        result[1] = remainder;
     return result;
    }
}

