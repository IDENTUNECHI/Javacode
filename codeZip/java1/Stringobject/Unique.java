package java1.Stringobject;

import java.util.*;

/**
 * 10개 이내의 단어를 입력 받아 중복을 제거하고 나머지 단어들을 한 줄에 한 단어씩 출력하는 프로그램
 * LinkedHashSet을 사용해 중복된 String을 제거하고 입력받은 값은 순서대로 출력한다.
 * @author 김이든
 */

public class Unique{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        HashSet<String> wordsSet = new LinkedHashSet<>();

        int count = 0;
        while (input.hasNext()) {
            String word = input.next().trim();

            wordsSet.add(word);
        }

        for (String word : wordsSet) {
            System.out.println(word);
        }
    }
}
