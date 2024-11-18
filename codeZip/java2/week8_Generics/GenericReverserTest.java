package java2.week8_Generics;
import java.util.*;

public class GenericReverserTest {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(-1);
        list.add(3);
        System.out.println(list);

        GenericReverser.reverse(list);
        System.out.println(list);
        System.out.println();

        List<Double> listed = new LinkedList<>();
        listed.add(1.1);
        listed.add(2.2);
        listed.add(3.3);
        listed.add(-1.1);
        listed.add(3.3);
        System.out.println(listed);

        GenericReverser.reverse(listed);
        System.out.println(listed);
        System.out.println();

    }
}
