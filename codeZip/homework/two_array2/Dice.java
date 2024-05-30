package homework.two_array2;

import java.util.Scanner;
import java.util.Random;

/**
 * 각 수가 나온 횟수를 저장하기 위한 배열
 * // occurence 배열 구성
 * // 배열의 크기는 num_dice에 따라 달라진다.
 * //
 * // (예)
 * // num_dice가 2일때는 13개의 방(0번부터 12번)을 만들어
 * // 0번, 1번은 사용하지 않고 2번부터 12번 방까지 사용한다.
 * // (주사위 합이 0, 1인 경우는 없다.)
 * // 주사위 합이 2인 횟수는 2번 방에, 3인 횟수는 3번 방에,
 * //... 12인 횟수는 12번 방에 저장한다.
 * //
 * // num_dice가 3일때는 19개의 방(0번 부터 18번)을 만들어
 * //0번, 1번, 2번은 사용하지 않고 3번부터 18번 방까지 사용한다.
 */
public class Dice {
    public static void main(String[] args) {
        System.out.print("Seed: ");
        Scanner input = new Scanner(System.in);
        long seed = input.nextLong();
        Random generator = new Random(seed);

        System.out.print("한 번에 던질 주사위 갯수: ");
        int num_dice = input.nextInt();

        System.out.print("몇 번 던질 것인가: ");
        int trials = input.nextInt();

        int[] occurence = new int[6 * num_dice + 1]; // 각 수가 나온 횟수를 저장하기 위한 배열

        for (int i = 0; i < trials; i++) {
            int sum = castDice(num_dice, generator);
            occurence[sum] += 1;
        }

        for (int i = num_dice; i <= num_dice * 6; i++) {
            System.out.println(i + " 횟수:  " + occurence[i]);
        }


    }

    /**
     * @param num_dice  주사위 몇 개를 던질지
     * @param generator 난수발생기
     * @return sum 여러개의 주사위를 던져 나온 수의 합
     */

    public static int castDice(int num_dice, Random generator) {
        int sum = 0;
        int result = 0;
        for (int i = 0; i < num_dice; i++) {
            result = generator.nextInt(6) + 1;
            sum += result;
        }

        return sum;
    }
}

