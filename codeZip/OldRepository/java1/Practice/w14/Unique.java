package OldRepository.java1.Practice.w14;


import java.util.Scanner;
/**
 * 10개 이내의 단어를 입력 받아 중복을 제거하고 나머지 단어들을 한 줄에 한 단어씩 출력하는 프로그램
 * LinkedHashSet을 사용해 중복된 String을 제거하고 입력받은 값은 순서대로 출력한다.
 * @author 김이든
 */
public class Unique {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String str = input.nextLine();

        String [] a = str.split(" ");

        boolean cheak = true;

        for(int i=0; i< a.length; i++){
           for(int j=0; j<i; j++){
               if(a[i].equals(a[j])){
                   cheak = false;
               }
           }
           if(cheak){
               System.out.println(a[i]);
           }

           cheak = true;
        }

    }
}

