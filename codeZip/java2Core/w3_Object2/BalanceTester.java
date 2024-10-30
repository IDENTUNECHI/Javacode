package java2Core.w3_Object2;

import java2.week3.Counter;

/**
 * 문자열의 괄호 열림, 괄호 닫힘 짝이 맞는지 여부를 검사하는 도구
 * <p>
 * "1+(2+3))(" 은 괄호 짝이 맞지 않는 문자열
 */
public class BalanceTester {
    String str;
    Counter counter;

    /**
     * 생성자.
     *
     * @param s 검사할 문자열
     */
    public BalanceTester(String s) {
        // str과 counter를 초기화 해준다.
        this.str = s;
        counter = new Counter();

    }

    /**
     * str의 괄호 짝이 맞는지 검사한다.
     * </>
     * str.equals("(")와 str.equals(")")를 사용한 부분은
     * 문자열 전체와 비교하는 것이 아니라,
     * 특정문자를 비교해야 하므로
     * str.charAt(i)로 개별 문자를 확인해야 합니다.
     *
     * @return true, 짝이 맞는 경우
     *         false, 짝이 맞지 않는 경우
     */
    public boolean balanced() {
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                counter.countUp();
            }

            else if(str.charAt(i) == ')'){
                counter.countDown();

            }
            if(counter.getValue() < 0){
                return false;
            }
        }
        int count = counter.getValue();
        counter.reset();

        if(count == 0){
            return true;
        }
        else
            return false;

    }
}
