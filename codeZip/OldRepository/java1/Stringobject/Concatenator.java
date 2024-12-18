package OldRepository.java1.Stringobject;

import java.util.*;

/**
 * StringBuilder와 append를 사용해 단어들을 접합
 * @author 김이든
 */

public class Concatenator{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            String word = input.next().trim();
            StringBuilder builder = new StringBuilder(word);
            System.out.print(builder+" ");
            builder.append(word+" ");
        }
    }
}
