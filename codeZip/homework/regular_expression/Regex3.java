package homework.regular_expression;

import java.util.Scanner;

public class Regex3 {

    /**
     * 주어진 문자열이 정규식에 들어맞는지 검사한다.
     * @param s 주어진 문자열
     * @return true or false
     */
    static boolean matches(String s) {
        String regex = "(b|c|r|meerk)at";
        return s.matches(regex);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String text = input.nextLine();
            if (matches(text))
                System.out.print("ACCEPT: ");
            else
                System.out.print("REJECT: ");
            System.out.println(text);
        }
        input.close();
    }
}
