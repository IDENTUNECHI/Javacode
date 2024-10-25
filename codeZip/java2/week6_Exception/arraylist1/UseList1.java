package java2.week6_Exception.arraylist1;

public class UseList1 {
    public static void main(String[] args) {
        ArrayInList ail = new ArrayInList();
        //-----------------------------------------------//
        for(int i=0; i<10; i++)
            ail.add(0, i);
        System.out.println(ail.toStirng());

        //---------------------------------//

        ail.add(1,22);
        System.out.println(ail.toStirng());

        //-----------------------------------//

        ail.set(1, 19);
        System.out.println(ail.toStirng());

        //-------------------------------------//

        System.out.println(ail.size());

        //----------------------------------------//
        ail.remove(1);
        System.out.println(ail.toStirng());

        //---------------------------------------//
        System.out.println(ail.isEmpty());
        //--------------------------------------//



    }
}
