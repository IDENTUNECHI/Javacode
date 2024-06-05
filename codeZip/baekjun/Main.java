package baekjun;
import java.util.*;

/**
 * 주어진 바구니 N개를 M개의 범위를 입력받아 역순으로 재배치
 * @author 김이든
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] a = new int [n];
        double [] anew = new double[n];

        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        int max = Arrays.stream(a).max().getAsInt();

        for (int i=0; i<n; i++){
             anew[i]= (double) a[i]/max*100;
        }

        double b = 0;
        for(int i=0; i<n; i++){
            b = b + anew[i];
        }

        double result = (double)b/n;

        System.out.printf("%.2f", result);

        }
    }
