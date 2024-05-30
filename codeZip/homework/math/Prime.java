package homework.math;

/**
 * 주어진 정수가 소수(prime number)인지 여부를 판별하는 프로그램
 *
 *
 */
public class Prime {
    public static void main(String[] args){
        for (int i = 2; i<=20; i++) {

            boolean result1 = isPrime1(i);
            boolean result2 = isPrime2(i);
            System.out.printf("첫 번째 방법: %d은(는) 소수이다: %b", i, result1);
            System.out.printf("\n두 번째 방법: %d은(는) 소수이다: %b", i, result2);
            System.out.println();
        }
    }
    /**
     *첫번째 방법
     * @param n 주어진 2부터 20까지의 수
     * @return isPrime 소수이면 true 아니면 false
     */
    public static boolean isPrime1(long n){
        boolean isPrime = true;
        for (long j = 2; j<n; j++){
            if (n%j == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;

    }

    /**
     *두 번째 방법
     * @param n 주어진 2부터 20까지의 수
     * @return isPrime 소수이면 true 아니면 false
     */
    public static boolean isPrime2(long n){
        boolean isPrime = true;
        for (long j = 2; j*j <= n; j++){
            if (n%j == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;

    }

}