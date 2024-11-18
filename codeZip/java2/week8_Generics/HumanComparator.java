package java2.week8_Generics;

import java.util.Comparator;

public class HumanComparator implements Comparator<Human> {
    public int compare(Human o1, Human o2) {

        int nameCompare = o1.name.compareTo(o2.name);
        if (nameCompare != 0) {
            return -1;
        }

        else {
            if(o1.age != o2.age){
                return -1;
            }
            else {
                return 0;
            }
        }
    }
}
