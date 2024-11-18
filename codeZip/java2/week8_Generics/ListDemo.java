package java2.week8_Generics;
import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Number> list = new ArrayList<Number>();
        list.add(1);
        list.add(1.1f);
        System.out.println(list);

        list.add(Integer.valueOf(1)); // 권장되는 방법
        list.add(Float.valueOf(1.1f));  // 권장되는 방법
        System.out.println(list);
    }
}
