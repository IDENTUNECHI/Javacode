package OldRepository.java1.two_array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.sort;

/**
 * int 타입 배열에 0 이상 100 미만 정수 난수를 넣은 후
 * 배열의 각 원소를 차례로 출력하고
 * 원소들의 평균값을 출력하는 프로그램
 * @author 김이든
 */

public class RandomStatistics
{

    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        System.out.print("Seed: ");
        long seed = input.nextLong();
        Random generator = new Random(seed);
        int [] a= new int[10];
        fillArrayRandom(a, 100, generator);;
    }

    /**
     * 주어진 배열에 정수 난수를 채워준다.
     * @param a 난수를 저장할 배열.
     * @param max 0 이상 max 미만 난수 발생.
     * @param generator 난수를 만드는 데 사용할 난수발생기.
     */
    public static void fillArrayRandom(int[] a, int max, Random generator)
    {
        for(int i=0; i<a.length; i++){
            a[i] = generator.nextInt(max);
        }
        System.out.println(Arrays.toString(a));
        System.out.println("최소: "+ min(a));
        System.out.println("최대: "+ max(a));
        System.out.println("평균: "+ average(a));

    }

    /**
     * 주어진 배열의 원소 중 최대값을 찾아 반환한다.
     * @param a 배열을 카리키는 참조변수.
     * @return 원소들 중 최대값.
     */
    public static int max(int[] a) {
        sort(a);
        int max = a[a.length - 1];
        return max;
    }

    /**
     * 주어진 배열의 원소 중 최소값을 찾아 반환한다.
     * @param a 배열을 카리키는 참조변수
     * @return 원소들 중 최소값
     */
    public static int min(int[] a)
    {
        sort(a);
        int min = a[0];
        return min;
    }

    /**
     * 주이진 배열의 원소 중 평균값을 찾아 반환한다.
     * @param a 배열을 카리키는 참조변수.
     * @return 원소들의 평균값.
     */
    public static double average(int[] a)
    {
        int sum = 0;
        for(int i=0; i<a.length; i++){
            sum = sum+a[i];
        }
        double average = (double) sum/a.length;
        return average;
    }
}

