package java2.week2;

public class Human {
    /**
     * 인간을 나타내는 간단한 클래스
     * @ author 김이든
     */
    private String name;
    private int age;

    /**
     * 이름을 얻는다.
     * @return 이름
     */
    public String getName(){
        return name;
    }

    /**
     * 이름을 설정한다.
     * @param n 이름
     */

    public void setName(String n) {
        name = n;
    }

    /**
     * 나이를 얻는다.
     * @return 나이
     */

    public int getAge() {
        return age;
    }

    /**
     * 나이를 설정한다.
     * @param i 나이
     */

    public  void setAge(int i) {
        this.age = i;
    }

    @Override
    public String toString() {
        return "Human [name=" + name +", age="+ age +"]";
    }

    public static void main(String[] args){
        Human human1 = new Human(); // 생성자 생성
        Human human2 = new Human();

        human1.setName("하나");
        human1.setAge(19);

        human2.setName("강철");
        human2.setAge(20);

        System.out.println(human1);
        System.out.println(human2);
    }
}
