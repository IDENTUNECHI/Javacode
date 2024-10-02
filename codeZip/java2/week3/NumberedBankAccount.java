package java2.week3;

public class NumberedBankAccount {
    private int accountNumber; // 필드 계좌번호
    private double balance; // 필드 잔액
    private static int nextAccount = 100; // 스태틱 필드, 다음에 부여할 계좌번호

    /**
     * 잔액이 0.0인 계좌를 구성한다.
     */
    public NumberedBankAccount() {
        balance = 0.0;
    }

    /**
     * 주어진 금액을 초기 잔액으로 갖는 계좌를 구성한다
     * @param initialBalance 초기 잔액
     */
    public NumberedBankAccount(double initialBalance){
       balance = initialBalance;
       // accounts를 증가시키고 계좌번호를 부여한다

        accountNumber = nextAccount++;
    }

    /**
     * 계좌번호를 읽는다.
     *
     * @return 계좌번호
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * 계좌에 입금한다.
     *
     * @param amount 입금할 금액
     */
    public void deposit(double amount) {
        balance = balance + amount;
    }

    /**
     * 계좌 출금
     *
     * @param amount 출금시킬 금액
     */
    public void withdraw(double amount) {
        balance = balance - amount;
    }

    /**
     * 잔액이 얼마인지 알아본다.
     * @return 잔액
     */
    public double getBalance() {
        return balance;
    }

    /**
     * 다른 계좌로 amount 만을 계좌 이체한다.
     * @param amount 송금할 금액
     * @param  other 다른 계좌
     */
    public void transfer(double amount, NumberedBankAccount other){
        this.withdraw(amount); // this  생략 가능
        other.deposit(amount); // 다른 객체에게 매소드를 호출함
    }

    /**
     * 계좌 번호와 잔액을 출력
     * "NumberedBanksAccount[accountNumber = 100, balance=2500.0]"
     *
     * @return 출력값
     */
    public String toString() {
        return "NumberedBankAccount[accountNumber=" + accountNumber + ",balance=" + balance + "]";
    }

}
