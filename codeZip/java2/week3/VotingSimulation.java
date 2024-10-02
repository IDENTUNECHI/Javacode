package java2.week3;

import java.util.Random;
import java.util.Scanner;

public class VotingSimulation {
    public static void main(String[] args) {
        System.out.print("Seed: ");
        Scanner input = new Scanner(System.in);
        long seed = input.nextLong();
        Random random = new Random(seed);

        VotingMachine voteMachine = new VotingMachine();

        for(int i=0; i<1000; i++) { //1000명에게 호구 조사
            if(random.nextBoolean()){
                voteMachine.voteForSun();
            }
            else
                voteMachine.voteForTkeokk();
        }

        System.out.println("Sundae: "+ voteMachine.getSunVotes());
        System.out.println("Tteokbokki: "+ voteMachine.getTkeokkVotes());

        input.close();
    }
}
