package OldRepository.Java2Practice.Interface;

public class Rectangle2 implements Measurable {
    private double width, height;	// 필드

    // 생성자
    public Rectangle2(double width, double height) { // 생성자
        this.width = width;
        this.height = height;
    }
    // 사각형의 크기를 설정
    public void setDimension(double width, double height) { // 사각형의 크기를 설정
        this.width = width;
        this.height = height;
    }

    public double getMeasure(){
        return width * height;
    }

    // 형식에 따라 출력 함수
    public String toString() {
        return String.format("Rectangle2 [width=%,.1f, height=%,.1f]", width, height);
        //참고: System.out.format("출력하고 싶은 문자열%,.1f문자열", 123123.27);
    }
    // 필드
}

