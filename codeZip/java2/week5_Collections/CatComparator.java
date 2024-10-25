package java2.week5_Collections;
import java.util.*;

/**
 * 이름을 우선적으로 비교한뒤,
 * 고양이의 이름이 같다면 고양이의 나이 비교
 */
public class CatComparator implements Comparator<Cat>{
    public int  compare(Cat c1, Cat c2){
        int nameCompare = c1.name.compareTo(c2.name); // 이름 비교

        if(nameCompare != 0){
            return nameCompare; // 이름이 다르면 그에 따라 정렬
        }
        else{
            return Integer.compare(c1.age, c2.age); // 이름이 같으면 나이 비교

        }

    }
}

