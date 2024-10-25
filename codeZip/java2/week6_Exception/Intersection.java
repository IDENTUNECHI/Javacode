package java2.week6_Exception;
import java.util.*;

public class Intersection {
    /**
     * 두 셋의 교집합을 구한다.
     * @param s1 첫 셋
     * @param s2 두 번째 셋
     * @return 교집합이 들어 있는 새 SortedSet
     */
    public static SortedSet<Integer> intersection(Set<Integer> s1, Set<Integer> s2){
        SortedSet<Integer> s3 = new TreeSet<>();
        for(int element : s1){
            if(s2.contains(element)){
                s3.add(element);
            }
        }
        return s3;
    }

    public static void main(String[] args) {
        SortedSet<Integer> s1 = new TreeSet<>();
        SortedSet<Integer> s2 = new TreeSet<>();

        Scanner input = new Scanner(System.in);

        System.out.print("원소 개수 n1과 n2: ");
        int n1 = input.nextInt();
        int n2 = input.nextInt();

        for(int i=0; i<n1; i++)
            s1.add(2*i);
        for(int i=0; i<n2; i++)
            s2.add(3*i);
        System.out.println(s1);
        System.out.println(s2);
        // intersection을 이용하여 교집합 셋을 얻고 교집합 셋을 출력한다.
        SortedSet<Integer> s3 = intersection(s1, s2);

        System.out.println(s3);
    }
}
