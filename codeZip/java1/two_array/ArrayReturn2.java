package java1.two_array;

import java.util.Arrays;

/**
 * 배열을 반환하는 메소드를 이용하는 문제
 * 지정된 크기의 배열을 반환하는 메소드를 호출한 후
 * 반환된 배열의 내용을 출력하는 작업을 반복한다.
 * 메소드가 얼마나 큰 배열을 만들게 할지는
 * 메소드를 호출할 때 인수를 통해 지정해 준다.
 * @author 김이든
 */

public class ArrayReturn2{

    public static void main(String[] args)
    {

        int[] array;

        // 파라미터를 갖지 않는 makeArray 메소드를 호출하여 반환된 배열을 출력한다.

        array = makeArray();
        System.out.println(Arrays.toString(array));
        System.out.println();

        // 파라미터를 하나 갖는 makeArray 메소드를 호출하여 반환된 배열을 출력하는 일을
        // 10번 반복한다.
        // 파라미터를 하나 갖는 makeArray 메소드를 호출할 때 메소드로 넘겨주는 인자는
        // 1부터 시작하여 10까지 증가시킨다.
        for(int n = 1; n<=10; n++){
            array = makeArray(n);
            System.out.println(Arrays.toString(array));

        }

    }

    /**
     * 크기가 10인 int 배열을 구성한 후
     * 0번 방에는 0*0을,
     * 1번 방에는 1*1을
     * ...
     * 9번 방에는 9*9를 저장하고
     * 배열을 반환한다.
     * 배열을 반환한다는 것은 곧 배열을 가리키는 참조(reference)를 반환한다는 말이다.
     * @return 배열을 가리키는 참조
     */
    public static int[] makeArray()
    {
        int[] a = new int[10];
        for(int i =0; i< a.length; i++){
            a[i] = i*i;
        }

        return a;
    }

    /**
     * 크기가 n인 int 배열을 구성한 후
     * 0번 방에는 0*0을,
     * 1번 방에는 1*1을
     * ...
     * n-1번 방에는 (n-1)*(n-1)을 저장하고
     * 배열을 반환한다.
     * 배열을 반환한다는 것은 곧 배열을 가리키는 참조(reference)를 반환한다는 말이다.
     * @param n 배열의 크기
     * @return 배열을 가리키는 참조
     */
    public static int[] makeArray(int n){
        int[] a = new int[n];
        for(int i =0; i< a.length; i++){
            a[i] = i*i;
        }

        return a;
    }
}

