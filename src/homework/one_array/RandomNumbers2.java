package homework.one_array;
import java.util.Scanner;
import java.util.Random;
/**
 * int 타입 배열에 0이상 100 미만 정수 난수를 넣은 후
 * 배열의 각 원소를 차례로 출력하고
 * 배열의 원소들 중 가장 큰 수와 가장 작은 수를 찾아 출력하고
 * 배열의 원소들의 평균을 구해 출력
 * @author 김이든
 * RandomNumbers2
 */
public class RandomNumbers2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        final int SIZE = 10; // 배열의 크기
        int[] randomArray = new int[SIZE];
        int j = 0;
        System.out.print("Seed: ");
        long n_seed = input.nextLong();
        Random generator = new Random(n_seed);
        // 배열에 100미만 난수를 채워 넣는다.
        while(j<10){
            randomArray[j++] = generator.nextInt(100);
        }

        // 배열의 원소들 중 최솟값, 최댓값, 평균 구함
        int min = randomArray[0]; // 초기값 설정
        int max = randomArray[0]; // 초기값 설정
        long sum = 0;

        for (int i = 0; i < SIZE; i++) {
            //배열 더해주기
            sum += randomArray[i];

            // 최솟값 갱신
            if (randomArray[i] < min) {
                min = randomArray[i];
            }

            // 최댓값 갱신
            if (randomArray[i] > max) {
                max = randomArray[i];
            }
            
        }
        double avarage = (double) sum/10;

        // 최종 출력
        for(int i = 0; i<SIZE; i++) {
            System.out.print(randomArray[i]+" "); //배열 출력
        }
        System.out.println("\n최소: "+ min); //최솟값
        System.out.println("최대: "+ max); // 최댓값
        System.out.println("평균: "+avarage); //평균
    }
}
