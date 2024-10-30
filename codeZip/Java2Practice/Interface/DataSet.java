package Java2Practice.Interface;

public class DataSet {

    private double sum; // 측정값의 합
    private Measurable maximum; // 측정값이 가장 큰 놈
    private Measurable minimum;
    private int count;

    public DataSet() {
        sum = 0;
        count = 0;
        maximum = null;
        minimum = null;
    }

    /**
     * DataSet에 Measurable 하나를 추가
     * @param x Measurable
     */
    public void add(Measurable x) {
        sum += x.getMeasure();
        if(count == 0 || maximum.getMeasure() < x.getMeasure())
            maximum = x;

        if(count == 0 || minimum.getMeasure() > x.getMeasure())
            minimum = x;

        count++;
    }

    /**
     * DataSet에 넣은 Measurable 들의 측정값 평균을 계산한다.
     * @return 측정값의 평균값
     */
    public double getAverage() {
        if(count == 0)
            return 0;

        return sum / count;
    }

    /**
     * DataSet에 넣은 Measurable들 중 측정값이 가장 큰 놈을 찾는다
     * @return 측정값이 가장 큰 Measurable.
     */

    public Measurable getMaxiMum() {
        return maximum;
    }
    public Measurable getMiniMum() {
        return minimum;
    }
}
