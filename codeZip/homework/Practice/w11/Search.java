package homework.Practice.w11;

/**
 * 선형탐색과 이진탐색 알고리즘
 * @author 김이든
 */
import java.util.*;

public class Search {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 5};
        System.out.print("배열a: ");
        ArrayUtil.printArray(a, a.length);
        System.out.println();
        // linearSearch 테스트
        System.out.println("linearSearch 테스트 ===");
        System.out.println("linearSearch(a, a.length, 5): "+linearSearch(a, a.length, 5));
        System.out.println("linearSearch(a, 1, 1): "+linearSearch(a, 1, 1));
        System.out.println("linearSearch(a, 4, 5): "+linearSearch(a, 4, 5));
        System.out.println("linearSearch(a, 1, 2): "+linearSearch(a, 1, 2));

        System.out.println("linearSearch(a, a.length, 2): "+linearSearch(a, a.length, 2));
        System.out.println("linearSearch(a, 0, 5): "+linearSearch(a, 0, 5));
        System.out.println("linearSearch(a, a.length, 4): "+linearSearch(a, a.length, 4));

        // binarySearch 테스트 ===
        System.out.println("binarySearch 테스트 ===");
        System.out.print("InsertionSort.sort(a, a.length): ");
        InsertionSort.sort(a,a.length);
        ArrayUtil.printArray(a, a.length);
        System.out.println();
        System.out.println("binarySearch(a, a.length, 5): "+ binarySearch(a, a.length, 5));
        System.out.println("binarySearch(a, 1, 1): "+ binarySearch(a, 1, 1));
        System.out.println("binarySearch(a, 4, 5): "+ binarySearch(a, 4, 5));
        System.out.println("binarySearch(a, 1, 2): "+ binarySearch(a, 1, 2));

        System.out.println("binarySearch(a, a.length, 2): "+ binarySearch(a, a.length, 2));
        System.out.println("binarySearch(a, 0, 5): "+ binarySearch(a, 0, 5));
        System.out.println("binarySearch(a, a.length, 4): "+ binarySearch(a, a.length, 4));



    }

    /**
     * 선형탐색(Linear Search) - 배열 x의 앞 n개의 방에 key가 들어 있는가?
     *
     * @param x
     * @param n
     * @param key
     * @return i || -1
     */
    public static int linearSearch(int[] x, int n, int key) {
        int index = 0;

        if(n==0){
            index = -1;
        }
        else{
            for (int i=0; i<n; i++){
                if(x[i] == key){
                    index = i;
                    break;
                }
                else{
                    index = -1;
                }
            }
        }
        return index;
    }

    /**
     * 이진 탐색 (binary search)
     * 전제조건: 배열 x가 이미 오름차순으로 정렬되어 있다.
     * 배열에는 데이터가 꽉 차 있지 않을 수 있따.
     *
     * @param x 정렬된 정수 배열
     * @param n x에 들어있는 데이터 개수
     * @param key 찾을 데이터
     * @return
     *  x 내에서 key의 위치 (인덱스), key가 x에 있는 경우
     *  (key가 x내에 여러 개 있는 경우에는 그 중 어느 하나의 인덱스)
     *  -1, key가 x에 없는 경우
     */
    public static int binarySearch(int[] x, int n, int key){
        int lo = 0; //인덱스값들
        int hi = n-1;
        int mid;

        while(hi >= lo){
            mid = (hi+lo)/2;
            if(key == x[mid])
                return x[mid];

            if(key < x[mid]){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return -1;
    }
}

/**
 * 삽입정렬 프로그램
 * @author 김이든
 */
class InsertionSort {
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



