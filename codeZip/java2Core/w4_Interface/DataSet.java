package java2Core.w4_Interface;

public class DataSet {
    private double sum; // 측정값의 합
    private Measurable maximum; // 측정값이 가장 큰 놈
    private Measurable minimum;
    private int count;

    /**
     * 빈 DataSet을 하나 구성
     */
    public DataSet() {
        sum = 0;
        count = 0;
        maximum = null;
        minimum = null;
    }

    /**
     * DataSet에 sum으로 Measurable 하나를 추가한다.
     * @param x Measurable.
     */
    public void add(Measurable x) {
        sum += x.getMeasure();

        if(count == 0 || maximum.getMeasure() < x.getMeasure()){
            maximum = x;
        }
        count++;
    }

    /**
     * DataSet에 넣은 Measurable들의 측정값 평균을 계산한다.
     * @return 측정값의 평균값
     */
    public double getAverage() {
        return sum/count;
    }

    /**
     * DataSet에 넣은 Measurable들 중 측정값이 갖장 큰 값을 찾는다.
     * @return 측정값이 가장 큰 Mesurable.
     */
    public Measurable getMaximum() {
        return maximum;
    }

    /**
     * DataSet에 넣은 Measurable들 중 측정값이 가장 작은 값을 찾는다.
     */
    public Measurable getMinimum(){
        return minimum;
    }
}
