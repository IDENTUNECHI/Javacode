package java2.week11_Concurrent;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// (아무것도 리턴하지 않는) Runnable.
		// Runnable의 run 메소드는 예외를 던지지 않기 때문에
		// 람다식 내에서 발생하는 확인예외는 반드시 람다식 내에서 처리해야 한다.
		// 람다식은 나중에 실행할 코드이므로 지금 당장 실행되지 않는다.
		// 아래에서는 람다식을 runnableTask라는 변수에 저장한다.
		Runnable runnableTask = () -> {
			try {
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.println(Thread.currentThread().getName() 
						+ ": Runnable 실행 끝 " + LocalTime.now());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		// (String을 리턴하는) Callable.
		// Callable의 call 메소드는 예외를 던지는 놈이므로
		// 람다식 안에서 발생하는 확인예외 InterruptedException을 그 내부에서 처리하지 않고
		// 바깥으로 내보낼 수 있다.
		// 람다식 바깥으로 던져진 예외는 main 메소드에서 잡아 처리할 수도 있고
		// main 메소드 역시 바깥으로 다시 던질 수도 있다.
		// 이 프로그램에서는 바깥으로 던지므로 main 헤더에 throws 절이 붙어있다.
		Callable<String> callableTask = () -> {
			TimeUnit.MILLISECONDS.sleep(500);
			System.out.println(Thread.currentThread().getName() 
					+ ": Callable 실행 끝 " + LocalTime.now());
			return "hi";
		};
 
		// Executors 클래스의 static 메소드를 이용하여 ExecutorService 객체를 얻는다.
		// 이 ExecutorService 객체는 내부에 thread pool을 갖고 있다.
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(runnableTask); // execute 메소드는 즉시 리턴한다. runnableTask는 es의 쓰레드에서 실행된다.
		System.out.println(Thread.currentThread().getName() 
				+ ": es.execute(runnableTask) 호출 직후 " + LocalTime.now());

		Future<?> f = es.submit(runnableTask); // submit 메소드는 즉시 리턴한다.
		System.out.println(Thread.currentThread().getName() 
				+ ": es.submit(runnableTask) 호출 직후 " + LocalTime.now());
		// 아무 것도 반환하지 않는 Runnable을 submit하면 null이 들어있는 Future<?>이 반환된다.
		assertNull(f.get()); // assert(a)는 a가 null이면 이 문장이 조용히 넘어간다. 그렇지 않으면 예외가 발생한다.
		System.out.println();

		Future<String> future = es.submit(callableTask); // submit은 즉시 리턴한다.
		System.out.println(Thread.currentThread().getName() 
				+ ": es.submit(callableTask) 호출로 future를 얻은 직후 " + LocalTime.now());
		String result = future.get(); // task가 끝날 때까지 기다린다. (리턴하지 않는다.)
		System.out.println(Thread.currentThread().getName() 
				+ ": future.get()으로 result를 얻은 직후 " + LocalTime.now());
		System.out.println(result);

		// 진행 중인 작업을 취소한다.
		boolean canceled = future.cancel(true); // task가 이미 끝났으므로 cancel 결과는 false.
		System.out.println("Task 취소에 성공했나? " + canceled);
		System.out.println();
		
		// 여러 Callable들을 한꺼번에 제출한다.
		List<Callable<String>> callableTasks = new ArrayList<>();
		callableTasks.add(callableTask);
		callableTasks.add(callableTask);
		callableTasks.add(callableTask);

		System.out.println(Thread.currentThread().getName() 
				+ ": es.invokeAll(callableTasks) 호출 전 " + LocalTime.now());
		List<Future<String>> futures = es.invokeAll(callableTasks);
		System.out.println(Thread.currentThread().getName() 
				+ ": es.invokeAll(callableTasks) 호출 후 " + LocalTime.now());
		// invokeAll은 모든 Callable task들이 끝날 때까지 리턴하지 않는다.
		for (Future<String> ft : futures)
			System.out.println(ft.get()); // 각 Future에는 각 Callable의 반환값이 들어 있다.
		System.out.println();

		es.shutdown(); // shutdown을 호출하지 않으면, task가 없어도 스레드풀이 한 동안 살아있다.
		               // --> 애플리케이션이 종료되지 않는다. (콘솔창에 빨간 불).
	}
}


