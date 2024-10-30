package Java2Practice.Interface;

import java.util.*;


public class RectangleTester4 {
    private void test() {
        Scanner input = new Scanner(System.in);
        System.out.print("Seed: ");
        int seed = input.nextInt();
        Random random = new Random(seed);

        Rectangle4[] rectangles = new Rectangle4[3];
        List<Rectangle4> rectangleList = new ArrayList<>();

        for(int i=0; i<3; i++) {
            double width = random.nextDouble() * 100.0;
            double height = random.nextDouble() * 100.0;
            Rectangle4 rectangle = new Rectangle4(width, height);
            rectangles[i] = rectangle;
            rectangleList.add(rectangle);
        }

        System.out.println(Arrays.toString(rectangles));
        System.out.println(rectangleList);
        System.out.println();

        //---------------------------------------------------------//
        System.out.println("Sort by area (natural ordering)");
        Arrays.sort(rectangles);
        Collections.sort(rectangleList);
        System.out.println(Arrays.toString(rectangles));
        System.out.println(rectangleList);
        System.out.println();
        //----------------------------------------------------------//
        System.out.println("Sort by area (natural ordering)");

        Arrays.sort(rectangles, new DiagonalComparator());
        Collections.sort(rectangleList, new DiagonalComparator());
        System.out.println(Arrays.toString(rectangles));
        System.out.println(rectangleList);
        System.out.println();
    }

    public static void main(String[] args) {
        RectangleTester4 dataSetTester4 = new RectangleTester4();
        dataSetTester4.test();
    }
}
