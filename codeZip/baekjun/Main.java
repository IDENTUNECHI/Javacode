package baekjun;
import javax.swing.*;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int [] a = new int [n];
        for(int i=0 ;i<n; i++){
            a[i] = input.nextInt();

        }
        Arrays.sort(a);
        int m = input.nextInt();
        int [] b = new int [n];
        for(int i=0 ;i<m; i++){
            b[i] = input.nextInt();
        }
        Arrays.sort(b);
        int [] result = new int [m];
        int low = 0;
        int high = b.length;
        while(low<=high){
            for(int i=0; i<m; i++){
                int mid = (high+low)/2;
                if(a[mid]>b[i]){
                    high = mid-1;
                }
                else if (a[mid] < b[i])
                    high = mid + 1;
                else
                    result[i] = 1;
            }
        }

        for(int factor: result){
            System.out.println(factor);
        }

    }

}