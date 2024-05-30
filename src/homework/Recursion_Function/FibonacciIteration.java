package homework.Recursion_Function;
import java.util.*;

/**
 * 피보나치 수열 계산
 * @author 김이든
 */
public class FibonacciIteration {
    public static void main(String[] args){
        System.out.print(fiboIteration(1) + " ");
        System.out.print(fiboIteration(2) + " ");
        System.out.print(fiboIteration(3) + " ");
        System.out.print(fiboIteration(4) + " ");
        System.out.print(fiboIteration(5) + " ");
        System.out.print(fiboIteration(6) + " ");
        System.out.print(fiboIteration(7) + " ");
        System.out.print(fiboIteration(8) + " ");
        System.out.print(fiboIteration(9) + " ");
        System.out.print(fiboIteration(10) + " ");
        System.out.print(fiboIteration(20) + " ");

        Scanner input = new Scanner(System.in);
        System.out.print("n: ");
        int n = input.nextInt();

        //long start = System.currentTimeMillis();
        System.out.println(fiboIteration(n));
        //long stop = System.currentTimeMillis();
        //System.out.println("Run time = "+ (stop-start)+ "ms");
        //input.close();
    }

    /**
     * 피보나치 수열의 n번째 값, f(n)을 recursion 방법으로 구한다.
     * 수열은 아래와 같은 방식으로 표기하기로 한다.
     * f(1) = 1, f(2) = 1, f(3) = 2, f(4) = 3, ...
     * 배열을 사용하여 구함
     * @param n
     * @return f(n)
     */
    public static long fiboIteration(int n){

        if(n==1 || n==2){
            return 1 ;
        }
        int [] f = new int [n];
        if(n >=3) {
            f[0] = 1;
            f[1] = 1;
            for (int i = 0; i < n-2; i++) {
                f[i + 2] = f[i + 1] + f[i];
            }
        }
        return f[n-1];
    }
}

