package Java2Practice.Interface;

import java.util.Comparator;

public class DiagonalComparator implements Comparator<Rectangle4> {
    public int compare(Rectangle4 r1, Rectangle4 r2) {

        double r1dia = Math.sqrt((r1.getHeight()*r1.getHeight()) + (r1.getWidth()*r1.getWidth()));
        double r2dia = Math.sqrt((r2.getHeight()*r2.getHeight()) + (r2.getWidth()*r2.getWidth()));

        if(r1dia>r2dia)
            return 1;
        else if(r1dia<r2dia)
            return -1;
        else
            return 0;
    }


}
