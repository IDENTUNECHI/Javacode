package homework.Recursion_Function;
import java.util.*;

/**
 * 피보나치 수열 효율 계산
 * @author 김이든
 */
public class FibonacciIteration2 {
    public static void main(String[] args) {
        System.out.print(fiboRecursion2(1) + " ");
        System.out.print(fiboRecursion2(2) + " ");
        System.out.print(fiboRecursion2(3) + " ");
        System.out.print(fiboRecursion2(4) + " ");
        System.out.print(fiboRecursion2(5) + " ");
        System.out.print(fiboRecursion2(6) + " ");
        System.out.print(fiboRecursion2(7) + " ");
        System.out.print(fiboRecursion2(8) + " ");
        System.out.print(fiboRecursion2(9) + " ");
        System.out.print(fiboRecursion2(10) + " ");
        System.out.print(fiboRecursion2(20) + " ");

        Scanner input = new Scanner(System.in);
        System.out.print("n: ");
        int n = input.nextInt();

        //long start = System.currentTimeMillis();
        System.out.println(fiboRecursion2(n));
        //long stop = System.currentTimeMillis();
        //System.out.println("Run time = "+ (stop-start)+ "ms");
        input.close();
    }

    /**
     * 피보나치 수열의 n번째 값, f(n)을 recursion 방법으로 구한다.
     * 수열은 아래와 같은 방식으로 표기하기로 한다.
     * f(1) = 1, f(2) = 1, f(3) = 2, f(4) = 3, ...
     *
     * @param n
     * @return f(n)
     */
    public static long fiboRecursion2(int n) {
        // ..., f2, f1, f, ...
        // f = f2 + f1
        // long 타입 변수 세 개만을 사용한다
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int fibPrev = 0;
            int fibCurr = 1;
            for (int i = 2; i <= n; i++) {
                int temp = fibCurr;
                fibCurr = fibPrev + fibCurr;
                fibPrev = temp;
            }
            return fibCurr;
        }
    }
}


