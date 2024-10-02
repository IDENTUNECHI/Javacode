package java2.week3;
import java.util.*;

/**
 * Balance의 테스트 클래스
 *
 *
 */
public class BalanceTesterDemo2 {
    public static void main(String[] args) {
        // Balanced string인지 (괄호 짝이 맞는 문자열인지) 검사할 문자열.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string to check balance: ");
        String string = input.next(); // balance 클래스의 변수 str 에 대입할 string 입력

        BalanceTester tester = new BalanceTester(string); // 클래스 선언

        if(tester.balanced())
            System.out.println("괄호짝이 맞습니다.");
        else
            System.out.println("괄호짝이 맞지 않습니다.");
    }
}
