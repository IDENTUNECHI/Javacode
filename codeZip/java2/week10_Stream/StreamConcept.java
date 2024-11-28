package java2.week10_Stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamConcept {
	public static void main(String[] args) throws Exception {

		List<String> season = List.of("하지", "동지", "춘분", "추분", "입동");

		int sum = season.stream() // stream creation
				.filter(w -> w.charAt(w.length() - 1) == '지') // filter
				.mapToInt(w -> w.length()) // map (Integer 대신 int로  대응시킴)
				.sum(); // reduce
		System.out.println(sum); // 결과 4

		Random r = new Random();
		IntStream is = r.ints(10, 20);	// 10 이상 20 미만 (무한히 긴) 난수 스트림 생성
		is.limit(10).forEach(n -> System.out.print(n + " ")); //11 15 13 17 11 13 16 19 16 12
		System.out.println();

		String str = null;
		try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\rladl\\IdeaProjects\\Javastudy\\codeZip\\java2\\week10_Stream\\동백꽃.txt"))) {
			Stream<String> lines = br.lines();
			str = lines.limit(4).collect(Collectors.joining(" ")); 
				  // 네 줄을 " "으로 연결하여 하나의 String으로 만든다.
		} catch (IOException e) {
			System.err.format("IOException: %s\n", e);
		}
		System.out.println(str);

		// (여러 언어의) 알파벳(Letter)이 아닌 글자가 하나 이상 연속해서 나타나는 패턴을 나타내는 정규식
		Pattern pattern = Pattern.compile("\\P{L}+");   
		// 알파벳(Letter)이 아닌 글자들을 구분자로 삼아 str의 단어들을 분리하여 스트림을 만든다.
		// White space, 숫자, 구두점은 Letter이 아니다.
	    Stream<String> ss = pattern.splitAsStream(str);
		ss.forEach(s -> System.out.print(s + " "));
	}
}

//BufferedReader reader = Files.newBufferedReader(Paths.get("C:/경로/파일이름.txt"));
//Stream<String> stream = reader.lines();  // 각 line이 하나의 String인 String stream
//
//stream.close();



