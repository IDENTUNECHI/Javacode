package java2.week8_Generics;
import java.util.*;

/**
 * Double[]은 Number[]의 서브클래스인가?
 */

public class ArrayReverserTest {
    public static void main(String[] args) {

        Number[] a = new Number[5];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = -1;
        a[4] = 3;
        System.out.println(Arrays.toString(a));

        ArrayReverser.reverseArray(a);
        System.out.println(Arrays.toString(a));
        System.out.println();

        Number[] b = new Number[5];
        b[0] = 1.1;
        b[1] = 2.2;
        b[2] = 3.3;
        b[3] = -1.1;
        b[4] = 3.3;
        System.out.println(Arrays.toString(b));

        ArrayReverser.reverseArray(b);
        System.out.println(Arrays.toString(b));
        System.out.println();


    }
}
