package homework.two_array;

import java.util.Random;

/**
 * 표의 가로 합과 세로 합을 구하는 프로그램
 * 우선 키보드로부터 2차원 데이터의 행 수와 열 수를 입력받는다.
 * 입력받은 행 수와 열 수보다 가로 세로가 하나씩 큰 2차원 배열을 구성한다.
 * (가로 합과 세로 합을 추가하기 위해 가로 세로가 하나씩 큰 배열을 구성함)
 * 표의 데이터 부분에 난수를 채운다.
 * (난수의 최대값이 얼마가 되게 할 것인지는 키보드로부터 입력받아 정함)
 * 가로 합, 세로 합을 구해 표를 완성하고 출력한다.
 * @author 김이든
 */

import java.util.Scanner;

public class Table
{

    /**
     * 2차원 배열의 마지막 행과 마지막 열에 세로합과 가로합을 채운다.
     * 2차원 배열의 마지막 행과 마지막 열을 제외한 나머지 셀들에  데이터가 들어 있다.
     * @param m 2차원 배열
     */
    public static void total(int[][] m)
    {
        int sum = 0;
        for(int i=0; i< m.length-1; i++){
            for(int j=0; j<m[i].length-1; j++){
                sum = sum + m[i][j];
            }
        }
        System.out.print(sum);
    }

    /**
     * seed를 입력받고 난수를 생성한다.
     * 행 갯수와 열 갯수를 지정받고 배열을 생성한다.
     * @ author 김이든
     */

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Seed: ");
        long seed = input.nextLong();
        System.out.print("행 갯 수: ");
        int row = input.nextInt();
        System.out.print("열 갯 수: ");
        int col = input.nextInt();
        System.out.print("난수의 최대값: ");
        int max = input.nextInt();

        Random generator = new Random(seed);

        int[][] a = new int [row+1][col+1];
        int[] rowSum = new int[row];
        int[] colSum = new int[col];

        System.out.println();
        for(int i=0; i< a.length; i++){
            for(int j=0; j<a[i].length; j++){
                a[i][j] = generator.nextInt(max);
                System.out.print(a[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println();

        for(int i=0; i< a.length-1; i++){
            for(int j=0; j<a[i].length-1; j++){
                rowSum[i] = rowSum[i] + a[i][j];
            }
        }

        for(int i=0; i< a.length-1; i++){
            for(int j=0; j<a[i].length-1; j++){
                colSum[j] = colSum[j] + a[i][j];
            }
        }

        for(int i=0; i< a.length-1; i++){
            for(int j=0; j<a[i].length-1; j++){
                System.out.print(a[i][j]+"  ");
            }
            System.out.print(rowSum[i]);
            System.out.println();
        }
        for(int i=0; i< colSum.length; i++){
            System.out.print(colSum[i]+"  ");
        }
        total(a);
    }


}
