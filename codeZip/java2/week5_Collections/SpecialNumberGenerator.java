package java2.week5_Collections;
import java.util.*;

/**
 * List와 ListIterator를 이용하는 방법을 연습
 */

public class SpecialNumberGenerator {
    /**
     * 첫 n개의 소수를 찾아낸다. n은 1 이상이어야 한다.
     * @param n 소수 개수. (n >= 1)
     * @return 찾은 소수들이 들어있는 List.
     */
    public List<Long> getPrimes (int n) {

        List<Long> list = new ArrayList<>();
        list.add(2L);
        for(int i=0; i<n-1; i++) {
            list.add(getNextPrime(list));
        }

       return list;
    }

    /**
     * 이미 찾은 소수들이 주어졌을 때, 그 다음 소수를 찾는다.
     * @param primes 이미 찾은 소수들이 들어 있는 리스트.
     * @return 찾은 다음 소수.
     */
    private long getNextPrime(List<Long> primes){
        long candidate = primes.get(primes.size() - 1) + 1;

        while(true) {
            boolean isPrime = true; // 소수이면 isPrime = true

            // 이미 구한 소수들로 나눠 떨어지는지 확인
            for(long prime : primes){
                if(candidate % prime == 0){
                    isPrime = false;
                    break; // 나누어 떨어지면 소수가 아님
                }

            }
            if(isPrime){
                return candidate; // 소수를 찾았으므로 반환
            }
            candidate ++; // 소수가 아니면 다음 숫자로
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Number of primes: ");
        int n = input.nextInt();

        SpecialNumberGenerator sng = new SpecialNumberGenerator();
        List <Long> list = sng.getPrimes(n);
        // ListIterator는 Iterator의 서브 인터페이스이다.
        // ListIterator는 일반 Iterator와 달리 역방향으로도 이동하면서
        // list의 원소를 읽을 수 있다.(인덱스를 읽을 수 있다.)
        if(list.size()<10) {
            ListIterator<Long> listIterator = list.listIterator(list.size());

            while (listIterator.hasPrevious()) {
                System.out.print(listIterator.previous() + " ");
            }
        }
        else
            for (int i=0; i<10;i++ ){
                System.out.print(list.get(list.size()-1-i) + " ");
            }


    }


}
