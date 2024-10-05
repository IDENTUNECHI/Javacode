package java1.two_array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 배열을 반환하는 메소드를 이용하는 문제
 * 두 개의 배열을 더한다.
 * @author 김이든
 */

class ArrayReturn3 {

    public static void main(String[] args){
        int [] a1 = new int [10];
        int [] a2 = new int [10];
        Scanner input = new Scanner(System.in);
        System.out.print("Seed: ");
        Long seed = input.nextLong();
        Random generator = new Random(seed);
        for(int i =0; i< a1.length; i++){
            a1[i] = generator.nextInt(100);
        }
        for(int i =0; i< a1.length; i++){
            a2[i] = generator.nextInt(100);
        }




        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(addArrays(a1,a2)));

    }

    /**
     * 배열 a1과 a2를 더한다.
     * 전제조건: a1과 a2의 크기는 같다.
     * a1, a2와 크기가 같은 새 배열을 구성하고
     * 이 배열에 a1과 a2를 더한 결과를 저장한 후
     * 새 배열을 가리키는 참조를 반환한다.
     * @param a1 배열
     * @param a2 배열
     * @return a1 + a2 결과를 저장한 새 배열 (정확히는, 새 배열을 가리키는 참조)
     */
    public static int[] addArrays(int[] a1, int[] a2)
    {
        int [] sum = new int[10];
        for (int i =0 ; i< sum.length; i++){
            sum[i] = a1[i] + a2[i];
        }
        return sum;
    }

}