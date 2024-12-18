package baekjun;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Stream<Integer> is = List.of(1,2, 3).stream();
        Stream<Integer> is2 = is.filter(x -> x>=2);
        Stream<Integer> is3 = is2.peek(System.out :: print);
        System.out.print("end");

    }
}