package homework.Stringobject;

import java.util.*;

public class Sorter{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String word1 = input.next();
        String word2 = input.next();

        int res = word1.compareTo(word2);

        if(res<0){
            System.out.println(word1 +" "+ word2);
        }
        else{
            System.out.println(word2 +" "+ word1);
        }
    }
}
