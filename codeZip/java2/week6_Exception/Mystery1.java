package java2.week6_Exception;

import java.util.*;

/**
 * 리스트에서 한 원소를 삭제하면 
 * 삭제된 원소의 오른쪽에 있던 원소들이 
 * 왼쪽으로 한 칸씩 이동한다.
 *
 * 그래서 요소가 하나씩 밀리게 되어 2칸씩 넘겨서 요소가 remove()된다.
 *
 * 따라서 모든 요소가 삭제되는 것이 아니라 10 30 50 이렇게 띄엄띄엄 삭제된다.
 */

public class Mystery1 {
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			list.add(10 * i);   // [10, 20, 30, 40, ..., 100]
		}

		for (int i = 0; i < list.size(); i++) {
			list.remove(i);
		}
		System.out.println(list);
	}
}

