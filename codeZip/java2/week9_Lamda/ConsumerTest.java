package java2.week9_Lamda;

import java.util.*;
import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("문자열 여러 줄 입력 (입력을 마치려면 Control-Z 입력):");
        List<String> list = new ArrayList<>();
        String line = sc.next();

        list.add(line.charAt(0) + "");

        // Consumer 정의
        Consumer<String> consumerFirst = k -> System.out.println(k.charAt(0)); // 첫 번째 문자
        Consumer<String> consumerLast = k -> System.out.println(k.charAt(k.length() - 1)); // 마지막 문자
        Consumer<String> consumerFirstLast = k -> System.out.println(k.charAt(0)+""+k.charAt(k.length() - 1)); // 마지막 문자

        // Consumer 실행
        consumerFirst.accept(line);
        consumerLast.accept(line);
        consumerFirstLast.accept(line);

        // 한 줄씩 입력을 읽고, 각 줄의 첫 번째 및 마지막 문자 출력
        while (sc.hasNext()) {
            String line2 = sc.next();

            // 빈 줄 처리: 빈 줄이 들어오면 넘어감
            if (line.trim().isEmpty()) {
                break;
            }

            list.add(line2.charAt(0)+"");
        }

        for(String s : list) {
            System.out.print(s);
        }

        sc.close();
    }
}

