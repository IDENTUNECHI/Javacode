package java2.week2;

public class NameCat {
    private String name; // 메모리

    public static void main(String[] args) {

        NameCat c1, c2;

        c1 = new NameCat();
        c2 = new NameCat();

        c1.setName("코코");
        c2.setName("모모");

        System.out.println(c1.getName());
        System.out.println(c2.getName());

    }

    public void eat() {
        System.out.println("냠냠!");
    }
    public void yaong() {
        System.out.println("야옹");
    }

    /**
     * 이름을 설정한다.
     * @param n
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * 이름을 반환한다.
     * @return
     */
    public String getName() {
        return name;
    }

}
