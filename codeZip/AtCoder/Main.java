package AtCoder;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int [] list = new int [25];
        for(int i=0; i<24; i++){
            list[i] = i;
        }

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        if(b<=c){
            if(b<=a && a<=c){
                System.out.println("No");
            }
            else
                System.out.println("Yes");
        }
        else if(b>c){
            // b>c인 경우에 자정을 반드시 넘기기 때문에 b~23시 와 0~c
            // 의 경우를 나누어서 구한다.
            if(b < a && a < 23 || 0 <= a && a<= c){
                System.out.println("No");
            }
            else
                System.out.println("Yes");
        }
    }
}
