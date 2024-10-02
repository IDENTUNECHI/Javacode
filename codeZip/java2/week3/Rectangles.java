package java2.week3;
import java.awt.Rectangle;

/**
 * 사각형을 만드는 프로그램
 *
 * @author 김이든
 */
public class Rectangles {
    public static void main(String[] args) {

        // 상태변수 선언 및 초기화

        Rectangle r1 = new Rectangle(50, 50, 100, 100);
        Rectangle r2 = new Rectangle(100, 100, 70, 70);

        Rectangle r3 = new Rectangle(300, 50, 100, 100);
        Rectangle r4 = new Rectangle(350, 100, 70, 70);

        Rectangle intersection, union;	// 상태변수 선언

        // intersection과 union을 구함
        intersection = r1.intersection(r2);	// r1과 r2의 intersection
        union = r3.union(r4);		// r3와 r4의 union

        System.out.println("r1: " + r1);
        System.out.println("r2: " + r2);
        System.out.println("intersection: " + intersection);
        System.out.println();

        System.out.println("r3: " + r3);
        System.out.println("r4: " + r4);
        System.out.println("union: " + union);

    }


}
