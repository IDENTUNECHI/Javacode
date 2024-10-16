package java2.week5_Collections;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class RererencingObjectsInCollection2 {

    public static void main(String[] args) {

        List<Rectangle> list = new ArrayList<>();
        list.add(new Rectangle(4, 5));
        list.add(new Rectangle(40, 50));
        System.out.println("리스트: " + list);
        System.out.println();

        System.out.println("0번 사각형 삭제");
        Rectangle r1 = list.remove(0);
        System.out.println("삭제된 사각형: " + r1);
        System.out.println("리스트: " + list);
        System.out.println();

        list.remove(0);
        System.out.println("리스트: " + list);
        System.out.println();
    }

}

