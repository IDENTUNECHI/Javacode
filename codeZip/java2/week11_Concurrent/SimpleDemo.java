package java2.week11_Concurrent;

import java.util.concurrent.CompletableFuture;

/**
 * 비동기 연산 (Asnchronous computation)
 *
 * 비동기식으로 일을 처리하는 방법을 설명한다.
 * 비동기식이란 main 스레도에서 하는 일과 
 * 별도의 쓰레드에서 하는 일이 
 * 시간적으로 서로 연관 없이 진행된다는 말이다.
 * 
 * @author jck
 *
 */
public class SimpleDemo {

	public static void main(String[] args) throws Exception {

		// main 쓰레드
		System.out.println("시작: " + Thread.currentThread().getName());

		// "리턴타입이 없는 일"(Action이라고 부른다.)을 비동기 방식으로 시키고 싶은 경우, 
		// CompletableFuture 클래스의 static 메소드 runAsynch를 호출하면서 일거리(Runnable 태스크)를 넘겨준다.
		CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
			System.out.println("Runnable: " + Thread.currentThread().getName());
		}); // runAsynch 호출은 CompletableFuture를 즉시 리턴하고
	        // 람다식(Rannable 태스크)은 시스템이 알아서 준비하는 ForkJoinPool 속에 있는 스레드에 의해 실행된다.
		    // ForkJoinPool은 ExecutorService 인터페이스를 구현한 클래스이다.
            // Runnable task가 끝나면 CompletableFuture이 완료됐다(completed)고 말한다.
		
		// Runnable task가 별도의 쓰레드에서 실행되고 있다. 
		// 현재 진행 상황을 검사해 본다.
		// CompletableFuture이 완료됐는지(completed) 검사한다.
		System.out.println("future1 완료? " + future1.isDone());  

		// 리턴타입이 있는 일을 비동기 방식으로 시키고 싶은 경우, 
		// CompletableFuture 클래스의 static 메소드 supplyAsynch를 호출하면서 일거리(Supplier 태스크)를 넘겨준다.
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
			System.out.println("Supplier: " + Thread.currentThread().getName());
			return "hi";
		});  // supplyAsynch 호출은 CompletableFuture를 즉시 리턴하고
		     // 람다식(Supplier 태스크)은 시스템이 알아서 준비하는 ForkJoinPool 속에 있는 스레드에 의해 실행된다.
             // Supplier task가 끝나면 CompletableFuture이 완료됐다(completed)고 말한다.
		     // Supplier task 실행에 시간이 많이 걸리는 경우, 
		     // 리턴된 CompletableFuture에는 아직 계산 결과가 들어 있지 않다.
		     // (CompletableFuture is not completed yet.)
		     // 태스크가 끝나면 그 때 비로소 CompletableFuture에 값이 적힌다.
             // (CompletableFuture is completed.)
		
		String returnValue = future2.get(); 
		// Supplier 태스크가 끝날 때가지 (future2이 complete 될 때까지) get이 리런하지 않는다(blocked).
		
		// 결과가 나오면 테스크가 반환한 값을 후처라하여 출력한다.
		System.out.println("결과를 후처리하여 출력: " + returnValue.toUpperCase());   
		System.out.println();
		
		// 위 작업은 댜른 쓰레드가 일을 하는 동안 
		// main 쓰레드가 그 일이 끝나기를 기다리지 않고, 나름대로의 일을 할 수 있다는 점에서는 비동기적이다.
		// 그러나 다른 쓰레드가 수행한 일의 결과를 받아 그 결과를 이용하려면 그 일이 끝나기를 기다려야 하므로
		// 완전한 비동기식 작업이라고 말할 수 없는 측면이 있다.
		
		
		// ------------------------------------------------------------------------------

		// 비동기 방식으로 "결과를 산출하는 일"을 시킨다.
		CompletableFuture.supplyAsync(
				// 시간이 많이 거리는 어려운 작업(!)을 거쳐 얻은 결과값을 반환하는 Supplier task
				() -> {
						System.out.println("어려운 작업 Supplier task: " + Thread.currentThread().getName()); 
						for(long i=0;i<1_000_000_000_000L;i++); 
						return "hi";  
					  })	
 		       // Task가 시간이 많이 결려도 CompletableFuture<String> 자체는 즉시 반환된다. 

		// 위에서 호출한 CompletableFuture 클래스의 static 메소드 suppyAsynch는 
		// CompletableFuture을 반환하므로 
		// 반환된 CompletableFuture에게 CompletableFuture의 instance 메소드인 thenAccept를 호출할 수 있다.
		// (Chaining)
		.thenApply(x -> { // thenApply 메소드의 파라미터는 function 타입이다(mapping).
			System.out.println("후처리 작업 Function task: " + Thread.currentThread().getName());
			return x.toUpperCase(); // 위에서 얻은 계산 결과를 후처리한다.
			// 첫 stage가 complete된 (Supplier task가 끝난) 후에 이 stage의 mapping task가 실행된다. 
		})	// Mapping task 실행과 관계 없이 CompletableFuture<String>이 즉시 반환된다.
		// 반환된 Completable Future에게 thenAccept 메소드를 호출한다.
		.thenAccept(x -> { // consuming
			System.out.println("최종 결과 출력 Consumer task: " + Thread.currentThread().getName());
			System.out.println(x); 
		})	// CompletableFuture<Void>가 반환된다.
		.thenRun(() -> {
			System.out.println("추가 작업 1: " + Thread.currentThread().getName());
		})	// CompletableFuture<Void>가 반환된다.
		.thenRun(() -> {
			System.out.println("추가 작업 2: " + Thread.currentThread().getName());
			System.out.println("모든 비동기 작업 완료"); 
		});	// CompletableFuture<Void>가 반환된다. 사용하지 않음.

		System.out.println("main 작업 1: " + Thread.currentThread().getName());
		System.out.println("main 작업 2: " + Thread.currentThread().getName());
		System.out.println("main 작업 끝: " + Thread.currentThread().getName());
		
		// 비동기 방식으로 실행되는 "결과를 산출하는 일"에 시간이 많이 걸리므로, 
		// 72번 줄에서 "hi"가 리턴되기 전에, main 쓰레드는 "자기 일"을 할 수 있다.
		// main의 "자기 일"이란 80번줄-96번줄에 있는 "CompleableFuture chain을 엮는 일"과
		// 마지막 98-100번 줄들이다.
		
		// Chain을 엮는다는 말은 CompletableFuture에게 thenApply 메소드를 호출하여 새로운 CompletableFuture를 만들고,
		// 그 CompletableFuture에게 theAccept를 호출하여 새 CompletableFuture을 만들고,
		// 그 CompletableFuture에게 theRun을 호출하여 새 CompletableFuture을 만드는 작업을 말한다.
		// 이렇게 chain을 엮는 작업은 기다림 (blocking) 없이 즉시 실행된다.

		// 이렇게 만들어진 CompletableFuture 속에 들어 있는 작업들(람다식들)은 시스템이 알아서 준비하는 
		// ForkJoinPool 속에 있는 스레드에 의해 실행된다.
		// 만약, CompletableFuture 속에 들어 있는 작업들(람다식들)이 실행되어야 할 시간에
		// main 쓰레드가 할 일이 없어 놀고 있다면,
		// 작업들(람다식들)이 (ForkJoinPool 속에 있는 스레드 대신) main 쓰레드에게 할당될 수도 있다.
		
		// CompletableFuture을 이용하면 어떤 태스크를 다른 쓰레드가 처리하게 할 수 있으며
		// 태스크가 끝나면, 다른 쓰레드가 그 결과를 이용하여 다른 작업을 하도록 설정할 수 있다.  
		
		// 위 작업 방식은 댜른 쓰레드가 일을 하는 동안 
		// main 쓰레드가 그 일이 끝나기를 기다리지 않고, 나름대로의 일을 할 수 있을 뿐 아니라,
		// 다른 쓰레드가 수행한 일의 결과를 받아 그 결과를 이용하는 작업 자체도 
		// 다른 쓰레드에게 맡겨 놓고 자기는 자기 일만 하면 되므로
		// 완전한 비동기식 작업이라고 말할 수 있다.

	}

}
