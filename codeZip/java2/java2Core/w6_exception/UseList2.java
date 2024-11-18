package java2.java2Core.w6_exception;

public class UseList2 {
    public static void main(String[] args) {

        ArrayIntList list = new ArrayIntList();

        for (int i = 0; i < 5; i++)
            list.add(0, i);

        System.out.println(list);

        try {
            list.get(list.size());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            list.set(list.size(), 100);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            list.remove(list.size());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            list.add(list.size(), 100);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(list);

        try {
            list.add(list.size()+1, 200);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
