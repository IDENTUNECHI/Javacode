package java2.week8_Generics;
import java.util.*;

/**
 * 제네릭 메소드 사용
 */
public class ReplaceAllDemo {
    public static void main(String[] args) {

        List<Integer> li = Arrays.asList(1, 2, 3, -1, 3);
        System.out.println("List<Integer>: " + li);
        li.set(2, 30);
        li.set(4, 30);
        System.out.println("Replace all 3's with 30.");
        System.out.println(li);

        System.out.println();

        List<Float> li1 = Arrays.asList(1.0f, 2.0f, 3.0f, -1.0f, 3.0f);
        System.out.println("List<Float>: " + li1);
        li1.set(2, 30.0f);
        li1.set(4, 30.0f);
        System.out.println("Replace all 3.0's with 30.0.");
        System.out.println(li1);

        System.out.println();

        List<String> li2 = Arrays.asList("Spring", "Summer", "Fall","Winter","Spring","Spring");
        System.out.println("List<String>: " + li2);
        li2.set(0,"Summer");
        li2.set(4,"Summer");
        li2.set(5,"Summer");
        System.out.println("Replace all \"Spring\"s with \"Summer\".");
        System.out.println(li2);
    }
}
