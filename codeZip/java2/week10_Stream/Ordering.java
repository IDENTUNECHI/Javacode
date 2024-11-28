package java2.week10_Stream;

import java.util.Arrays;
import java.util.List;

public class Ordering {

	public static void main(String[] args) {
		
		// ForEach는 스트림 원소의 순서를 존중하지 않는다.
		// ForEachOrdered는 스트림 원소의 순서를 존중한다.
		
		// 원소의 순서를 관리하는 Collection
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		numbers.stream() // ordered serial stream
			.forEach(System.out::print);
		System.out.println();
		
		numbers.parallelStream() // ordered parallel stream
			.forEach(System.out::print);
		System.out.println();
		
		numbers.parallelStream() // ordered parallel stream
			.forEachOrdered(System.out::print);
		
	}
}
