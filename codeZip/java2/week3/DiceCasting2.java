package java2.week3;

import java.util.Random;
import java.util.Scanner;

/**
 * Dice의 roll을 1000번 호출하여 반환되는 수의 빈도 수를 측정
 * @author 김이든
 */
public class DiceCasting2 {
    public static void main(String[] args) {

        System.out.print("Seed: ");
        Scanner input = new Scanner(System.in);
        long seed = input.nextLong();
        Random random = new Random(seed);

        Dice rol = new Dice(random);
        int [] count = new int [12]; // count 변수의 무분별한 사용을 지양하기 위해 리스트로 각 빈도 수 저장


        for(int i=0; i<1000; i++){
            int num = rol.roll();
            switch(num) { //switch case를 사용하여 직관적으로 처리, 다만 코드 수가 다소 길어진다
                case 1:
                    count[0] = 0;
                    break;
                case 2:
                    count[1] += 1;
                    break;
                case 3:
                    count[2] += 1;
                    break;
                case 4:
                    count[3] += 1;
                    break;
                case 5:
                    count[4] += 1;
                    break;
                case 6:
                    count[5] += 1;
                    break;
                case 7:
                    count[6] += 1;
                    break;
                case 8:
                    count[7] += 1;
                    break;
                case 9:
                    count[8] += 1;
                    break;
                case 10:
                    count[9] += 1;
                    break;
                case 11:
                    count[10] += 1;
                    break;
                case 12:
                    count[11] += 1;
                    break;
            }
        }

        for(int i=0; i<12; i++) {
            System.out.println((i+1)+":\t"+count[i]);
        }

    }
}
