package java2.week5_Collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 위인들에 대한 인기투표 결과
 */
public class MapDemo {

    public static void main(String[] args) {

        // (이름, 득표수)를 (key, value) 쌍으로 저장
        // Map은 인터페이스이다.
        // HashMap은 Map이다. == MashMap은 Map 인터페이스를 구현한 클래스이다.
        Map<String, Integer> m = new HashMap<>();

        // 인터페이스를 이용해 객체를 구성할 수 없다.
        // Map<String, Integer> m = new Map<>();	// 에러!

        // key는 중복될 수 없다.
        // value는 중복될 수 있다.
        m.put("강감찬", 1);
        m.put("을지문덕", 4);
        m.put("이순신", 1);
        m.put("장보고", 3);
        m.put("양만춘", 3);
        m.put("계백", 3);

        Set<String> keys = m.keySet();
        Iterator<String> iterator = keys.iterator();
        while(iterator.hasNext()) {
            String k = iterator.next();
            System.out.println(k + " " + m.get(k)); // key, value 쌍 출력
            // 원소를 넣은 순서와 상관 없이
            // 임의의 순서로 출력된다.
        }
    }
}

