package OldRepository.Java2Practice.Interface;

// 계좌
public class BankAccount implements Measurable {

    private double balance; // 인스턴스 필드!

    public BankAccount (double initialBalance) {
        balance = initialBalance;
    }

    /** 계좌로 돈을 입금 함 */

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw (double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public double getMeasure() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("BankAccount[balance = %.1f]", balance);
    }
}

