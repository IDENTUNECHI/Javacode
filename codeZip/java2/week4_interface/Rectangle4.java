package java2.week4_interface;

/**
 * 두 개의 인터페이스인 Measurable과 Comparable<Rextangle4>을 구현</>
 */
public class Rectangle4 implements Measurable, Comparable<Rectangle4> {
    private double width, height;	// 필드

    public Rectangle4(double width, double height) { // 생성자
        this.width = width;
        this.height = height;
    }
    public void setDimension(double width, double height) { // 사각형의 크기를 설정
        this.width = width;
        this.height = height;
    }

    @Override
    // Measurable 인터페이스 getMeasure() 메소드 구현
    public double getMeasure() {
        return width*height;
    }

    // Comparable 인터페이스 compareTo() 메소드 구현
    public int compareTo(Rectangle4 o) {
        double thisArea = width * height;
        double otherArea = o.width * o.height;

        // 자바 스텍에서 양수 정수, 음수 정수를 반환해야 한다고 했으니까
        // 이 함수를 구현하는 사람은 양수정수인건, 어떤 음수 정수이건 반환 가능
        // 우리는 임의로 1과 -1을 반환한다.

        // 이 사각형의 면적이 다른 사각형의 면적보다 작으면 -1,
        // 크면 1,
        // 그렇지 않으면 0
        // 을 반환한다.
        if(thisArea < otherArea)
            return -1;
        else if(thisArea > otherArea)
            return 1;
        else
            return 0;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String toString() {
        return String.format("Rectangle4 [width=%,.1f, height=%,.1f]", width, height);
        //참고: System.out.format("출력하고 싶은 문자열%,.1f문자열", 123123.27);
    }
    /**
     * java.lang.Comaprable;
     * 이 인터페이스는 compareTo()라는 한 개의 메소드만을 가지며,
     * 타입 파라미터를 갖는 "generic" 인터페이스.
     *
     */
}

