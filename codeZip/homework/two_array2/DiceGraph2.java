package homework.two_array2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DiceGraph2 {

        /** 각 수가 나온 횟수를 저장하기 위한 배열
         // occurence 배열 구성
         // 배열의 크기는 num_dice에 따라 달라진다.
         //
         // (예)
         // num_dice가 2일때는 13개의 방(0번부터 12번)을 만들어
         // 0번, 1번은 사용하지 않고 2번부터 12번 방까지 사용한다.
         // (주사위 합이 0, 1인 경우는 없다.)
         // 주사위 합이 2인 횟수는 2번 방에, 3인 횟수는 3번 방에,
         //... 12인 횟수는 12번 방에 저장한다.
         //
         // num_dice가 3일때는 19개의 방(0번 부터 18번)을 만들어
         //0번, 1번, 2번은 사용하지 않고 3번부터 18번 방까지 사용한다.
         */

        public static void main(String[] args) {
            final int height = 50;
            System.out.print("Seed: ");
            Scanner input = new Scanner(System.in);
            long seed = input.nextLong();
            Random generator = new Random(seed);

            System.out.print("한 번에 던질 주사위 갯수: ");
            int num_dice = input.nextInt();

            System.out.print("몇 번 던질 것인가: ");
            int trials = input.nextInt();

            int[] occurence = new int[6*num_dice +1]; // 각 수가 나온 횟수를 저장하기 위한 배열

            for(int i=0; i<trials; i++){
                int sum = castDice(num_dice, generator);
                occurence[sum] += 1;
            }

            for (int i=num_dice; i<=num_dice*6; i++){
                System.out.println(i+"이 나온 횟수: "+ occurence[i]);
            }
            System.out.println();

            graph(occurence, height, num_dice);
        }

        /**
         *
         * @param num_dice 주사위 몇 개를 던질지
         * @param generator 난수발생기
         * @return sum 여러개의 주사위를 던져 나온 수의 합
         */

        public static int castDice(int num_dice, Random generator){
            int sum = 0;
            int result = 0;
            for(int i=0; i<num_dice; i++){
                result = generator.nextInt(6) + 1;
                sum += result;
            }
            return sum;
        }

    /**
     * 별 문자 하나가 의미하는 크기가 조정되도록 한다.
     *
     * height는 배열에 들어있는 숫자들 중 가장 큰 수를
     * 별 문자 몇개로 표현할 것인지를 지정해준다.
     * 배열에 들어 있는 수 중 가장 큰 수가 910이고
     * height가 50이라면
     * 별 문자 하나는 의미하는 크기가 조정되도록 한다.
     *
     * height는 배열에 들어 있는 숫자들 중 가장 큰 수를
     * 별 문자 몇개로 표현할 것인지를 지정해준다.
     * 배열에 들어 있는 수 중 가장 큰 수가 910이고 height가 50
     * 별 문자 하나는 910/50 == 18.2를 의미한다.
     *
     * 낮은 번호의 방에는 모두 0이 들어 있으므로 이 방들의 숫자는 그리지 않는다.
     * from으로 지정된 방 번호 이상의 방에 있는 숫자들만 그래프로 그린다.
     *
     * @param a 배열
     * @param height 그래프의 최대 높이
     *               가장 큰 수를 별 문자 몇 개로 그릴 것인가를 나타냄
     * @param from a의 몇번 방부터 그릴 것인가?
     */
    public static void graph(int[] a, int height, int from){
        int max = Arrays.stream(a).max().getAsInt();

        double length = (double)max/50;
        for (int i=from; i<=from*6; i++){
            System.out.print(i+":"+a[i]+"   ");
            double n = Math.round(a[i]/length);
            for(int j=0; j<n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        }
}




