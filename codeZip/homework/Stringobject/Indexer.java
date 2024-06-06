package homework.Stringobject;

import java.util.*;
/**
 * indexOf를 활용해 소문자로 바꿔준 sen에서 'a','b','c'를 찾아 인덱스를 반환
 * 생소한 String 메소드를 활용하기 빡셈
 * @author 김이든
 */
public class Indexer{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String sentence = input.nextLine();

        String sen = sentence.toLowerCase();

        int sum = 0;
        int a_index = sen.indexOf('a');
        int b_index = sen.indexOf('b');
        int c_index = sen.indexOf('c');

        sum += a_index;


        sum += b_index;


        sum += c_index;


        System.out.println(sum);
    }

}
