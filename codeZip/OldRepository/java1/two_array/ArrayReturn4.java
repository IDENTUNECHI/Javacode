package OldRepository.java1.two_array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 배열을 반환하는 메소드를 이용하는 문제
 * 두 개의 배열을 연결한다.
 * 두 개의 배열의 크기는 미리 정해져 있지 않다.
 * 두 배열의 크기는 데이터 파일에 들어 있는 데이터 수에 따라 정해진다.
 * @author 김이든
 */

public class ArrayReturn4
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Seed: ");
        long seed = input.nextLong();
        System.out.print("첫 배열 크기: ");
        int a1_size = input.nextInt();
        System.out.print("두 번째 배열 크기: ");
        int a2_size = input.nextInt();

        int [] a1 = new int [a1_size];
        int [] a2 = new int [a2_size];
        Random generator = new Random(seed);

        for (int i=0; i<a1_size; i++){
            a1[i] = generator.nextInt(100);
        }
        for (int i=0; i<a2_size; i++){
            a2[i] = generator.nextInt(100);
        }
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(catArrays(a1, a2)));
    }


    /**
     * 배열 a1과 a2를 연결한 새 배열을 반환한다.
     * 만약 a1에 1 2 3이 들어 있고 (a1의 크기는 3)
     * a2에 5 6이 들어 있다면 (a2의 크기는 2)
     * 이 둘을 연결한 새 배열에는 1 2 3 4 5가 들어 있으며
     * 새 배열의 크기는 5이다.
     * a1과 a2는 변경되지 않는다.
     * @param a1 배열
     * @param a2 배열
     * @return a1과 a2를 연결한 새 배열 (정확히는, 새 배열을 가리키는 참조)
     */
    public static int[] catArrays(int[] a1, int[] a2)
    {
        int [] sum = new int[a1.length + a2.length];
        for (int i = 0; i< a1.length; i++){
            sum[i] = a1[i];

        }
        for (int i = a1.length; i< a1.length + a2.length; i++){
            sum[i] = a2[i-a1.length];
        }
        return sum;
    }
}

