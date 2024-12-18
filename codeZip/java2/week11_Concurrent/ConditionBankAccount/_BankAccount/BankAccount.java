package java2.week11_Concurrent.ConditionBankAccount._BankAccount;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

	public static final double MAX_BALANCE = 100000;

	private double balance = 0.0;

	private Lock balanceLock = new ReentrantLock();
	private Condition condition = balanceLock.newCondition();

	public void deposit(double amount) {
		balanceLock.lock();
		try {
			balance += amount;
			System.out.println("입금 후 잔액: " + balance);
			// 이 Condition으로 대기 상태에 있는 스레드를 깨워준다.
			condition.signalAll();
		} finally {
			balanceLock.unlock();
		}
	}

	public void withdraw(double amount) {

		balanceLock.lock();
		try {
			// 잔액이 충분할 때까지 기다린다.
			while (balance < amount) {
				try {
					// Lock을 풀고 대기 상태로 들어간다.
					condition.await();
					// 대기 상태에서 복귀하면서 Lock을 다시 점유한다.
				} catch (InterruptedException e) { }
			}
			balance -= amount;
			System.out.println("출금 후 잔액: " + balance);
		} finally {
			balanceLock.unlock();
		}
	}

	public double getBalance() {
		return balance;
	}

}
