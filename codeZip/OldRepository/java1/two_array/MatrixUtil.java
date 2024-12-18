package OldRepository.java1.two_array;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
/**
 * 3개의 2차원 배열 a, b, c 선언
 * seed를 입력받고 난수를 생성
 * 난수를 a, b, c에 저장
 * @author 김이든
 */
public class MatrixUtil {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        int[][] a = new int[3][5];
        int[][] b = new int[1][10];
        int[][] c = new int[2][3];
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
        fillMatrixRandom(c, 10, generator);

        //0 이상 10 미만 정수 난수


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

    public static void fillMatrixRandom(int[][] array, int max, Random generator){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length; j++){
                array [i][j] = generator.nextInt(max);
            }
        }
        printMatrix(array);

    }
}