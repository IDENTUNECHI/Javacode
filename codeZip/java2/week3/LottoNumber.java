package java2.week3;

import java.util.Random;
import java.util.Scanner;

/**
 * 6자리 로또 번호 추천 프로그램
 * @author 김이든
 */
public class LottoNumber {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Seed: ");
        long seed = input.nextLong();
        Random generator = new Random(seed);

        for(int i=0; i<6; i++){
            int num = generator.nextInt(50);
            System.out.print(num+" ");
        }
    }
}
