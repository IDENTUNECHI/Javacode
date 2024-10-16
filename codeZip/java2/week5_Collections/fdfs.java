package java2.week5_Collections;


import java.util.*;

public class fdfs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Number of primes: ");
        int n = input.nextInt();

        List<Long> list = new ArrayList<>();
        list.add(2L);
        list.add(3L);

        System.out.println(list.get(0));
        System.out.println(list.size());

    }


}

