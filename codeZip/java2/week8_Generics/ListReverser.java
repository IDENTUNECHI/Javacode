package java2.week8_Generics;
import java.util.*;

/**
 * List<Double>은 List<Number>의 서브클래스인가?
 *
 * List<Double>과 List<Number>의 서브타입이 아니므로
 * 이들의 원소 순서를 바꾸기 위해
 * List<Number> 타입 파라미터를 갖는 ListReverser.reverse를 사용할 수 없다.
 */

public class ListReverser {
    /**
     * 리스트의 원소 순서를 뒤집어준다.
     * @param list 주어진 리스트.
     */
    public static void reverse(List<Number> list){
        Collections.reverse(list);
    }
}
