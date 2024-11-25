package baekjun;
import java.util.Scanner;

/**
 * <a href="https://www.acmicpc.net/problem/32372">...</a>
 *
 * 문제에서 정의한 보물에 위치 조건을 여사건을 통해
 * 먼저 보물이 없는 곳을 특정해 낸다.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean [][] map = new boolean[n+1][n+1];

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                map[a][b] = true;
            }
        }


        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int k = sc.nextInt();
            map[x][y] = false;

            for(int a=1; a<=n; a++){
                for(int b=1; b<=n; b++){

                    if(!map[a][b]) continue;

                    if (k == 1) {
                        if (a >= x || b != y)
                            map[a][b] = false;
                    } else if (k == 2) {
                        if (a >= x || b <= y)
                            map[a][b] = false;
                    } else if (k == 3) {
                        if (a != x || b <= y)
                            map[a][b] = false;
                    } else if (k == 4) {
                        if (a <= x || b <= y)
                            map[a][b] = false;
                    } else if (k == 5) {
                        if (a <= x || b != y)
                            map[a][b] = false;
                    } else if (k == 6) {
                        if (a <= x || b >= y)
                            map[a][b] = false;
                    } else if (k == 7) {
                        if (a != x || b >= y)
                            map[a][b] = false;
                    } else if (k == 8) {
                        if (a >= x || b >= y)
                            map[a][b] = false;
                    }
                }
            }
        }

        for (int a =1; a <=n; a++) {
            for (int b=1; b <=n; b++) {
                if(map[a][b]) {
                    System.out.println(a+" "+b);
                }
            }
        }

    }
}




