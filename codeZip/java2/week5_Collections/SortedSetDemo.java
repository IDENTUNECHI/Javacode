package java2.week5_Collections;



import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {

    public static void main(String[] args) {

        // SortedSet은 Set의 서브인터페이스이다.
        // SortedSet은 원소들의 순서를 관리하는 Set이다.
        // TreeSet은 SortedSet이다. ==  TreeSet은 SortedSet 인터페이스를 구현한 글래스이다.
        SortedSet<Integer> s = new TreeSet<>();

        s.add(100);	// auto-boxing
        s.add(3);
        s.add(77);
        s.add(10);

        // SortedSet은 Set의 모든 메소드를 상속한다.
        Iterator<Integer> iterator = s.iterator(); // 상속한 메소드
        while(iterator.hasNext())
            System.out.println(iterator.next());	// 오름차순으로 출력된다.

        System.out.println();

        Integer smallest = s.first();	// Set에는 없는 SortedSet 고유의 메소드!
        s.remove(smallest);
        iterator = s.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());
    }
}


