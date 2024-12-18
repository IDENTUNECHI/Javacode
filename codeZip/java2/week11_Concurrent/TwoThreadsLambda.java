package java2.week11_Concurrent;

import java.util.concurrent.TimeUnit;

public class TwoThreadsLambda {
    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                for(int i=1; i <=100; i++){
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    TimeUnit.MILLISECONDS.sleep(500);
                }
            }
            catch (InterruptedException e) {
                System.out.println("인터럽트에 의해 작업 중단");
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        System.out.println("main 메소드 끝.");
    }
}
