package OldRepository.java1.one_array;

import java.util.Scanner;
/**
 * 키보드로부터 10개의 정수를 차례로 읽어 배열에 저장한 후 나중 것부터 처음 것까 
 * 지 차례로 출력.
 * @author 김이든
 */
public class Reverse {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        int[] a;
        a = new int[10];

        System.out.print("정수 10개: ");

        for (int i=0; i<a.length; i++)
        // 입력된 값들을 a[0],...,a[9]에 차례로 저장
            a[i] = input.nextInt();

        for (int i = a.length-1; i >= 0; i--) 
        // a[9]..a[8].. 저장된 값들을 차례로 출력
            System.out.print(a[i] + " ");
    }
}