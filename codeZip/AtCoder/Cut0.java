package AtCoder;

import java.text.DecimalFormat;
import java.util.*;
import java.text.DateFormat;

/**
 * java.text.DateFormat; 소수점 끝에 0을 제거하는 라이브러리
 *
 */
public class Cut0 {
    public static void main(String[] args) {
        // 입력 A B C
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.###");// 소수 3번째 자리까지 할당

        double n = input.nextDouble();

        System.out.println(df.format(n));

    }
}

