package java2.week3;
import java.util.*;

/**
 * 두 주사위를 던지고 그 합을 구하는 프로그램
 */
public class DiceCasting1 {
    public static void main(String[] args) {

        System.out.print("Seed: ");
        Scanner input = new Scanner(System.in);
        long seed = input.nextLong();
        Random random = new Random(seed);

        Dice rol = new Dice(random);
        for(int i=0; i<10; i++) { // 10번을 굴린다
            System.out.println(rol.roll());
        }

    }
}
