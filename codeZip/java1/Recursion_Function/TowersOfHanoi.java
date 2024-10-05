package java1.Recursion_Function;

/**
 * TowersOfHanoi.java
 * @author 김이든
 */
import java.util.Scanner;

public class TowersOfHanoi {

    public static void main (String [] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("원반 갯수: ");
        int disks = reader.nextInt();
        // disks 개의 원반을 1번 말뚝에서 3번 말뚝으로 옮긴다. 2번 말뚝은 보조말뚝으로 사용한다.
        move (disks, 1, 3, 2);
        reader.close();
    }

    /**
     * 하노이탑 재귀 알고리즘.
     * n개의 원반을 i번 말뚝에서 j번 말뚝으로 옮기는 절차를 인쇄한다.
     * @param n 원반 갯수.
     * @param i 출발점 말뚝 번호.
     * @param j 도착점 말뚝 번호.
     * @param k 보조 말뚝 번호.
     */
    private static void move (int n, int i, int j, int k){

        if (n > 0) {                // 종료조건: n == 0. n이 0일 때는 아무 일도 하지 않고 리턴한다.

            move (n-1, i, k, j);	// n-1 개의 작은 원반들을 i번 말뚝에서 k번 말뚝으로 옮긴다(옮기는 절차를 인쇄한다).

            // 가장 큰 원반을 i번 말뚝에서 j번 말뚝으로 옮긴다(옮기는 절차를 인쇄한다). 이 작업은 재귀함수 호출이 아니다.
            System.out.println("Move disk " + n + " from (" + i + ") to (" + j + ")");

            move (n-1, k, j, i );	// n-1 개의 작은 원반들을 k번 말뚝에서 j번 말뚝으로 옮긴다(옮기는 절차를 인쇄한다).
        }
    }
}


