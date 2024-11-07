package java2.week7_Inheritance.Dog3;
import java.util.*;
// 문제로 제시되는 초기 코드

public class DogTest {
	public static void main(String[] args) {

		// Jindo도 Yorkie도 모두 Dog이다.
		List<Dog> dogs = new ArrayList<>();

		dogs.add(new Jindo("Jindori", "black"));
		dogs.add(new Jindo("Baku", "white"));
		dogs.add(new Yorkie("Yomi"));
		dogs.add(new Yorkie("Yepi"));

		for(Dog d: dogs){
			System.out.print(d + ": ");
			d.speak();
		}
	}
}