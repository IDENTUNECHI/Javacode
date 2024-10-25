package java2.week6_Exception;

import java.util.Arrays;

public class Exception3 {

	static int[] a;
	
	public static void main(String[] args) {
		
		try {
			makeArrayAndTest(1, 4);	// 1번 방에 4를 저장.
			System.out.println(Arrays.toString(a));

			makeArrayAndTest(10, 4);	// 10번 방에 4를 저장.
			System.out.println(Arrays.toString(a));
		}
		catch(IndexOutOfBoundsException e) { // 잡힌 예외는 e에 있다.
			// 예외처리기						 // e는 예외를 가리키는 참조변수
			System.out.println("나이스 캐치~");
			System.out.println("인덱스가 틀려서 작업을 완료할 수 없습니다.");
			System.out.println(e.getMessage());
		}
		System.out.println("예외처리기 작동 후 프로그램 계속 실행");
	}

	
	static void makeArrayAndTest(int index, int value) {
		a = new int[10];
		test(index, value);
	}

	static void test(int index, int value) {
		set(index, value);	
	}

	// IndexOutOfBoundsException 객체를 만들 때 객체 안에 정보를 저장할 수 있다.
	static void set(int index, int value) {
		if (index < 0 || index >= a.length)
			throw new IndexOutOfBoundsException("인덱스=" + index);
		a[index] = value;
	}

}

