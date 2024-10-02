package java2.week3;

public class BankAccountTester {
    /**
     Tests the methods of the BankAccount class.
     @param args not used
     */
    public static void main(String[] args)
    {
        BankAccount cheak1 = new BankAccount();
        BankAccount cheak2 = new BankAccount(1000.0);

        cheak1.deposit(500.0); // 입금
        cheak1.withdraw(100.0); // 출금
        System.out.println("Balance of the first account = " + cheak1.getBalance());

        cheak2.deposit(500.0);
        cheak2.withdraw(100.0);
        System.out.println("Balance of the second account = " + cheak2.getBalance());
    }
}
