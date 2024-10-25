package java2.week6_Exception;

import java.util.Arrays;

public class Exception1 {

	static int[] a;
	
	public static void main(String[] args) {
		
		makeArrayAndTest(1, 4);	// 1번 방에 4를 저장.
		System.out.println(Arrays.toString(a));

		makeArrayAndTest(10, 4);	// 10번 방에 4를 저장.
		System.out.println(Arrays.toString(a));
		
	}

	static void makeArrayAndTest(int index, int value) {
		a = new int[10];
		test(index, value);
	}

	static void test(int index, int value) {
		set(index, value);	
	}

	// index가 올바른 범위에 있으면 a[index]에 value를 저장한다.
	// 그렇지 않으면 값을 저장하지 않고 IndexOutOfBoundsException을 던진다.
	static void set(int index, int value) {
		if (index < 0 || index >= a.length)
			throw new IndexOutOfBoundsException();
		a[index] = value;
	}

}

