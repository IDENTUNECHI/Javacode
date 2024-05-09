package homework.one_array;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  파일로부터 데이터를 읽어 배열에 저장한다.
 * @author 김이든
 */
public class FileInput {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("data/integers.txt"));
        int[] numbers = new int[6];
				int i = 0;
        // 정수들을 읽어 number[0], number[1], number[2],... 에 차례로 저장
         while (input.hasNextInt()){ 
         // input에 읽을 정수가 있으면 true, 그렇지 않으면 false
            numbers[i++] = input.nextInt();
             // 사후증가연산자, 문장을 실행한 후 i를 1씩 더함
        }

        System.out.println("배열을 역순으로 출력: ");

        for(int j = numbers.length-1; j>=0; j--)
            System.out.print(numbers[j]+" ");

    }

    }