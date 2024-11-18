package java2.week8_Generics;
import java.util.*;

public class ArrayReverser {
    /**
     * 주어진 배열의 원소 순서를 뒤집어 준다.
     * @param array 주어진 배열
     */
    public static void reverseArray(Number[] array) {
        List<Number> list = Arrays.asList(array);

        Collections.reverse(list);

    }
}
