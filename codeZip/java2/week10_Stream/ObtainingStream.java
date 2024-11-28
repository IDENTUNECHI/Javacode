package java2.week10_Stream;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ObtainingStream {
	public static void main(String[] args)  {

		// 배열로부터 스트림을 얻는다.
		String[] sa = new String[] { "A", "B", "C" };
		Stream<String> words = Arrays.stream(sa);
		words.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		// 10, 11, 12, ..., 19 sequential ordered IntStream을 얻는다.
		IntStream ints = IntStream.range(10, 20);
		ints.forEach(s -> System.out.print(s + " "));
		System.out.println();

		Stream<String> seasons = Stream.of("하지", "동지", "춘분", "추분", "입동");
		seasons.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		Stream<String> silence = Stream.empty(); 	// 빈 스트림	
		silence.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		// 필요할 때마다 "야옹"을 만든다. 무한히 긴 스트림이다.
		Stream<String> yaongs = Stream.generate(() -> "야옹");
		yaongs.limit(10).forEach(s -> System.out.print(s + " "));
		System.out.println();

		// 필요할 때마다 double 난수를 만든다. 무한히 긴 스트림이다.
		Stream<Double> randoms = Stream.generate(Math::random);
		randoms.limit(4).forEach(s -> System.out.print(s + " "));
		System.out.println();
		
 		//java.util.stream.Stream 인터페이스
		// static <T> Stream<T> iterate​(T seed, UnaryOperator<T> f)
		// 무한 스트림: seed, f(seed), f(f(seed)), ...  
		Stream<Integer> integers = Stream.iterate(0, n -> n + 1);	 
			                      // 0, 0+1, (0+1)+1, ((0+1)+1)+1, ...
		integers.limit(4).forEach(s -> System.out.print(s + " "));
		System.out.println();

		// 0부터 10,000,000 미만 유한 스트림
		long limit = 10000000L;
		Stream<Long> longIntegers = Stream.iterate(
				0L, 
				n -> n.compareTo(limit) < 0,
				n -> n + 1);
		longIntegers.skip(limit - 4).forEach(s -> System.out.print(s + " "));

		// 무한 스트림
		Stream<BigInteger> bIntegers = Stream.iterate(
				BigInteger.ZERO, 
				n -> n.add(BigInteger.ONE));
		bIntegers.limit(4).forEach(s -> System.out.print(s + " "));
		System.out.println();
	}
}
