package java2.week7_Inheritance.Dog1;

// 문제로 제시되는 초기 코드

public class DogTest {
	public static void main(String[] args) {
		
		Dog dog = new Dog("Mung");
		System.out.println(dog); //문장에 의한 출력은 Object 클래스로부터
		// 상속한 toString() 메소드가 작동한 결과
		System.out.println(dog.getName());
		dog.speak();
		
		dog = new Jindo("Jindol", "black");
		Jindo jindo = (Jindo) dog;
		System.out.println(dog);
		System.out.println(dog.getName());
		dog.speak();
		System.out.println("진돗개의 평균 무게: "+ jindo.getAverageWeight());

		dog = new Yorkie("Yomie");
		System.out.println(dog);
		System.out.println(dog.getName());
		dog.speak();
		
	}
}