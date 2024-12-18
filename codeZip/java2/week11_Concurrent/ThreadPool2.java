package java2.week11_Concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// 배열에 들어 있는 정수들의 합을 구한다.
// 배열을 여러 조각으로 나누고 각 조각의 합을 쓰레드풀의 쓰레드를 이용하여 병렬로 계산한다.

public class ThreadPool2 {

	int CHUNK_SIZE = 102_400_000;		// 각 조각의 크기
	int N_CHUNKS = 8;			// 조각 갯수
	int N = CHUNK_SIZE * N_CHUNKS;	// 정수 갯수
	int[] arr = new int[N];

	// 자신에게 할당된 배열 조각에 있는 정수의 합을 계산해 반환하는 Callable.
	// 클래스 안에 내부 클래스를 선언할 수 있다.
	// 이 클래스는 Callable을 구현하므로 이 클래스 객체는 Callable이다.
	class Task implements Callable<Integer> {
		int chunk_number;	// 배열 조각 번호 (0, 1, 2, ... , N_CHUNKS-1)

		public Task(int chunk) {
			this.chunk_number = chunk;
		}
		@Override
		public Integer call() throws Exception {
			System.out.println(Thread.currentThread().getName());
			// 배열의 한 조각을 더한다. 배열을 물리적으로 조각으로 나누는 것은 아니다.
			int sum = 0;
			for (int i = chunk_number*CHUNK_SIZE; i < (chunk_number+1)*CHUNK_SIZE; i++) 
					sum += arr[i];
//			int sum = Arrays.stream(arr, chunk_number*CHUNK_SIZE, 
//			(chunk_number+1)*CHUNK_SIZE).sum(); // (array, from, to)
			return Integer.valueOf(sum); // int를 Integer로 변환
		}
	}

	private void process() throws InterruptedException, ExecutionException {

		Arrays.fill(arr, 1);	// 배열을 정수(1)로 채운다.

		// Callable의 리스트.
		List<Callable<Integer>> callableTasks = new ArrayList<>();
		for (int j = 0; j < N_CHUNKS; j++) {
			callableTasks.add(new Task(j));  // 각 조각을 계산하는 태스크들
		}

		// 스레드풀의 각 스레드에서 각 배열 조각의 합을 계산한다.
		ExecutorService es = Executors.newCachedThreadPool();
		List<Future<Integer>> futures = es.invokeAll(callableTasks); 
		// 계산이 끝날 때까지 이곳에서 멈춘다.
		
		// 계산이 모두 끝나 invokeAll 메소드가 결과를 반환하면 각 계산 결과들을 합친다.
		int sum = 0;
		for (Future<Integer> future : futures)
			sum += future.get();
		System.out.println(sum);
		es.shutdown();
	}

	public static void main(String[] args) 
			throws InterruptedException, ExecutionException {

		// 쓰레드풀을 이용한 병렬 계산
		long start = System.currentTimeMillis();
		ThreadPool2 p = new ThreadPool2();
		p.process();
		long stop = System.currentTimeMillis();
		System.out.println("쓰레드풀을 이용한 병렬 계산 시간=" + (stop - start) + "ms");
		
		// 스트림을 이용한 병렬계산
		start = System.currentTimeMillis();
		System.out.println(Arrays.stream(p.arr).parallel().sum());
		stop = System.currentTimeMillis();
		System.out.println("스트림을 이용한 병렬 계산 시간=" + (stop - start) + "ms");
		
		// 단순반복을 이용한 직렬계산
		start = System.currentTimeMillis();
		int sum = 0;
		for (int i = 0; i < p.N; i++) 
			sum += p.arr[i];
		stop = System.currentTimeMillis();
		System.out.println(sum);
		System.out.println("단순반복을 이용한 직렬 계산 시간=" + (stop - start) + "ms");

	}
}
