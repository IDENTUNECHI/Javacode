package Java2Practice2.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 간단한 stream pipelines 사용 연습입니다.
 * 중간연산(intermediate operations)과 기초적인 collector를 다룹니다.
 *
 * 일부 문제에서 "reader"라는 이름의 BufferedReader 변수를 사용하는데
 * 이 변수를 선언하고 값을 설정하는 코드가 이 프로그램의 맨 끝 부분에 있습니다.
 * 이 코드는 JUnit 시스템에 의해 자동으로 실행됩니다.
 */

public class Streams {
    /**
     * Given a list of words, create an output list that contains
     * only the odd-length words, converted to upper case.
     */
    @Test 
    public void d1_upcaseOddLengthWords() {
        List<String> input = List.of(
            "alfa", "bravo", "charlie", "delta", "echo", "foxtrot");

        List<String> result = input.stream().filter(x -> x.length() % 2 == 1).map(String :: toUpperCase).toList();

        assertEquals(List.of("BRAVO", "CHARLIE", "DELTA", "FOXTROT"), result);
    }
    // Hint 1:
    // Use filter() and map().
    // Hint 2:
    // To create the result list, use collect() with one of the
    // predefined collectors on the Collectors class.


    /**
     * Take the third through fifth words of the list, extract the
     * second letter from each, and join them, separated by commas,
     * into a single string. 
     */
    @Test 
    public void d2_joinStreamRange() {
        List<String> input = List.of(
            "alfa", "bravo", "charlie", "delta", "echo", "foxtrot");
        String result = input.stream().skip(2).limit(3).map(x -> x.substring(1,2).concat(",")).collect(Collectors.joining());
        result = result.substring(0, result.length()-1);
        assertEquals("h,e,c", result);
    }
    // Hint 1:
    // Use Stream.skip() and Stream.limit().
    // Hint 2:
    // Use Collectors.joining().


    /**
     * Count the number of lines in the text file. 
     * 
     * "reader"라는 이름의 BufferedReader가 이미 열려 있으니
     * 이것을 사용하면 됩니다. 이 프로그램의 맨 아래를 보세요.)
     * 
     * @throws IOException
     */
    @Test 
    public void d3_countLinesInFile() throws IOException {
        
    	long count = reader.lines().count();

        assertEquals(14, count);
    }
    // Hint 1:
    // Use BufferedReader.lines() to get a stream of lines.
    // Hint 2:
    // Use Stream.count().


    /**
     * Find the length of the longest line in the text file.
     *
     * @throws IOException
     */
    @Test 
    public void d4_findLengthOfLongestLine() throws IOException {
        
    	int longestLength = reader.lines().mapToInt(String :: length).max().orElse(-1);

        assertEquals(53, longestLength);
    }
    // Hint 1:
    // Use Stream.mapToInt() to convert a stream of objects to an IntStream.
    // IntSream에서 최대값을 찾는 메소드는 max입니다.
    // max는 OptionalInt를 반환합니다.
    // Hint 2:
    // Look at java.util.OptionalInt to get the result.
    // Hint 3:
    // Think about the case where the OptionalInt might be empty
    // (that is, where it has no value). 이런 경우에는 -1을 반환하게 하세요.


    /**
     * Find the longest line in the text file.
     *
     * @throws IOException
     */
    @Test 
    public void d5_findLongestLine() throws IOException {
        String longest = reader.lines().max(Comparator.comparing(String :: length)).orElse("");

        assertEquals("Feed'st thy light's flame with self-substantial fuel,", longest);
    }
    // Hint 1:
    // Use Stream.max() with a Comparator.
	// Stream 클래스에도 max 메소드가 있습니다. 
	// Stream.max는 Comparator를 파라미터로 갖습니다.
	// api 문서에서 Stream.max를 찾아보세요.


    /**
     * Select the longest words from the input list. 
     * 가장 긴 단어들이 들어 있는 리스트를 구하세요.
     */
    @Test 
    public void d6_selectLongestWords() {
        List<String> input = List.of(
            "alfa", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotel");

        // 첫 번째 스트림: 가장 긴 단어의 길이를 구함
        int maxLength = input.stream().mapToInt(String :: length).max().orElse(-1);

        // 두 번째 스트림: maxLength에 해당하는 단어를 필터링
        List<String> result = input.stream().filter(x -> x.length() == maxLength).toList();
        assertEquals(List.of("charlie", "foxtrot"), result);
    }
    // Hint:
    // Consider making two passes over the input stream.
    // 두 문장으로 작성하는 편이 좋습니다.
    // 첫 문장에서는 가장 긴 단어(들)의 길이를 알아냅니다.
    // int maxLength를 선언하고 그 값을 저장해 둡니다.
    // 두 번째 문장에서는 maxLength 길이를 갖는 단어 리스트를 구합니다.

    /**
     * Select the list of words from the input list whose length is greater than
     * the word's position in the list (starting from zero) .
     */
    @Test 
    public void d7_selectByLengthAndPosition() {
        List<String> input = List.of(
            "alfa", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotel");

        List<String> result = input.stream().filter(x -> input.indexOf(x) < x.length()).toList();

        assertEquals(List.of("alfa", "bravo", "charlie", "delta", "foxtrot"), result);
    }
	// Hint:
	// Instead of a stream of words (Strings), run an IntStream of indexes of
	// the input list. Use index values to get elements from the input list.
	// 0번째 단어 길이가 0보다 큰가? 1번 단어 길이가 1보다 큰가? 2번 단어 길이가 2보다 큰가? 이런 식으로 풀면 됩니다.
	// 인덱스를 나타내는 IntStream(0, 1, 2, ..., size-1)을 가지고 작업합니다.
	// 아래 조건에 맞춰 정수들을 filtering
	//   0: 0번 단어 길이가 0보다 큰가?
	//   1: 1번 단어 길이가 1보다 큰가?
	//   2: 2번 단어 길이가 2보다 큰가?
	//   3: 3번 단어 길이가 3보다 큰가?
	//   ...
	// Filter을 통과한 각 정수에 대해 해당 단어를 mapping (가령 통과한 숫자가 2, 3이라면)
	//   2: 2번 단어
	//   3: 3번 단어
	// 단어들을 List에 Collect


// ========================================================
// END OF EXERCISES
// TEST INFRASTRUCTURE IS BELOW
// ========================================================


	private BufferedReader reader;

	@BeforeEach // 각 Test 메소드를 호출하기 전에 아래 메소드가 자동으로 실행된다.
	public void z_setUpBufferedReader() throws IOException {
		reader = Files.newBufferedReader(Paths.get("C:\\Users\\rladl\\IdeaProjects\\Javastudy\\codeZip\\Java2Practice2\\Stream\\sonnet.txt"), StandardCharsets.UTF_8);
	}

	@AfterEach // 각 Test 메소드를 호출한 후에 아래 메소드가 자동으로 호출된다.
	public void z_closeBufferedReader() throws IOException {
		reader.close();
	}

}