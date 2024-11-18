package java2.java2Core.w3_Object2;

import java.util.Scanner;

public class Counter {
    private int value; // Counter의 현재 값

    /**
     * 생성자
     */
    public Counter(){
        value = 0;
    }

    public Counter(int initialization){
        value = initialization;
    }

    /**
     * 양수가 나오면 횟수 +1
     */

    public void countUp(){
        value += 1;
    }

    /**
     * 음수가 나오면 횟수-1
     */
    public void countDown() {
        value += -1;
    }

    public void reset() {
        value = 0;
    }

    public int getValue(){
        return value;
    }

    public static void main(String[] args) {
        Counter tst = new Counter();
        Scanner input = new Scanner(System.in);
        Boolean done = true;

        System.out.println("Counting positive and negative integers.");
        while(done){

            System.out.print("Enter an integer: ");
            int scan = input.nextInt();

            if(scan>0){
                tst.countUp();

            }
            
            else if(scan<0) {
                tst.countDown();
            }

            else if(scan == 0){
                done = false;
                System.out.println("Number of positive integers - number of negative integers = "+ tst.getValue());
            }
        }
    }


}
