package java2.week10_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class Stateful {

	static void statefullLambda() {
		// 원소의 순서를 관리하지 않는 Collection
		Set<Integer> s = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		List<Integer> list = new ArrayList<>();
		int sum = s.parallelStream() // Unordered stream
				.mapToInt(e -> // list의 상태에 따라 실행 결과가 달라지는 stateful 람다식
					{
						if (list.size() <= 3) {
							list.add(e);
							return e;
						} else
							return 0;
					})
				.sum(); // 리스트에 넣은 정수 세개와 0 세개의 합
		System.out.print(sum + " ");
	}

	static void statefullLambda2() {
		// 여러 쓰레드들이 동시에 쓰기를 시도하더라도 데이터가 손상되지 않는 Collection
		Set<Integer> seen = Collections.synchronizedSet(new HashSet<>());
		IntStream stream = new Random().ints(10, 0, 10); // 0 이상 10 미만 정수 난수 10개
		int sum = stream.parallel()
				.map(e -> // seen.add 성공 여부에 따라 실행 결과가 달라지는 stateful 람다식
					{
						if (seen.add(e))  // add된 경우
							return 0;
						else
							return e;
					})
				.sum(); // 중복으로 인해 Set에 넣지 못한 정수들의 합
		System.out.print(sum + " ");
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++)
			statefullLambda(); // 실행할 때마다 결과가 다르다.
		System.out.println();
		for (int i = 0; i < 5; i++)
			statefullLambda2(); // 실행할 때마다 결과가 다르다.
	}
}

