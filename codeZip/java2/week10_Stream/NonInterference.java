package java2.week10_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class NonInterference {

	public static void main(String[] args) {

		// Interference
		// 스트림파이프라인 연산이 진행되는 동안 스트림 소스를 변경하면 안된다.
		List<String> list = new ArrayList<>(Arrays.asList("one", "two"));
		try {
			String concatenatedString = list.stream()
					.peek(s -> list.add("three"))
					.reduce((a, b) -> a + " " + b).get();
			System.out.println("Concatenated string: " + concatenatedString);
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
		}

		// 터미널연산이 시작될 때까지는 파이프라인 연산이 수행되지 않으므로 (lazy operation)
		// 터미널연산이 시작되기 전에는 소스를 변경할 수 있다.
		List<String> list2 = new ArrayList<>(Arrays.asList("one", "two"));
		Stream<String> stream = list2.stream().map(String::toUpperCase);
		list2.add("three");
		String result = stream.reduce((a, b) -> a + " " + b).get();
		System.out.println("Result: " + result);
		
	}

}
