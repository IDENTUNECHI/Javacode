package java2.week9_Lamda;
import java.util.*;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("0.0 이상 소수 입력: ");
        double a = sc.nextDouble();

        Function<Double, Double> sqrt = result -> (double)Math.sqrt(result);
        Function<Double, Long> sqrt2 = sqrt.andThen(result -> (long) Math.round(result));

        System.out.print(sqrt2.apply(a));
    }
}
