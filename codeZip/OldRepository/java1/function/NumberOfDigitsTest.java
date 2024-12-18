package OldRepository.java1.function;

import java.util.Scanner;

public class NumberOfDigitsTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("정수 입력: ");
        int n = input.nextInt();
        int result1 = powerOfTen(n);
        int result2 = numberOfDigits(n);
        System.out.printf("%d자리 수입니다.", result2);

    }

    /**
     * 10의 거듭제곱 수를 만들어준다.
     * 10의 0거듭제곱은 1이다.
     *
     * @ param n 몇 거듭제곱을 할 것인지 지정, n>=0
     * @ return 10의 n거듭제곱수.
     */
    public static int powerOfTen(int n) {
        int i = 1;
        while (n / i != 0) {
            i = 10 * i;
        }
        return i/10;

    }
    /**
     * 주어진 정수가 몇자리 수인지 알아낸다.
     * @ param n 주어진 정수, 0이 아니어야 한다.
     * @ return n이 몇 자리 수인지
     */
    public static int numberOfDigits (int n) {
        int j = powerOfTen(n);
        int count = 0;
        for (int i = 1; j/i > 1; i=i*10){
            count++;
        }
        return count+1;
    }

}