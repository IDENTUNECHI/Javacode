package java1.Practice.w11;

import java.util.Scanner;
import java.util.Random;

public class ArrayUtil {
    public static void main(String[] args){
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++)
            a[i] = i;

        Scanner input = new Scanner(System.in);
        System.out.print("Seed: ");
        long seed = input.nextLong();
        input.close();

        Random generator = new Random(seed);


        // printArray 테스트
        System.out.println("printArray 테스트 ===");

        System.out.print("printArray(a, 0): ");
        printArray(a, 0);
        System.out.print("printArray(a, 1): ");
        printArray(a, 1);
        System.out.print("printArray(a, a.length): ");
        printArray(a, a.length);
        System.out.print("printArray(a, a.length+1): ");
        printArray(a, a.length + 1);
        System.out.print("printArray(a, -1): ");
        printArray(a, -1);
        System.out.println();

        // fillRandom 테스트
        System.out.println("fillRandom 테스트 ===");

        System.out.print("fillRandom(a, 10, generator): ");
        fillRandom(a, 10, generator);


        System.out.print("fillRandom(a, 100, generator): ");
        fillRandom(a, 100, generator);


        System.out.print("fillRandom(a, 2, generator): ");
        fillRandom(a, 2, generator);

        System.out.print("fillRandom(a, 1, generator): ");
        fillRandom(a, 1, generator);


        // 채워 넣으세요.

        System.out.println();

        // distinct 테스트
        System.out.println("distinct 테스트 ===");

        int[] a2 = {1, 1, 2};
        System.out.println("a2 = {1, 1, 2}");
        System.out.println("distinct(a2, 1): " + distinct(a2, 1));
        System.out.println("distinct(a2, 2): " + distinct(a2, a2.length));
        System.out.println("distinct(a2, a2.length): " + distinct(a2, a2.length));
        System.out.println("distinct(a2, a2.length + 1): " + distinct(a2, a2.length + 1));
        System.out.println("distinct(a2, 0): " + distinct(a2, 0));
        System.out.println("distinct(a2, -1): " + distinct(a2, -1));

        int[] a3 = {1, 2, 3};
        System.out.println("a3 = {1, 2, 3}");
        System.out.println("distinct(a3, a3.length): " + distinct(a3, a3.length));
        System.out.println("distinct(a3, a3.length + 1): " + distinct(a3, a3.length + 1));

        int[] a4 = {1};
        System.out.println("a4 = {1}");
        System.out.println("distinct(a4, a4.length): " + distinct(a4, a4.length));
        System.out.println("distinct(a4, a4.length + 1): " + distinct(a4, a4.length + 1));

        int[] a5 = {};
        System.out.println("a5 = {}");
        System.out.println("distinct(a5, a5.length): "+ distinct(a4, a4.length));
        System.out.println("distinct(a5, a5.length + 1): "+ distinct(a5, a5.length + 1));

        System.out.println();


//		for (int i = 0; i < 20; i++)
//			System.out.print(generator.nextInt(10) + " ");

        // fillRandomDistinct 테스트
        System.out.println("fillRandomDistinct 테스트 ===");

        System.out.println("크기가 10인 배열 a");

        System.out.print("fillRandomDistinct(a, 10, generator): ");
        fillRandomDistinct(a, 10, generator);
        printArray(a, a.length);
        System.out.println("distinct?: " + distinct(a, a.length));

        System.out.print("fillRandomDistinct(a, 100, generator): ");
        fillRandomDistinct(a, 100, generator);
        printArray(a, a.length);
        System.out.println("distinct?: " + distinct(a, a.length));

        System.out.print("fillRandomDistinct(a, 1, generator): ");
        fillRandomDistinct(a, 1, generator);
        System.out.println();
        printArray(a, a.length);
        System.out.println("distinct?: " + distinct(a, a.length));

        System.out.print("fillRandomDistinct(a, 0, generator): ");
        fillRandomDistinct(a, 0, generator);
        System.out.println();
        printArray(a, a.length);
        System.out.println("distinct?: " + distinct(a, a.length));

        System.out.print("fillRandomDistinct(a, -1, generator): ");
        fillRandomDistinct(a, -1, generator);
        System.out.println();
        printArray(a, a.length);
        System.out.println("distinct?: " + distinct(a, a.length));

        System.out.println("크기가 1인 배열 a6");
        int[] a6 = new int[1];
        System.out.print("fillRandomDistinct(a6, 1, generator): ");
        fillRandomDistinct(a6, 1, generator);
        printArray(a6, a6.length);
        System.out.println("distinct?: " + distinct(a6, a6.length));

        System.out.println("크기가 0인 배열 a7");
        int[] a7 = new int[0];
        System.out.print("fillRandomDistinct(a7, 0, generator): ");
        fillRandomDistinct(a7, 0, generator);
        printArray(a7, a7.length);
        System.out.println("distinct?: " + distinct(a7, a7.length));

        System.out.println();

        // makeRandomArray 테스트
        System.out.println("makeRandomArray 테스트 ===");

        System.out.print("makeRandomArray(10, 10, generator): ");
        printArray(makeRandomArray(10, 10, generator), 10);

