package java2.week5_Collections;
import java.util.*;

public class SpecialNumberGenerator2 {
    /**
     * 첫 n개의 소수를 찾아낸다. n은 1 이상이어야 한다.
     *
     * @param n 소수 개수. (n >= 1)
     * @return 찾은 소수들이 들어있는 List.
     */
    public List<Long> getPrimes(int n) {

        List<Long> list = new ArrayList<>();
        list.add(2L);
        for (int i = 0; i < n - 1; i++) {
            list.add(getNextPrime(list));
        }

        return list;
    }

    /**
     * 이미 찾은 소수들이 주어졌을 때, 그 다음 소수를 찾는다.
     *
     * @param primes 이미 찾은 소수들이 들어 있는 리스트.
     * @return 찾은 다음 소수.
     */
    private long getNextPrime(List<Long> primes) {
        long candidate = primes.get(primes.size() - 1) + 1;

        while (true) {
            boolean isPrime = true;

            // 이미 구한 소수들로 나눠 떨어지는지 확인
            for (long prime : primes) {
                if (candidate % prime == 0) {
                    isPrime = false;
                    break; // 나누어 떨어지면 소수가 아님
                }

            }
            if (isPrime) {
                return candidate; // 소수를 찾았으므로 반환
            }
            candidate++; // 소수가 아니면 다음 숫자로
        }
    }

    /**
     * 첫 n개의 못난이 수를 찾아낸다. n은 1 이상이어야 한다.
     *
     * @param n 못난이 수 개수 (n >= 1)
     * @return 찾은 못난이 수들이 들어 있는 Collection
     */
    public Collection<Long> getUglies(int n) {
        SortedSet<Long> sortedSet = new TreeSet<Long>();
        sortedSet.add(1L);

        long current = 1;
        boolean isUgly = false;

        while (sortedSet.headSet(current).size() <= n - 1) {
            for (long factor : sortedSet) {
                if (current % factor == 0) {
                    isUgly = true;
                }
            }

            if (isUgly) {
                current = sortedSet.tailSet(current).getFirst();

                sortedSet.add(current * 2L);
                sortedSet.add(current * 3L);
                sortedSet.add(current * 5L);

                current++;
            }
        }

        return sortedSet.headSet(current);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ////////////////////////////////////////////////////////////////
        System.out.print("Number of primes: ");
        int n = input.nextInt();

        SpecialNumberGenerator2 sng = new SpecialNumberGenerator2();
        List<Long> list = sng.getPrimes(n);
        ListIterator<Long> listIterator = list.listIterator();

        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();

        if (list.size() < 10) {

            while (listIterator.hasPrevious()) {
                System.out.print(listIterator.previous() + " ");
            }
        } else {
            for (int i = list.size() - 1; i > list.size() - 11; i--) {
                System.out.print(list.get(i) + " ");
            }
        }

        ///////////////////////////////////////////////////////

        System.out.println();
        System.out.print("Number of uglies: ");
        int n2 = input.nextInt();
        Collection<Long> uglylist = sng.getUglies(n2);

        System.out.println(uglylist);

        System.out.println();
        //////////////////////////////////////////
        // (가) 이미 구한 소수들과 못난이들의 교집합을 구하여 오름차순으로 화면에 출력

        list.retainAll(uglylist);
        Collections.sort(list);
        System.out.print("Intersection: " + list);
        System.out.println();
        /////////////////////////////////////////
        //(나) 이미 구한 소수들과 못난이수들의 합집합을 구하여 합집합을 오름차순으로 화면에 출력

        List<Long> list2 = sng.getPrimes(n);
        Collection<Long> uglylist2 = sng.getUglies(n2);
        list2.addAll(uglylist2);
        Collections.sort(list2);
        // HashSet은 중복을 허용하지 않고 순서도 고려하지 않기 때문에,
        // TreeSet을 사용해 중복을 허용하지 않으면서 정렬한다.(그러나 인덱스는 없다.)
        Set<Long> unionSet = new TreeSet<>(list2);

        System.out.print("Union: " + unionSet);
        System.out.println();

        ////////////////////////////////////////////
        //(다) 정렬된 합집합의 앞 10개를 차례로 화면에 출력
        //
        System.out.print("Ten in front of union: ");
        List<Long> listUnion = new ArrayList<>(unionSet);
        Iterator<Long> itUnion = listUnion.listIterator();
        if (listUnion.size() < 10) {
            while (itUnion.hasNext()) {
                System.out.print(itUnion.next() + " ");
            }
        }
        else {
            for (int i = 0; i < 10; i++) {
                System.out.print(listUnion.get(i) + " ");
            }
        }
            System.out.println();
            ////////////////////////////////////////////
            // (라) 정렬된 합집합의 뒤 10개를 차례로 화면에 출력한다
            // tailSet()
            itUnion = listUnion.listIterator();
            System.out.print("Ten in the back of union: ");
            if (listUnion.size() < 10) {
                while (itUnion.hasNext()) {
                    System.out.print(itUnion.next() + " ");
                }
            }

            else {
                for (int i = listUnion.size() - 10; i < listUnion.size(); i++) {
                    System.out.print(listUnion.get(i) + " ");
                }
            }
            ///////////////////////////////////////////////////
    }
}

