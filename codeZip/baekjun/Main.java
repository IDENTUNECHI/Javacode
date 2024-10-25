package baekjun;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int p = input.nextInt();
        int q = input.nextInt();
        int r = input.nextInt();
        int s = input.nextInt();
        int a_1 = input.nextInt();

        int sum = 0;
        int [] list = new int [n*20];
        list[1] = a_1;

        for(int i=1; i<n; i++) {
            list[2*i] = p*list[i]+q;
            list[2*i+1] = r*list[i]+s;
        }

        for(int i=1; i<=n; i++){
            sum += list[i];
        }

        //System.out.println(sum);


        // 개선된 풀이: 계산 시간을 줄임
        int result = list[1];
        for(int i=2; i<=n; i++) {
            if(i%2 == 0) {
                list[i] = p*list[i/2] +q;
            }
            else{
                list[i] = r*list[i/2] + s;
            }
            result += list[i];
        }

        System.out.println(result);
    }
}