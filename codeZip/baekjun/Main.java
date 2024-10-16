package baekjun;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        // 입출력
            int n1 = input.nextInt();
            String s = input.next();


            System.out.println(test(n1, s));

    }

    public static long test(int n1, String s) {
        final int r = 31;
        final int M = 1234567891;

         long result = 0;
         long pow = 1;

         for(int i=0; i<n1; i++){
             int charValue = (int) s.charAt(i)-96;

             result = (result + (charValue * pow) % M) % M;

             pow = (pow * r) % M;
         }

        return result;
    }
}
