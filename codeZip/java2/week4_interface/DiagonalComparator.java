package java2.week4_interface;
import java.util.Comparator;

public class DiagonalComparator implements Comparator<Rectangle4>{
    public int compare(Rectangle4 r1, Rectangle4 r2){

        double diagonal1 = (r1.getWidth() * r1.getWidth())
                            + (r1.getHeight() * r1.getHeight());

        double diagonal2 = (r2.getWidth() * r2.getWidth())
                + (r2.getHeight() * r2.getHeight());

        double result1 = Math.sqrt(diagonal1);
        double result2 = Math.sqrt(diagonal2);

        if (result1 > result2)
            return 1;
        else if (result1 < result2)
            return -1;
        else
            return 0;
    }
}
