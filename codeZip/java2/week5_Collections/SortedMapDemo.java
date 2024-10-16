package java2.week5_Collections;


import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {

    public static void main(String[] args) {

        // SortedMap은 Map의 서브인터페이스이다.
        // SortedMap은 원소들의 순서를 관리하는 Map이다.
        // Map의 원소들은 <key, value> 쌍이다.
        // 원소들의 순서를 관리한다는 말은 key를 기준으로 원소들의 순서를 관리한다는 말이다.
        // TreeMap은 SortedMap이다. == SortedMap은 TreeMap 인터페이스를 구현한 글래스이다.
        SortedMap<String, Integer> m = new TreeMap<>();

        // key는 중복될 수 없다.
        // value는 중복될 수 있다.
        m.put("강감찬", 1);
        m.put("을지문덕", 4);
        m.put("이순신", 1);
        m.put("장보고", 3);
        m.put("양만춘", 3);
        m.put("계백", 3);

        // SortedMap은 Map의 모든 메소드를 상속한다.
        Set<String> keys = m.keySet();
        Iterator<String> iterator = keys.iterator();
        while(iterator.hasNext()) {
            String k = iterator.next();
            System.out.println(k + " " + m.get(k)); // key, value 쌍 출력
        }											// key의 오름차순으로 출력된다!
        System.out.println();

        String lastKey = m.lastKey();	// Map에는 없는 SortedMap 고유의 메소드!
        m.remove(lastKey);

        keys = m.keySet();
        iterator = keys.iterator();
        while(iterator.hasNext()) {
            String k = iterator.next();
            System.out.println(k + " " + m.get(k)); // key, value 쌍 출력
        }
    }
}



