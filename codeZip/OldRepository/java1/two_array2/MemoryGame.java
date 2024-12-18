package OldRepository.java1.two_array2;
import java.util.*;

public class MemoryGame {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Seed: ");
        long seed = input.nextLong();
        Random generator = new Random(seed);

        int[] list; //난수를 저장할 배열
        int listLength; // list의 크기

        System.out.print("몇 개의 정수들을 보시겠습니까? ");
        listLength = input.nextInt();

        list = new int[listLength];
        ArrayUtil.fillRandomDistinct(list, 100, generator);

        for (int i=0; i<list.length; i++){  // 난수들을 화면에 보여줌
            System.out.println(list[i]);
        }

        System.out.print("1을 입력하면 숫자를 감춥니다. ");
        input.nextInt();
        for (int i=0; i<100; i++)
            System.out.println();

        System.out.println("어떤 숫자들이 있었는지 맞춰보세요.");
        System.out.println("입력을 끝내려면 음수를 입력하세요.");

        int [] answer = new int[100];
        int count = 0;
        for(int i=0; i<answer.length; i++){
            int n = input.nextInt();
            if(n<0){
                break;
            }
            else{
                answer[i] = n;
                count++;
            }
        }

        System.out.println(checkAnswers(list, answer, count)+"개 맞췄습니다.");



        input.close();
    }

    /**
     * 사용자가 입력한 정수들이 list에 몇 개나 들어 있는지 알아냄
     * list에는 난수들이 꽉 차 있다.
     * answer 배열에는 앞의 일부분에만 사용자가 입력한 답이 들어 있을 수 있다.
     *
     * @param list 서로 다른 난수가 들어있는 배열
     * @param answer 사용자가 입력한 정수들이 들어있는 배열
     * @param answerNumber answer에 들어있는 정수 개수
     * @return 사용자가 입력한 정수들이 list에 몇 개나 들어 있는지
     */
    public static int checkAnswers(int[] list, int[] answer, int answerNumber){
        int count = 0;
        for (int i=0; i<answerNumber; i++) {
            if (Search6.linearSearch(list, answerNumber, answer[i]) != -1 ){
                count++;
            }

        }
        return count;
    }
}
