package java2.week4_interface;
import java.util.*;

public class DataSetTester {
    private void test() {
        Scanner input = new Scanner(System.in);
        System.out.print("Seed: ");
        int seed = input.nextInt();
        Random random = new Random(seed);

        DataSet dataset = new DataSet();

        // 가로와 세로 길이가 100.0 미만인 난수를 갖는 Rectangle2 객체 100개 생성
        for (int i = 0; i < 100; i++) {
            double width = random.nextDouble() * 100;
            double height = random.nextDouble() * 100;

            Rectangle2 rect = new Rectangle2(width, height);
            dataset.add(rect);
        }

        Rectangle2 largest = (Rectangle2) dataset.getMaximum();

        System.out.println("Rectangle2 with the largest area: "+ largest.toString());
        System.out.printf("The Largest area: %,.1f\n", largest.getMeasure());
        System.out.printf("Average area: %,.1f\n", dataset.getAverage());


        // 만약 기존에 생성된 dataSet을 쓴다면 Rectangle2와 BankAccount
        // 혼합하여 추가하게 된다. 그 결과 DataSet의 getMaximum() 메서드가
        // 서로 다른 타입의 객체를 처리 할 수 없게 되어 ClassCastException 오류가 발생
        // 그러므로 새로운 dataSet2 선언해야함
        DataSet dataSet2 = new DataSet();

        for (int i = 0; i < 100; i++) {
            double initialization = random.nextDouble() * 10000;
            BankAccount bank = new BankAccount(initialization);

            dataSet2.add(bank);
        }

        BankAccount max = (BankAccount) dataSet2.getMaximum();
        BankAccount min = (BankAccount) dataSet2.getMinimum();

        System.out.println("\nBankAccount with the largest balance: "+ max.toString());
        System.out.println("BankAccount with the smallest balance: "+ min.toString());
        System.out.printf("Average balance: %,.1f", dataSet2.getAverage());

    }

    public static void main(String[] args) {
        new DataSetTester().test();
    }
}