        System.out.print("makeRandomArray(10, 1, generator): ");
        printArray(makeRandomArray(10, 1, generator), 10);

        System.out.print("makeRandomArray(1, 10, generator): ");
        printArray(makeRandomArray(1, 10, generator), 1);

        System.out.print("makeRandomArray(1, 1, generator): ");
        printArray(makeRandomArray(1, 1, generator), 1);

        System.out.print("makeRandomArray(0, 1, generator): ");
        printArray(makeRandomArray(0, 1, generator), 1);

    }

    /**
     * 배열의 앞에 있는 n개의 원소들을 출력하고 마지막에 new line을 출력한다.
     * n> a.length 인 경우에는 a.length 개의 원소를 출력한다.
     * n이 0이하인 경우에는 아무것도 출력하지 않는다.
     * @param a 배열
     * @param n 출력할 원소의 개수
     */
    public static void printArray(int[] a, int n){
        if(n>0) {

            if(n==a.length+1) {
                for (int i = 0; i < n - 1; i++) {
                    System.out.print(a[i] + " ");
                }
                System.out.println();
            }
            else{
                for (int i = 0; i < n; i++) {
                    System.out.print(a[i] + " ");
                }
                System.out.println();
            }

        }

        else{
            System.out.println();
        }

    }

    /**
     * 배열 list에 0 이상 uBound (Upper Bound) 미만 정수 난수를 채워준다. 난수는 중복가능.
     * uBound가 1 이하인 경우에는 1로 설정한다.
     * @param list list 난수를 채울 배열
     * @param uBound 난수의 최대값+1
     * @param generator 난수발생기
     */

    public static void fillRandom(int[] list, int uBound, Random generator){
        for (int i=0; i<list.length; i++){
            list[i] = generator.nextInt(uBound);
            System.out.print(list[i]+" ");
        }
        System.out.println();
    }

    /**
     * 배열의 앞 n개 방(0번부터 n-1번)의 원소들이 서로 다른지 검사한다.
     * 원소들이 서로 다른가?
     * n > a.length 일 때는 n == a.length 일 때와 똑같이 작동한다.
     * Search6.linearSearch 메소드 사용
     * @param a 배열
     * @param n 배열에 앞 몇 개 방에 중복 여부 검사를 할 것인가?
     * @return true, 배열의 앞 n개 원소들이 모두 다른 경우
     *         false, 배열의 앞 n개 방에 중복된 원소가 있는 경우
     */

    public static boolean distinct(int[] a, int n){
        int i;
        boolean distinct = true;
        if(a.length<=1 || n<=1){
            distinct = true;
        }

        else if(a.length<n){
            for (i = 0; i < n-2; i++) {
                if (a[i] == a[i+1]) {
                    distinct = false;
                    break;
                }
            }
        }

        else {
            for (i = 0; i < n-1; i++) {
                if (a[i] == a[i+1]) {
                    distinct = false;
                    break;
                }
                else {
                    distinct = true;
                }
            }
        }
        return distinct;
    }

    /**
     * 배열 list에 0이상 uBound 미만 "서로 다른" 정수 난수를 채워준다.
     * 이 메소드를 호출하는 자는 아래 전제조건을 지켜야한다.
     * 전제조건: uBound >= list.length
     * 이 메소드를 호출하는 자가 위 전제조건을 지키지 않으면
     * 배열을 난수로 채우지 않고 에러 메세지를 출력하고 리턴한다.
     * @param list 난수를 채울 배열
     * @param uBound uBound 난수의 최대값 +1
     * @generator 난수발생기
     */
    public static void fillRandomDistinct(int[] list, int uBound, Random generator){
        if(uBound< list.length){
            System.out.print("uBound >= list.length이어야 합니다. 배열의 내용이 변하지 않았습니다.");
            return;//return을 안해주면 값이 안나옴??
        }
        int index = 0;

        while (index < list.length){
            int randomNumber = generator.nextInt(uBound);
            if (Search6.linearSearch(list, index, randomNumber) == -1){
                list[index++] = randomNumber;
            }
        }

    }

    /**
     * 0이상 uBound 미만 정수 난수를 n번 발생시켜 이들을 배열에 저장한 후
     * 배열을 가리키는 참조변수를 반환한다.
     * 배열에는 같은 숫자가 중복될 수 있다.
     * @param n 난수 갯수, 배열의 크기(n이 음수이면 에러메세지를 출력하고 null을 반환)
     * @param uBound 난수의 최대값 +1
     * @generator 난수발생기
     */

    public static int[] makeRandomArray(int n, int uBound, Random generator){
        int[] list = new int[n];
        for (int i=0; i< n; i++){
            list[i] = generator.nextInt(uBound);
        }
        return list;
    }


}




class Search6 {

    /**
     * 선형탐색(Linear Search) - 배열 x의 앞 n개의 방에 key가 들어 있는가?
     *
     * @param x
     * @param n
     * @param key
     * @return i || -1
     */
    public static int linearSearch(int[] x, int n, int key) {
        int i;
        int index = 0;

        if(n==0){
            index = -1;
        }
        else {
            for (i = 0; i < n; i++) {
                if (x[i] == key) {
                    index = i;
                    break;
                } else {
                    index = -1;
                }
            }
        }
        return index;
    }
}








