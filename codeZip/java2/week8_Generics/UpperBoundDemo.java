package java2.week8_Generics;
import java.util.*;

public class UpperBoundDemo {
    public static void main(String[] args) {

        List<Number> ln = new ArrayList<>();
        ln.add(1);
        ln.add(5.3);
        ln.add(1.1f);
        System.out.println(ln);

        List<Number> ln2 = new ArrayList<>();
        ln2.add(10);
        ln2.add(100.3);
        ln.addAll(ln2);  // List<Number> 에 addAll을 호출하면서 List<Integer>를 인자로 준다.
        System.out.println(ln);

        List<Integer> li = new ArrayList<>();
        li.add(-1);
        li.add(-100);
        ln.addAll(li);  // List<Number> 에 addAll을 호출하면서 List<Integer>를 인자로 준다.
        System.out.println(ln);
    }
}