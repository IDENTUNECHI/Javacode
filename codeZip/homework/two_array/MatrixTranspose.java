package homework.two_array;


import java.util.Random;
import java.util.Scanner;

/**
 * int 타입 배열에 0 이상 10 미만 정수 난수를 넣은 후
 * 배열의 각 원소를 차례로 출력하는 프로그램
 * @author 김이든
 */

public class MatrixTranspose
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Seed: ");
        long seed = input.nextLong();
        Random generator = new Random(seed);
        int [][] a1 = new int [3][5];
        for (int i=0; i< a1.length; i++){
            for(int j=0; j<a1[i].length; j++ ){
                a1[i][j] = generator.nextInt(50);
                System.out.print(a1[i][j]+"	");
            }
            System.out.println();
        }
        System.out.println();
        int[][] transposed = transpose(a1);
        for (int i = 0; i < transposed.length; i++) {
            for (int j = 0; j < transposed[i].length; j++) {
                System.out.print(transposed[i][j]+"	");
            }
            System.out.println();
        }


    }

    /**
     * 주어진 정수 배열의 전치행렬을 구한다.
     * 새로운 배열을 생성한 후 배열의 순서를 뒤바꾸면서 값을 저장
     * @param matrix 주어진 행렬.
     * @return 전치행렬.
     */
    public static int[][] transpose(int [][] matrix) {
        int[][] transposed = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

}

