package java2.week4_interface;
import java.util.*;

/**
 * for-each 문을 활용, double 난수를 입력받아
 * 너비와 높이를 정하여 출력하는 프로그램
 *
 * @author 김이든
 */
public class RectangleTester {

    /**
     * test()에서 구현
     */
    private void test(){
        Scanner input = new Scanner(System.in);
        System.out.print("Seed: ");
        int seed = input.nextInt();
        Random random = new Random(seed);

        // 0.0 이상 1.0 미만 난수를 0.0 이상 100.0 미만 난수로 변환하려면 난수에 100.0을 곱해줌.
        Rectangle rect1 = new Rectangle(random.nextDouble()*100, random.nextDouble()*100);
        Rectangle rect2 = new Rectangle(random.nextDouble()*100, random.nextDouble()*100);
        Rectangle rect3 = new Rectangle(random.nextDouble()*100, random.nextDouble()*100);

        //배열에 저장
        Rectangle[] rectArray = {rect1, rect2, rect3};

        // ArrayList에 저장 cf) 잘 기억해두자
        ArrayList<Rectangle> rectList = new ArrayList<>();

        rectList.add(rect1);
        rectList.add(rect2);
        rectList.add(rect3);

        System.out.println("Print the array using for-each loop.");
        for (Rectangle rect : rectArray)
            System.out.println(rect.toString());

        System.out.println();

        System.out.println("Print the array list using for-each loop.");
        for(Rectangle rect : rectList)
            System.out.println(rect.toString());
    }

    public static void main(String[] args){
        new RectangleTester().test();
    }
}
