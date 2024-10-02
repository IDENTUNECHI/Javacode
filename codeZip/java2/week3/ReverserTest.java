package java2.week3;
import java.util.*;

/**
 * 글자와 단어를 뒤집어서 출력하는 프로그램
 */
public class ReverserTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("문자열을 입력하세요: ");
        String s = input.nextLine();

        Reverser reverser = new Reverser(s);
        String reversedString = null;
        reversedString = reverser.reverse();

        System.out.print("뒤집힌 문자열: ");
        System.out.println(reversedString);

        //------------------------------------

        String reversedWords = null;
        reversedWords = reverser.reverseWords();

        System.out.print("단어 단위로 뒤집힌 문자열: ");
        System.out.println(reversedWords);

        input.close();
    }
}
