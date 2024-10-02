package java2.week3;
import java.util.*;

/**
 * 주사위 한 개의 작동을 구현하는 프로그램
 */
public class Die {
    public final int MAX = 6;
    Random random;
    /**
     * 생성자
     * @param r 주사위를 굴려 수사를 만들어 낼 때 사용할 난수발생기.
     */
    public Die (Random r){
        random = r;
    }

    /**
     * 주사위를 굴린다. 주사위를 굴린 결과는 1 이상 6이하 정수이다.
     * @return 주사위를 굴려 나온 수사.
     */
    public int roll() {

        int rollNumber;
        rollNumber = random.nextInt(MAX);

        return rollNumber+1;
    }
}
