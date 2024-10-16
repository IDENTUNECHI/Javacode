package java2.week5_Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {

        // Set은 인터페이스이다.
        // HashSet은 Set이다. == HashSet은 Set 인터페이스를 구현한 클래스이다.
        Set<Integer> s = new HashSet<>();

        // 인터페이스를 이용해 객체를 구성할 수 없다.
        // Set<Integer> s = new Set<>();	// 이렇게 하면 컴파일 에러!

        s.add(100);	// auto-boxing
        s.add(3);
        s.add(77);
        s.add(10); // 10을 세 번 넣는다.
        s.add(10);
        s.add(10);

        System.out.println("원소 수: " + s.size());

        Iterator<Integer> iterator = s.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());  	// 원소를 넣은 순서와 상관 없이
    }												// 임의의 순서로 출력된다.
}



