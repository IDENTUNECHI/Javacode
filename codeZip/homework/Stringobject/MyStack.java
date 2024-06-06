package homework.Stringobject;

import java.util.*;

public class MyStack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {

            String line = input.nextLine();
            String[] lineToken = line.split(" ");

            // 최대 100개의 요소 저장 가능 배열 스택
            String[] mystack = new String[100];

            int top = -1; // 스택의 맨 위 인덱스, -1은 스택이 비어있음을 나타냄


            for (int i=0; i<lineToken.length; i++) {
                if(lineToken[i].equals("*")){
                    if(top >= 0){
                        mystack[top] = null;
                        top--;
                    }
                }
                else{
                    top++;
                    mystack[top] = lineToken[i];
                }
            }

            for(int j=top; j>=0; j--){
                System.out.print(mystack[j]+" ");
            }
            System.out.println();
        }
        input.close();
    }
}
