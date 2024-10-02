package java2.week2;

public class NameCat2 {
    private String name; // 메모리
    private int age;

    public static void main(String[] args) {

        NameCat2 c1, c2, c3;

        c1 = new NameCat2();
        c2 = new NameCat2("Bella");
        c3 = new NameCat2("Kitty", 19);


        c1.setName("Cleo");
        c1.setAge(20);

        c2.setAge(21);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

    }

    /**
     * 구성자
     */
    public NameCat2() { }

    /**
     * 구성자
     * @param name
     */
    public NameCat2 (String name) {
        this.name = name;
    }

    /**
     * 구성자
     * @param name
     * @param age
     */

    public NameCat2 (String name, int age){
        this.name = name;
        this.age = age;
    }

    /**
     * 냠냠
     */

    public void eat() {
        System.out.println("Nom nom nom!");
    }

    /**
     * 야옹
     */
    public void yaong() {
        System.out.println("meow~");
    }

    /**
     * 이름을 설정한다
     * @param n
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * 이름을 반환한다.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 나이를 설정한다.
     * @param age
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * 나이를 반환한다.
     * @return age
     */

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "NameCat2 [name=" + name + ", age=" + age + "]";
    }
}
