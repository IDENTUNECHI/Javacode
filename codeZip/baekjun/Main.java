package baekjun;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] list = new int[n];
        int count = 0;

        for(int i=0; i<n; i++){
            list[i] = sc.nextInt();
            if(list[i] % 2 == 1){
                count++; // 전체 배열 요소 중 홀수의 개수
            }
        }

        if(count % 2 == 0){  // 홀수의 개수가 짝수개인 경우 집합들의 개수가 짝수이면서 집합들 내부의 합이 짝수
            if(count == 2){  // 1. 홀수의 개수가 2개인 경우
                if((list[0] % 2 == 1) && (list[n - 1] % 2 == 1)){ // 양 끝이 홀수인 경우만 오류
                    System.out.println(0);
                }
                else{
                    System.out.println(1);
                }
            }

            else if(count == 0){ // 2. 홀수의 개수가 0개인 경우
                if(n == 1) System.out.println(0); // 홀수의 개수가 0개이면서 전체 개수가 1개인 경우 무조건 홀수 집합이면서 합이 짝수이므로 오류
                else System.out.println(1);
            }

            else{ // 3. 그 외에 홀수의 개수가 짝수인 모든 경우는 무조건 성립
                System.out.println(1);
            }
        }

        else{  // 홀수의 개수가 홀수개인 경우 전체 집합이 홀수이므로 무조건 성립
            System.out.println(1);
        }
    }


}
