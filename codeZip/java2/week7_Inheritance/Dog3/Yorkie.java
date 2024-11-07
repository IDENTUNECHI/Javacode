package java2.week7_Inheritance.Dog3;

public class Yorkie extends Dog {
	private static int averageWeight = 4;

	public String toString() {
		return String.format("Yorkie [name=%s]", name);
	}
	public Yorkie(String name) {
		super(name);
	}
	public void speak(){
		System.out.println("yo yo!");
	}
	public int getAverageWeight(){
		return averageWeight;
	}
}