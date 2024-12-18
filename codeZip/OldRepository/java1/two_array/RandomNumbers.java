package OldRepository.java1.two_array;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * int 타입 배열에 0 이상 10 미만 정수 난수를 넣은 후
 * 배열의 각 원소를 차례로 출력하는 프로그램
 * @author 김이든
 */

public class RandomNumbers
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Seed: ");
        long seed = input.nextLong();
        Random generator = new Random(seed);
        System.out.println(Arrays.toString(makeRandomArray(20, 10, generator)));

    }

    /**
     * 배열을 만들고,
     * 0 이상 max 미만의 정수 난수를 size번 발생시켜
     * 이들을 배열에 저장한 후 배열을 가리키는 참조변수를 반환한다.
     * @param size 배열의 크기(난수 개수).
     * @param max 0 이상, max 미만인 난수를 발생시키도록 함.
     * @param generator 난수를 만들 때 사용할 난수발생기.
     */
    public static int[] makeRandomArray(int size, int max, Random generator)
    {
        int [] a = new int[size];
        for(int i = 0; i<a.length; i++) {
            a[i] = generator.nextInt(max);
        }
        return a;
    }

}

