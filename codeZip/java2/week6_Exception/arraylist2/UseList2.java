package java2.week6_Exception.arraylist2;

public class UseList2 {
    public static void main(String[] args) {


        ArrayIntList list = new ArrayIntList();
        list = new ArrayIntList();
        for (int i = 0; i < 10; i++)
            list.add(0, i);
        System.out.println(list.toString());
        list.add(1, 22);
        System.out.println(list.toString());
        list.add(22);
        System.out.println(list.toString());
        list.add(12, 100);
        System.out.println(list.toString());
    }
}
