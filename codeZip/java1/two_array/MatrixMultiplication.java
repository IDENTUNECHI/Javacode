package java1.two_array;


import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * 행렬의 곱셈
 * @author 김이든
 */
public class MatrixMultiplication
{

    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Seed: ");
        long seed = input.nextLong();
        Random generator = new Random(seed);
        int [][] a = new int[3][5];
        int [][] b = new int[5][3];
        for(int i=0; i< a.length; i++){
            for(int j=0; j<a[i].length; j++){
                a[i][j] = generator.nextInt(10);
                System.out.print(a[i][j]+"  ");
            }
            System.out.println();
        }
        for(int i=0; i< b.length; i++){
            for(int j=0; j<b[i].length; j++){
                b[i][j] = generator.nextInt(10);
                System.out.print(b[i][j]+"  ");
            }
            System.out.println();
        }

        int[][] multi = multiply(a, b);

        for(int i=0; i< a.length; i++){
            for(int j=0; j<b[i].length; j++){
                System.out.print(multi[i][j]+ "  ");
            }
            System.out.println();
        }

    }

    /**
     * 주어진 두 정수 행렬의 곱행렬을 구한다.
     * 전제조건: 첫 행렬의 열 갯수와 두 번째 행렬의 행 갯수는 같아야 한다.
     * @param a 첫 행렬.
     * @param b 두 번째 행렬.
     * @return multi 행렬의 곱셈
     */
    public static int[][] multiply(int[][] a, int[][] b)
    {
        int [][] multi = new int[a.length][b[0].length];

        for(int i=0; i< a.length; i++){
            for(int j=0; j<b[0].length; j++){
                for(int k=0; k< a[0].length; k++){
                    multi[i][j] = multi[i][j] + a[i][k]*b[k][j];
                }
            }
        }
        return multi;
    }
}

