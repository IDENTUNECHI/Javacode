package java2.week8_Generics;
import java.util.List;
import java.util.LinkedList;

public class ListReverserTest {
    public static void main(String[] args) {

        List<Number> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(-1);
        list.add(3.3);
        list.add(10.5f);
        System.out.println(list);

        ListReverser.reverse(list);
        System.out.println(list);
        System.out.println();
    }
}
