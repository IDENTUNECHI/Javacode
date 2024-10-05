package java1.two_array2;

import java.util.*;

/**
 * 삽입정렬 프로그램
 * @author 김이든
 */
public class InsertionSort {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Seed: ");
        long seed = input.nextLong();
        Random generator = new Random(seed);

        System.out.print("최대 난수는? ");
        int max = input.nextInt();

        //충분히 큰 배열에 난수를 채운다
        int[] numbers = new int[1000]; // 충분히 큰 배열
        ArrayUtil.fillRandom(numbers, max, generator);

        // 배열 중 앞 부분의 일부만 유효한 데이터로 간주한다.
        System.out.print("데이터 개수는? ");
        int size = input.nextInt();

        System.out.print("원 배열: ");
        ArrayUtil.printArray(numbers, size);
        sort(numbers, size);
        System.out.print("정렬된 배열: ");
        ArrayUtil.printArray(numbers, size);

        System.out.println();

        input.close();
    }

    /**
     * x[0], x[1], ..., x[i-1]가 이미 오름차순으로 정렬되어 있는 상태에서
     *x[i]를 그 앞의 올바른 위치에 삽입하여
     * x[0], x[1],..., x[i-1]는 이미 오름차순으로 정렬되어 있다.
     *      i는 배열 x의 크기보다 작다.
     * @param x 배열
     * @param i 올바른 위치를 찾아줄 원소의 인덱스
     */
     public static void insert(int[] x, int i){
         int temp = x[i];
         int j = i - 1;
         while(j >= 0 && temp < x[j]){
             x[j+1] = x[j];
             j--;
         }
         x[j+1] = temp;
     }

    /**
     * x[0], x[1], ..., x[n-1]를 정렬된 상태로 만든다.
     * @param x 배열
     * @param n 정렬할 원소의 개수
     */
     public static void sort(int[] x, int n){
         // insert(x, i) 메소드를 이용하여 아래 작업을 차례로 수행한다.
         // x[0] 이 정렬된 상태 --> x[0], x[n-2], x[n-1] 이 정렬된 상태로 만듦
         for(int i=0; i<n; i++){
          insert(x, i);
         }

     }

}
