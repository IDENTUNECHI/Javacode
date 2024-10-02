package java2.week3;

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
        str = s; //입력받은 s를 str 에 대입
        counter = new Counter(0);
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
        for(int i=0; i < str.length(); i++){
            if(str.charAt(i) == '('){ // 괄호 열림이면 countUp
                counter.countUp();
            }

            else if(str.charAt(i) == ')'){// 괄호 닫힘이면 countDown
                counter.countDown();
                if(counter.getValue() <0){ // ")(" 처럼 -1이 첫번째로 반환됐을 때, 바로 false 반환
                    return false;
                }
            }
        }

        int count = counter.getValue(); // read counter
        counter.reset(); // counter reset

        if(count == 0) //합이 0이면 true
            return true;
        else
            return false; // 아니면 false
    }
}
