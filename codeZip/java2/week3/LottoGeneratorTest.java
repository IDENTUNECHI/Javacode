package java2.week3;
import java.util.*;

/**
 * 로또 번호 테스트 출력 프로그램
 */

public class LottoGeneratorTest {
    public static void main(String[] args) {

        int [] numbers; // 정수 배열을 가리키는 데 사용할 레퍼런스 변수

        System.out.print("Seed: ");
        Scanner input = new Scanner(System.in);
        long seed = input.nextLong();
        Random random = new Random(seed);

        //RottoGenerator 인스턴스 구성
        LottoGenerator generator = new LottoGenerator(random);


        // 여섯 개의 숫자로 이루어진 로또 번호를 10번 만들어 준다.
        for (int n=0; n<10; n++) {
            // LottoGenerator에게 로또 번호 여섯 개를 만들도록 지시함.
            numbers = generator.generateNumbers();

            for (int i=0; i<6; i++){
                System.out.print(numbers[i]+" ");
            }
            System.out.println();
        }
    }
}
