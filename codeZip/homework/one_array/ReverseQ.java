package homework.one_array;

import java.util.Scanner;

/**
    * 문자열 word를 입력받은 뒤
    * 숫자들은 int로 변환, q or Q가 입력되면 입력 끝
    * 정수들은 배열 n에 저장되고 n을 역순으로 출력
    * 숫자들의 평균을 구해 출력
    * //n[count] = n1; 부분에서 방 할당 위치를 생각하는 과정이 어려웠음
    * @author 김이든
    */
public class ReverseQ {
   public static void main(String[] args){
       Scanner input = new Scanner(System.in);
       int count = 0;
       int n1;
       int sum = 0;
       int[] n = new int[100];
       System.out.print("정수 입력: ");
       while (true){
           String word = input.next();
           if(word.equals("q") || word.equals("Q")){
                             input.close();
               break;
           }
           else{
               n1 = Integer.parseInt(word);
               n[count] = n1;
               sum += n1;
               count++;

           }
       }

       for(int i = count-1; i >= 0; i--){
           System.out.print(n[i]+ " ");
       }
       double avarage = (double) sum/count;
       System.out.println("\n평균: "+ avarage);
   }

}