package java2.week7_Inheritance.Dog4;

import java.util.Objects;

public class Jindo extends Dog {
	
	private String color; // 검정, 하양, 갈색
	private static int averageWeight = 45;

	// 생성자 첫 문장이 super나 this가 아닌 경우, 
	// 생성자 첫 문장으로 super()가 자동으로 삽입되는데
	// super()는 수퍼클래스의 파라미터 없는 생성자를 호출하는 것이다.
	// 그런데 수퍼클래스인 Dog에는 파라미터 없는 생성자가 없으므로 컴파일 에러!
	// 생성자 첫 문장으로 super(name)를 넣어주면 해결된다.
	// String 파라미터를 갖는 Dog의 생성자를 호출하는 것이다.
	// 그렇게 하면, Dog의 생성자가 지금 생성되는 Jindo 객체의 name 필드를 초기화해 준다.
	// color 필드는 이 생셩자에서 초기화해 준다.
	public Jindo(String name, String color) {
		super(name);
		this.color = color;
	}

	@Override
	public String toString() {
		return String.format("Jindo [color=%s, name=%s]", color, name);
	}

	// 상속한 메소드를 재징의한다.
	@Override
	public void speak() {
		System.out.println("Jin jin!");
	}

	// 이 클래스에서 새로 만드는 메소드
	public int getAverageWeight() {
		return averageWeight;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!super.equals(obj) || getClass() != obj.getClass()) return false;

		Jindo other = (Jindo) obj;
		if(color == null) {
			if(other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(color);
		return result;
	}
}