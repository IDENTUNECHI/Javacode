package java2.week3;
import java.util.*;

public class Dice {
    private Die die1;
    private Die die2;

    /**
     * 생성자
     * @param r 주사위를 굴려 숫자를 만드렁 낼 떄 사용할 난수발생기
     */
    public Dice(Random r){
        die1 = new Die(r);
        die2 = new Die(r);

    }
    /**
     * 주사위 쌍을 굴린다.
     * @return 주사위 두 쌍의 숫자 합
     */
    public int roll() {
        int di1 = die1.roll();
        int di2 = die2.roll();

        return di1+di2;
    }
}
