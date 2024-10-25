package java2.week5_Collections;
import java.util.*;

/**
 * 이 문제는 equal, hashcode, compareTo 메소드를
 * 재정의하는 이유와 방법 공부
 *
 * o.hashCode() - 객체 o의 메모리 주소에 따라 정해지는 정수를 반환한다.
 * o1.hashCode()와 o2.hashCode() 비교
 * o1과 o2가 같다면 같은 해시값이 나올 것이고,
 * 다르다면 다른 해시값이 나올 것이다. (아주 드문 확률로 같은 것이 나올 때가 있다.)
 */

public class Cat implements Comparable<Cat> {
    String name;
    int age;

    public Cat(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Cat o) {
        if(age < o.age)
            return -1;
        else if (age > o.age)
            return 1;
        else
            return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return String.format("Cat [name= %s, age= %s]", name, age);
    }

    public static void main(String[] args) {
        Set<Cat> s = new HashSet<>();
        Scanner input = new Scanner(System.in);

        System.out.println("이름과 나이를 입력하세요, 입력을 마치려면 엔터만 입력하세요.");
        while(input.hasNext()){
            String line = input.nextLine();

            if("".equals(line))
                break;

            String [] words = line.strip().split("\\s+");
            int value = Integer.parseInt(words[1]);
            s.add(new Cat(words[0],value));
        }
        // 일반적인 Set과 다르게 정렬이 가능한 SortedSet 인터페이스
        // 를 구현하는 TreeSet클래스

        // 나이순으로 우선 정렬, 만약 나이가 같다면,
        // 고양이의 이름을 사전 순서로 비교하여 정렬
        SortedSet<Cat> ss = new TreeSet<>();
        ss.addAll(s);
        System.out.println(ss);

        // 이름을 사전 순서대로 우선 정렬
        // 이름이 같다면 나이를 기준으로 정렬
        ss = new TreeSet<>(new CatComparator());
        ss.addAll(s);
        System.out.println(ss);


    }
}
