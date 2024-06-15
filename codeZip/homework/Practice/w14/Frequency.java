package homework.Practice.w14;

import java.util.*;

/**
 * StringBuilder와 append를 사용해 단어들을 접합
 * @author 김이든
 */

public class Frequency{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str = input.next();
        System.out.println(getMostFreqChar(str));
    }

    /**
     * 주어진 단어에서 가장 많이 출현하는 글자를 찾는다.
     * @param str 주어진 단어.
     *	@return str에서 가장 많이 출현하는 글자
     * @author 김이든
     */

    static char getMostFreqChar(String str){
    int [] counter = new int[256];

    for(int i=0; i<str.length(); i++){
        counter[str.charAt(i)]++;
    }

    int max = 0;
    int n = 0;
    for(int i = 0; i< counter.length; i++){
        if(counter[i] > max){
            max = counter[i];
            n = i;
        }
    }
    return (char)n;
    }
}
