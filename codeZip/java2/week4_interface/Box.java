package java2.week4_interface;

import java.util.*;

/**
 * Box 클래스를 작성하여 부피에 따라 정렬하고,
 * Comparator를 이용해 표면적 순으로도 정렬
 */
public class Box implements Comparable<Box>{
    private double width, depth, height; // 필드

    /**
     * 생성자
     * @param width .
     * @param depth .
     * @param height .
     */
    public Box(double width, double depth, double height){
        this.width = width;
        this.depth = depth;
        this.height = height;
    }

    // 부피 계산
    public double getVolume() {
        return width*depth*height;
    }

    // 표면적 계산
    public double getSurfaceArea() {
        return 2 * (width * depth + depth * height + height * width);
    }

    // 부피 비교

    /**
     * Double.compare()는 두 double 값을 비교하는 자바의 유틸리티 메서드.
     *
     * @param other the object to be compared.
     * @return this 객체의 부피가 other 객체의 부피보다 크면 양수를 반환
     *                                            작으면 음수를 변환
     *                                            같으면 0반환
     */

    public int compareTo(Box other){
        return Double.compare(this.getVolume(), other.getVolume());

        // 다른 방법
        //double thisVolume = this.getVolume();  // 현재 객체의 부피
        //double otherVolume = other.getVolume();  // 비교 대상 객체의 부피
        
        /* 부피 차이를 구해서 반환*/
        //if (thisVolume > otherVolume) {
        //    return 1;  // 현재 객체가 더 크면 양수 반환
        //} else if (thisVolume < otherVolume) {
        //    return -1;  // 현재 객체가 더 작으면 음수 반환
        //} else {
        //    return 0;  // 부피가 같으면 0 반환
        //}
    }


    public String toString() {
        return String.format("Box [width=%.1f, depth=%.1f, height=%.1f]",
                width, depth, height);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Seed: ");
        int seed = input.nextInt();
        Random random = new Random(seed);

        // List 생성
        List<Box> boxes = new ArrayList<>();

    
        for(int i=0; i<5; i++){
          double width = random.nextDouble(10.0);
          double depth = random.nextDouble(10.0);
          double height = random.nextDouble(10.0);

          //결론적으로, 이 코드는 난수로 생성된 width, depth, height 값을 사용하여
            // 새로운 Box 객체를 만들고,
            // 그 객체를 boxes 리스트에 추가하는 기능을 수행.
          boxes.add(new Box(width, depth, height)); // 객체 Box를 boxes에 저장
        }

        System.out.println("Boxes.");
        for(Box box : boxes){
            System.out.println(box);
        }

        System.out.println("Sort by volume.");
        Collections.sort(boxes);
        for(Box box : boxes){
            System.out.println(box);
        }


        System.out.println("Sort by surface area.");
        Collections.sort(boxes, new SurfaceComparator());
        for (Box box : boxes) {
            System.out.println(box);
        }

    }
}

class SurfaceComparator implements Comparator<Box>{
    public int compare(Box b1, Box b2){
        return Double.compare(b1.getSurfaceArea(), b2.getSurfaceArea());
    }
}

