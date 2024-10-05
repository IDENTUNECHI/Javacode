package java2.week4_interface;

//계좌
public class BankAccount implements Measurable {

    private double balance; // 인스턴스 필드!

    /** 주어진 balance를 가지는 계좌를 개설 */
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    /** 계좌로 돈을 입금 함 */
    public void deposit(double amount) {
        balance += amount;
    }

    /** 계좌로 부터 돈을 인출 함 */
    public void withdraw(double amount) {
        balance -= amount;
    }

    /** 현재 잔액을 리턴 */
    public double getBalance() {
        return balance;
    }

    @Override
    public double getMeasure() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("BankAccount [balance = %.1f]", balance);
    }
}


