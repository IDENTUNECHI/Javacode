package OldRepository.java1.Practice.w14;

import java.util.*;

public class MyStack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(input.hasNextLine()){
            String line = input.nextLine();
            String [] lineToken = line.split(" ");

            String[] mystack = new String[100];

            int top = -1;

            for(int i=0; i< lineToken.length; i++){
                if(lineToken[i].equals("*")) {
                    if (top >= 0) {
                        mystack[top] = null;
                        top--;
                    }
                }
                    else{
                        top++;
                        mystack[top] = lineToken[i];
                    }
            }

        }


    }
}

