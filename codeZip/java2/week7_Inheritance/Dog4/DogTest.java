package java2.week7_Inheritance.Dog4;

import java.util.*;
// 문제로 제시되는 초기 코드

public class DogTest {
	public static void main(String[] args) {

		// Jindo도 Yorkie도 모두 Dog이다.
		Set<Dog> dogs = new HashSet<>();

		dogs.add(new Jindo("Jindori", "black"));
		dogs.add(new Jindo("Baku", "white"));
		dogs.add(new Jindo("Smart", "white"));
		dogs.add(new Jindo("Smart", "white"));


		for(Dog d: dogs){
			System.out.print(d + ": ");
			d.speak();
		}
	}
}