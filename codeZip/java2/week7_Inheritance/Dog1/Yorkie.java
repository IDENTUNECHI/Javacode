package java2.week7_Inheritance.Dog1;

public class Yorkie extends Dog {
	public String toString() {
		return String.format("Yorkie [name=%s]", name);
	}
	public Yorkie(String name) {
		super(name);
	}
	public void speak(){
		System.out.println("yo yo!");
	}
}