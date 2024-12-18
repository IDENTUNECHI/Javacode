package OldRepository.Java2Practice.Interface;

import java.util.*;


public class DataSetTester {
    private void test() {
        Scanner input = new Scanner(System.in);
        System.out.print("Seed: ");
        int seed = input.nextInt();
        Random random = new Random(seed);

        DataSet dataSet = new DataSet();

        // 가로와 세로 길이가 100.0 미만인 난수를 갖는 Rectangle2 객체 100개 생성
        for (int i = 0; i < 100; i++) {
            double width = random.nextDouble() * 100;
            double height = random.nextDouble() * 100;

            Rectangle2 rect = new Rectangle2(width, height);
            dataSet.add(rect); // Rectangle2 객체들을 dataSet.add()로 전송
            // Rectangle2 에 implements Measurable을 선언 안해줄시 오류 발생
        }

        /**
         * dataSet.getMaxiMum()의 타입은 인터페이스 Measurable이다.
         * 따라서 Rectangle2의 메소드, 특히 toString()을 사용하기 위해서는
         * dataSet.getMaxiMum()을 다운케스팅 해야한다.
         */

        Rectangle2 largest = (Rectangle2) dataSet.getMaxiMum();

        System.out.println("Rectangle2 with the largest area: "+ largest.toString());
        System.out.printf("The Largest area: %,.1f\n", largest.getMeasure());
        System.out.printf("Average area: %,.1f\n", dataSet.getAverage());

        //--------------------------------------------------------------------------------//

        // BankAccount

        DataSet dataset2 = new DataSet();

        for(int i=0; i<100; i++) {
            BankAccount bankAccount = new BankAccount(random.nextDouble() * 10000.0 );
            dataset2.add(bankAccount);
        }

        BankAccount largestBank = (BankAccount) dataset2.getMaxiMum();
        BankAccount smallestBank = (BankAccount) dataset2.getMiniMum();

        System.out.println("Rectangle2 with the largest area: "+ largestBank.toString());
        System.out.println("Rectangle2 with the smallest area:" + smallestBank.toString());
        System.out.printf("Average balance: %,.1f\n", dataset2.getAverage());


    }

    public static void main(String[] args) {
        DataSetTester dataSetTester = new DataSetTester();
        dataSetTester.test();
    }
}
