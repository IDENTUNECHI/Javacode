package OldRepository.java1.bitwise_operation;

import java.util.Scanner;

/**
 * 2의 거듭제곱수으로 나눈 후 몫과 나머지 구하는 프로그램
 * @author 김이든
 */
public class DivideByPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("32-bit integer: ");
        int input = scan.nextInt();
        System.out.print("k: ");
        int k = scan.nextInt();

        int q = getQuotient(input, k);
        int r = getRemainder(input, k);

        System.out.printf("%d / 2의%d승 = %d\n", input, k, q);
        System.out.printf("%d %% 2의%d승 = %d", input, k, r);
        scan.close();
    }

    /** getQuotient
     * 정수 input을 2의 k승으로 나눈 후 몫을 반환한다.
     * @param input 주어진 수, 0 이상의 값
     * @param k 2의 몇 승으로 나눌 것인지. 0 이상의 정수
     * @return quotient
     */
    public static int getQuotient(int input, int k){
        int quotient = input >> k;
        return quotient;

    }

    /** getQuotient
     * 정수 input을 2의 k승으로 나눈 후 나머지를 반환한다.
     * @param input 주어진 수, 0 이상의 값
     * @param k 2의 몇 승으로 나눌 것인지. 0 이상의 정수
     * @return remainder
     */
    public static int getRemainder(int input, int k){
        int power = 1;
        for(int i=0; i<k; i++){
            power = power*2;
        }
        int remainder = input & (power-1);
        return remainder;

    }
}
