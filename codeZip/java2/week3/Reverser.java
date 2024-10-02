package java2.week3;

/**
 * 문자열을 구성하는 글자들의 순서를 바꾼 새 문자열을 만들어준다.
 */

public class Reverser {
    /**
     * 생성자
     */
    private String s;
    public Reverser(String s) {
        this.s = s;
    }
    /**
     * 문자열을 구성하는 글자들의 순서를 바꾼 새 문자열을 만들어준다.
     * @return 순서가 바뀐 새 문자열
     */
    public String reverse() {
        String reverse = "";
        String [] str = s.split(""); //글자 단위로 문자열을 쪼갠 뒤 List에 저장
        for(int i= 0; i< str.length; i++){
            reverse = str[i] + reverse;
        }
        return reverse;
    }

    /**
     * 문자열을 구성하는 글자들의 순서를 단어 단위로 바꾼 새 문자열을 만들어준다.
     * @return 단어 단위로 순서가 바뀐 새 문자열
     */
    public String reverseWords() {

        String reversewords = "";
        String [] str = s.split(" ");
        for(int i= 0; i< str.length; i++){
            reversewords = str[i] + " " + reversewords ;
        }
        return reversewords;

    }
}
