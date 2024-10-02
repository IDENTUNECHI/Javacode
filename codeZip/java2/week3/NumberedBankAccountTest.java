package java2.week3;

public class NumberedBankAccountTest {
    public static void main(String[] args) {
        NumberedBankAccount account1 = new NumberedBankAccount(1000.0); //계좌 1 생성
        NumberedBankAccount account2 = new NumberedBankAccount(0.0); //계좌 2 생성
        NumberedBankAccount account3 = new NumberedBankAccount(0.0); // 계좌 3 생성


        System.out.println("Account1: " + account1.toString());
        System.out.println("Account2: " + account2.toString());
        System.out.println("Account3: " + account3.toString());

        System.out.println("Transfer 300.0won: account --> account2");
        account1.transfer(300.0, account2); // 송금 메소드 호출, 300.0원을 account1이 account2에게 송금한다.

        System.out.println("Account1: " + account1.toString());
        System.out.println("Account2: " + account2.toString());
        System.out.println("Account3: " + account3.toString());
    }
}
