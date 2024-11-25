package java2.week9_Lamda;

import java.util.function.Function;

public class FunctionDemo {
	public static void main(String args[]) {
		
		// Fuctional interface인 Function<T, R>은 apply(T) 메소드를 갖는 놈이다.
		// Function.apply(T)는 T를 받아 무언가 일을 하고 R을 반환한다.
		// Function 인터페이스의 apply 메소드에는 무슨일을 하는지 정해져 있지 않다. (메소드가 구현되어 있지 않다.)

		// Function 타입 랍다식에게 직접 apply를 호출하는 예.
		// Function 타입 람다식 선언 (람다식 선언에서 무슨일을 할지 정해준다.)
        Function<Integer, Double> half = a -> a / 2.0;	// Integer를 받아 Double을 만들어 주는 놈.
        System.out.println(half.apply(3));	// Integer 3에 half를 적용하면 Double이 만들어진다.

		// Function의 default 메소드인 andThen을 사용하여 복합 (Composite) Function을 만들고 이용하는 예.
        Function<Integer, Double> threeHalves = half.andThen(a -> 3.0 * a);
        // 3에 half를 먼저 적용하여 결과를 얻고 그 결과에 "a -> 3 * a"을 적용하여 최종 결과를 낸다.
        // (Integer -> Double, Double -> Double) = Integer -> Double
		System.out.println(threeHalves.apply(3));  

		// Function의 default 메소드인 compose을 사용하여 복합 (Composite) Function을 만들고 이용하는 예.
		Function<Integer, Double> halfOfSquare = half.compose(x -> x*x);
        // 3에 "x -> x*x"를 적용하여 결과를 얻고 그 결과에 half를 적용하여 최종 결과를 낸다.
        // (Integer -> Integer, Integer -> Double) = Integer -> Double
		System.out.println(halfOfSquare.apply(4));
		
		System.out.println();
		
        // 인터페이스 자체는 형식만 지정해 준다.
        // 인터페이스가 어떤 일을 하는지는 인터페이스를 어떻게 구현하느냐에 따라 달라진다.
        // 인터페이스를 구현한다는 말은 그 인터페이스를 구현하는 클래스를 작성하거나 람다식을 작성하는 것을 의미한다.
		
	}
	
}

