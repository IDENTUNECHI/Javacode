package java2.week5_Collections;

import java.util.ArrayList;

/**
 * Iterator의 주요 메소드
 * hasNext(): 다음 요소가 존재하는지 여부를 반환합니다. 더 이상 요소가 없으면 false를 반환합니다.
 * next(): 다음 요소를 반환하고, 그 위치를 다음으로 이동시킵니다.
 * remove(): next()로 반환한 마지막 요소를 컬렉션에서 삭제합니다.
 */
public class IteratorPractice {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        java.util.Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            String fruit = it.next();
            if(fruit.equals("Cherry")){
                it.remove();
            }
            System.out.println(fruit);
        }
        System.out.println("After removal: " + list);
    }
}

