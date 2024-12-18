package OldRepository.java1.two_array;
import java.util.Random;
import java.util.Scanner;
/**
 * 2차원 배열 선언
 * seed를 입력받고 난수 생성
 * 그 난수를 2차원 배열 a, b에 저장
 * @author 김이든
 */
public class MatrixUtil1 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[][] a = new int[3][5];
        int[][] b = new int[1][10];
        System.out.print("Seed: ");
        long n_seed = input.nextLong(); // seed 설정
        Random generator = new Random(n_seed);
        for(int i = 0; i<3; i++){
            for(int j= 0; j<5;j++){
                a[i][j] = generator.nextInt(100);
            }
        }

        for(int i = 0; i<1; i++){
            for(int j= 0; j<10;j++){
                b[i][j] = generator.nextInt(100);
            }
        }
        printMatrix(a);
        printMatrix(b);
    }

    /* 주어진 이차원 배열의 원소를 차례로 출력한다.
     * @param array 출력할 배열(을 가리키는 참조변수).
     */
    public static void printMatrix(int[][] array){
        for(int i = 0; i<array.length; i++){
            for(int j= 0; j<array[i].length; j++){
                System.out.print(array[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
