package homework.two_array2;

import java.util.*;
public class UnionIntersection {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Seed: ");
        long seed = input.nextLong();
        Random generator = new Random(seed);

        System.out.print("배열 1크기: ");
        int alength = input.nextInt();
        System.out.print("배열 2크기: ");
        int blength = input.nextInt();
        System.out.print("최대난수: ");
        int max = input.nextInt();

        int[] a = new int[alength];
        int[] b = new int[blength];

        int[] union = new int[alength + blength];
        int unionSize;

        int[] intersection;
        // 교집합의 원소 수는 A 집합 원소 수보다 작고
        // B 집합 원소 수보다도 작으므로
        // 임의로 A집합 원소 수로 크기를 정한다.
        intersection = new int[alength];
        int intersectionSize;

        ArrayUtil.fillRandomDistinct(a, max, generator);
        System.out.print("배열1: ");
        ArrayUtil.printArray(a, a.length);
        if(!ArrayUtil.distinct(a,a.length))
            System.out.println("엥? 배열에 중복된 원소가 있네");

        ArrayUtil.fillRandomDistinct(b, max, generator);
        System.out.print("배열2: ");
        ArrayUtil.printArray(b, b.length);
        if(!ArrayUtil.distinct(b,b.length))
            System.out.println("엥? 배열에 중복된 원소가 있네");

        unionSize = unionArrays(a, b, union);
        System.out.print("Union: ");
        ArrayUtil.printArray(union, unionSize);
        if(!ArrayUtil.distinct(union,unionSize))
            System.out.println("엥? 배열에 중복된 원소가 있네");

        intersectionSize = intersectionArrays(a, b, intersection);
        System.out.print("Intersection: ");
        ArrayUtil.printArray(intersection, intersectionSize);
        if(!ArrayUtil.distinct(intersection, intersectionSize))
            System.out.println("엥? 배열에 중복된 원소가 있네");

        input.close();
    }

    /**
     * 배열 a의 원소들과 배열 b의 원소들의 합집합을
     * 배열 union에 넣고 합집합의 원소의 수를 반환한다.
     * 전제조건: union.length >= a.length + b.length
     *
     * @param a 배열
     * @param b 배열
     * @param union 합집합이 저장될 배열
     * @return 합집합의 원소의 개수
     */
    public static int unionArrays(int[] a, int[] b, int[] union) {
        int unionSize = 0;

        // 배열 a의 모든 원소를 추가
        for (int i = 0; i < a.length; i++) {
            if (!contains(union, unionSize, a[i])) {
                union[unionSize++] = a[i];
            }
        }

        // 배열 b의 모든 원소를 추가
        for (int i = 0; i < b.length; i++) {
            if (!contains(union, unionSize, b[i])) {
                union[unionSize++] = b[i];
            }
        }

        return unionSize;
    }
    /**
     * 배열의 특정 구간에 원소가 있는지 확인하는 헬퍼 메소드
     *
     * @param array 배열
     * @param size 확인할 크기
     * @param value 찾을 값
     * @return 배열에 값이 존재하면 true, 아니면 false
     */

    public static boolean contains(int[] array, int size, int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 배열 a의 원소들과 배열 b의 원소들의 교집합을
     * 배열 intersection에 넣고 교집합의 원소의 수를 반환한다.
     * 전제조건: intersection.length >= min(a.length, b.length)
     *
     * @param a 배열
     * @param b 배열
     * @param intersection
     * @return 교집합의 원소의 개수
     */
    public static int intersectionArrays(int[] a, int[] b, int[] intersection) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    boolean alreadyInIntersection = false;
                    for (int k = 0; k < count; k++) {
                        if (intersection[k] == a[i]) {
                            alreadyInIntersection = true;
                            break;
                        }
                    }
                    if (!alreadyInIntersection) {
                        intersection[count] = a[i];
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
