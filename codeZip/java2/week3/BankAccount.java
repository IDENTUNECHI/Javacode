package java2.week3;

/**
 * 은행계좌 잔액을 관리하며 인출, 입금이 가능하다.
 */
public class BankAccount {
    private double balance; // 인스턴스 필드

    public BankAccount() {
        balance = 0.0;
    }
    public BankAccount(double initialBalance)  {
        balance = initialBalance;
    }
    public void deposit(double amount) {
        double newBalance = balance + amount;
        balance = newBalance;

    }
    public void withdraw(double amount) {
        double newBalance = balance - amount;
        balance = newBalance;

    }
    public double getBalance() {
        return balance;
    }

}
