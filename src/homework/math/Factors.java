package homework.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factors {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("자연수를 하나 입력하세요: ");
        long n = Long.parseLong(br.readLine());
        System.out.print(n + "을 소인수분해하면 ");
        for (long i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                n = n / i;
                System.out.print(i + " ");
            }
        }
        if (n > 1) {
            System.out.print(n);
        }
    }
}