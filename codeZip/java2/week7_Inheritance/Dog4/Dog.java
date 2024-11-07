package java2.week7_Inheritance.Dog4;

import java.util.Objects;

public abstract class Dog {

	@Override
	public String toString() {
		return "Dog [" + "name=" + name+ ']';
	}

	protected String name;

	// 이 클래스는 이미 생성자를 갖고 있으므로
	// (파라미터 없는) 기본생성자가 컴파일러에 의해 자동으로 삽입되지 않는다.
	
	public Dog(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void speak() {
		System.out.println("Mung mung!");
	}
	public abstract int getAverageWeight();

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Dog dog = (Dog) o;
		return Objects.equals(name, dog.name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0: name.hashCode());
		return result;
	}
}