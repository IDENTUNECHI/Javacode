package java2.java2Core.w4_Interface;

import java2.week4_interface.Measurable;

public class Rectangle2 implements Measurable {
    private double width, height;	// 필드

    public Rectangle2(double width, double height) { // 생성자
        this.width = width;
        this.height = height;
    }
    public void setDimension(double width, double height) { // 사각형의 크기를 설정
        this.width = width;
        this.height = height;
    }

    @Override
    public double getMeasure() {
        return width*height;
    }

    public String toString() {
        return String.format("Rectangle2 [width=%,.1f, height=%,.1f]", width, height);
        //참고: System.out.format("출력하고 싶은 문자열%,.1f문자열", 123123.27);
    }
    // 필드
}


