package java2.week8_Generics;
import java.util.*;

public class GenericReverser {
    /**
     * 제네릭 메소드 작성
     *
     * 리스트의 원소 순서를 뒤집어준다
     * @param list 주어진 리스트
     */
    public static <E> void reverse(List<E> list) {
        Collections.reverse(list);
    }
}
