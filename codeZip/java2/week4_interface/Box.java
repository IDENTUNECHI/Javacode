package java2.week4_interface;

import java.util.*;

/**
 * Box 클래스를 작성하여 부피에 따라 정렬하고, Comparator를 이용해 표면적 순으로도 정렬
 */
public class Box implements Comparable<Box>{
    private double width;
    private double depth;
    private double height;

    // 생성자
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

    public int compareTo(Box other){
        return Double.compare(this.getVolume(), other.getVolume());
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

