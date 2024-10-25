package java2.week6_Exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exception4 {

	public static void main(String[] args) throws FileNotFoundException {
		readFileTest();
	}

	static void readFileTest() throws FileNotFoundException {
		String fileName = "data.txt";
		readFile(fileName);
	}

	// 주어진 이름의 파일을 읽어 화면에 출력한다.
	static void readFile(String fileName) throws FileNotFoundException {
		// Scanner 구성자는 FileNotFoundException을 던지는 수가 있음!
		// FileNotFoundException은 checked exception임.
		Scanner in = new Scanner(new File(fileName));
		while (in.hasNextLine()) {
			System.out.println(in.nextLine());
		}
		in.close();
	}
}

