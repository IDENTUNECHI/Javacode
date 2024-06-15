package homework.Practice.w12;
import java.util.Scanner;

/**
 * 32bit 정수를 2진수로 변환하는 프로그램
 * @author 김이든
 */
public class ToBinaryString {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("32-bit integer: ");
        int input = scan.nextInt();

        String binaryString1 = toBinaryString(input);
        String binaryString2 = Integer.toBinaryString(input);

        System.out.println("toBinaryString: " + binaryString1);
        System.out.println("Integer.toBinaryString: " + binaryString2);
        System.out.println("Same: " + binaryString1.equals(binaryString2));
        scan.close();
    }

    /** toBinaryString
     * 정수 input의 32비트 2의 보수 체계 표현형을 문자열 타입으로 반환한다.
     * @param input 32bit 정수
     * @return 문자열 2진수
     */
    public static String toBinaryString(int input) {
      String binary = "";

      while(input>0){
          int remain = input & 1;
          binary = remain + binary;
          input = input >> 1;
      }
      return binary;
    }
}
