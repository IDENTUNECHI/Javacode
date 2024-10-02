package java2.week3;
import java.util.Random;

/**
 * 로또 번호 추천 프로그램
 */
public class LottoGenerator {

    private Random random; // 난수발생기를 가리킬 필드
    /**
     * 생성자.
     * @param generator 난수를 발생시키는데 사용할 난수발생기(Random)
     */
    public LottoGenerator (Random generator) {

        random = generator;

    }

    /**
     * 로또 복권에 적을 수 여섯 개를 만들어 준다.
     * @return
     */
    public int[] generateNumbers() {
        // 정수 배열을 가리키는 데 사용할 레퍼런스 변수 선언.
        int [] num;
        // 여섯 개의 방을 갖는 정수 배열을 구성.
        num = new int [6];
        // 여섯 개의 방 각각에 50미만의 정수 난수를 저장.
        for(int i=0; i<6; i++){
            int rannum = random.nextInt(50);
            num[i] = rannum;
        }
        // 배열(을 가리키는 참조)을 반환
        return num;
    }
}
