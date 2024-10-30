package java2.week4_interface;
import java.util.*;
/**
 * java.util.Arrays 클래스의 asList 메소드는 타입 파라미터를 갖는 제네릭 메소드로,
 * Arrays.asList();
 * T 타입의 값을 0개 이상 인자로 받아 List<T>를 반환합니다.
 * 이 메소드는 배열과 리스트가 연계되어 있어서 데이터는 배열에 저장되며,
 * 리스트의 원소를 변경하면 배열도 변경됩니다.
 * 그러나 배열의 크기가 고정되어 있으므로 리스트에 원소를 추가할 수는 없습니다.
 * </>
 * List에는 객체만 넣을 수 있다
 * </>
 * 또한, 이 메소드는 기본 타입 값을 자동으로 래핑하여 객체로 처리하며,
 * ArrayList나 LinkedList와 같은 특정 구현 클래스를 반환하는지 명확하지 않기 때문에
 * List 타입으로 받아야 합니다.
 */

public class AsListTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Seed: ");
        int seed = input.nextInt();
        Random random = new Random(seed);

        List<Integer> list = new ArrayList<>(Arrays.asList());

        for(int i =0; i<5; i++) {
            int randomNum = random.nextInt();
            list.add(randomNum); // List에는 객체만 저장할 수 있다고 했는데 어떻게 정수가 들어가나?
        }

        System.out.println("List.");
        System.out.println(list);
        ///////////////////////////////////

        // 걍 정렬
        System.out.println("List sorted in Natural ordering.");
        Collections.sort(list);
        System.out.println(list);

        /////////////////////////////////

        // 절대값 기준으로 정렬
        System.out.println("List sorted by the absolute values.");
        Collections.sort(list, new AbsoluteValueComparator()); // 두 개의 파라미터 List 타입과 Comparator 타입
        System.out.println(list);
    }
}

/**
 * 절대값을 기준으로 Integer들을 정렬하려면
 * 절대값을 기준으로 두 Integer의 크기를 비교해주는 Comparator
 */
class AbsoluteValueComparator implements Comparator<Integer>{
    public int compare(Integer i1, Integer i2) {
        if(i1<0)
            i1 = i1*-1;

        if(i2<0)
            i2 = i2*-1;

        if(i1<i2)
            return -1;
        else if(i1 > i2)
            return +1;
        else
            return 0;
    }

}
