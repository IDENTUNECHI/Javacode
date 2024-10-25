package java2.week6_Exception;

import java.util.Arrays;

public class Exception {

	static int[] a; // 필드, 전역변수로 사용된다!
	
	public static void main(String[] args) {
		
		int error_code;
		
		error_code= makeArrayAndTest(1, 4);	// 1번 방에 4를 저장.
		if (error_code == 0)
			System.out.println(Arrays.toString(a));
		else
			System.out.println("Error! error code = " + error_code);

		error_code = makeArrayAndTest(10, 4);	// 10번 방에 4를 저장.
		if (error_code == 0)
			System.out.println(Arrays.toString(a));
		else
			System.out.println("Error! error code = " + error_code);
		
	}

	// 크기 10인 정수 배열을 만들어 a가 배열을 가리키게 하고, test 함수를 호출한다.
	static int makeArrayAndTest(int index, int value) {
		a = new int[10];
		return(test(index, value));
	}

	// 특별히 하는 일 없이 set 함수를 호출한다.
	// (여러 단계 함수 호출을 보이기 위한 것임.)
	static int test(int index, int value) {
		return set(index, value);	
	}

	// index가 올바른 범위에 있으면 a[index]에 value를 저장하고 0을 반환한다.
	// 그렇지 않으면 값을 저장하지 않고 -1을 반환한다.
	static int set(int index, int value) {
		if (index < 0 || index >= a.length) {
			return -1;	// 인덱스가 범위를 벗어암.
		} 
		else {
			a[index] = value;
			return 0;
		}
	}
}

