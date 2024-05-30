

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("밑수: ");
        int base = input.nextInt();
        System.out.print("지수: ");
        int expo = input.nextInt();
        System.out.printf("%d의 %d승 = %ld", base, expo, raise(base, expo));
    }

    /**
     * 거듭제곱을 재귀 방식으로 계산한다.
     * @param base 밑수 (0이 아닌 정수)
     * @param expo 지수 (음이 아닌 정수)
     * @return base의 expo 거듭제곱.
     */
    public static long raise(int base, int expo){
        if(base == 1)
            return 1;
        else
            return base * raise(base, expo);
    }
}
