package java2.week3;

import java.util.Random;
import java.util.Scanner;

/**
 * test 프로그램
 */
public class VotingSimulation2 {
    public static void main(String[] args) {
        System.out.print("Seed: ");
        Scanner input = new Scanner(System.in);
        long seed = input.nextLong();
        Random random = new Random(seed);

        VotingMachine2 voteMachine = new VotingMachine2();

        for(int i=0; i<1000; i++) {
            if(random.nextBoolean()){
                voteMachine.vote("Sundae");
            }
            else
                voteMachine.vote("Tteokbokki");
        }

        System.out.println("Sundae : "+ voteMachine.getVotes("Sundae"));
        System.out.println("Tteokbokki: "+ voteMachine.getVotes("Tteokbokki"));

        input.close();
    }
}
