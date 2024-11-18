package java2.java2Core.w2_Object1;

/**
 * 최대값에 도달하면 다시 0부터 세기 시작하는 계수기
 * @author 김이든
 * @version 1.0
 */

public class Counter3 {

    private int count = 0;
    private int max = 10;

    public Counter3(){}

    public Counter3(int max){
        this.max = max;
    }



    /**
     * count 값을 증가시킨다.
     * 만약 count 값이 MAX 이상이라면 0으로 돌아간다.
     */
    public void tick(){
        if(count<max){
            count++;
        }
        else{
            count = 0;
        }
    }

    /**
     *  Getter 메소드
     * @return 현재의 count 값
     * (0 <= 반환값 <= max)
     */
    public int getCount() {

        return count;
    }

    /**
     *  현재의 count 값을 설정한다.
     * @param number count 값으로 설정할 수
     *               (전제조건 : 0<= number <= max)
     */
    public void setCount(int number) {
        this.count = number;
    }
    /**
     * count 설정 값이 유효 범위 내에 있는지 검사
     * @param number
     * @return bool
     */
    private boolean isInputValid(int number) {
        return 0<=number && number <=max;
    }

    public static void main(String[] args) {


        Counter3 c12 = new Counter3(12);
        Counter3 c60 = new Counter3(60);

        c12.setCount(11);

        c12.tick();
        System.out.println(c12.getCount());
        c12.tick();
        System.out.println(c12.getCount());
        c12.tick();
        System.out.println(c12.getCount());
        c12.tick();
        System.out.println(c12.getCount());
        System.out.println();

        c60.setCount(59);

        c60.tick();
        System.out.println(c60.getCount());

        c60.tick();
        System.out.println(c60.getCount());

        c60.tick();
        System.out.println(c60.getCount());

        c60.tick();
        System.out.println(c60.getCount());
    }
}
