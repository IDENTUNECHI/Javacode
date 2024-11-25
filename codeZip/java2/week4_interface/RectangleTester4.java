package java2.week4_interface;
import java.util.*;

/**
 * 만약 사각형의 둘레나 가로, 세로를 기준으로 정렬하고 싶을 수 있다. 이럴 때 Rectangle4
 * 클래스 자체를 수정해서 사각형을 비교하는 기준 자체를 바꾸는 방법은 좋은 방법이 아니다.
 * Rectangle4클래스를 사용하는 다른 어플리케이션에 문제가 발생할 수 있기 때문.
 * 이렇게 객체를 서로 비교하는 데 쓰는 기준을 일시적으로 변경하고 싶을 때 Comparator를 사용.
 *
 */
public class RectangleTester4 {
    private void test(){
        Scanner input = new Scanner(System.in);
        System.out.print("Seed: ");
        int seed = input.nextInt();
        Random random = new Random(seed);

        Rectangle4[] rectangles = new Rectangle4[3];
        List<Rectangle4> rectangleList = new ArrayList<>();


        for(int i=0; i<3; i++){
            double width = random.nextDouble()*100.0;
            double height = random.nextDouble()*100.0;
            Rectangle4 rectangle = new Rectangle4(width, height);
            rectangles[i] = rectangle;
            rectangleList.add(rectangle);
            /// 위의 주석 블록 참조

            ///
        }

        //////////////////////////////////////////////////////////////////////////////////////

        System.out.println(Arrays.toString(rectangles));
        System.out.println(rectangleList);
        System.out.println();

        /////////////////////////////////////////////////////////////////////////

        System.out.println("Sort by area (natural ordering)");
        Arrays.sort(rectangles);
        // rectangleList에 들어 있는 Rectangle4 들이 Comparable들이므로 Collections.sort() 사용 가능
        Collections.sort(rectangleList);
        System.out.println(Arrays.toString(rectangles));
        System.out.println(rectangleList);
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////

        // ArrayList를 대각선 길이를 기준으로 정렬하고 출력한다.
        // 이 때 Diagonal Comparator와
        // 두 번째 Collections.sort 메소드를 이용한다.
        // diagonal == 대각선

        /**
         * 두 번째 버전의 Collection.sort()는 두 개의 파라미터를 가진다.
         * 첫 파라미터는 List type이고, 두 번째 파라미터는 Comparator type
         *
         */

        System.out.println("Sort by diagonal length");
        Thread.currentThread().getName();
        /////
        Arrays.sort(rectangles, new DiagonalComparator()); // 두 개의 파라미터
        Collections.sort(rectangleList, new DiagonalComparator());
        /////
        System.out.println(Arrays.toString(rectangles));
        System.out.println(rectangleList);
        System.out.println();

    }
    public static void main(String[] args) {
        new RectangleTester4().test();
    }
}
