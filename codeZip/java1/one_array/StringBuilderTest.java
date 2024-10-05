package java1.one_array;

/**
 * 첫 번째 방법: String 문자열을 for문을 이용해 더한다
 * 두 번째 방법; StringBuilder를 사용해 append를 이용하여 더한다.
 * @author 김이든
 */
public class StringBuilderTest {
    public static void main(String[] args){
        //첫 번째 방법
        long beforeTime1= System.currentTimeMillis();
        for (int i=0; i<10000; i++){
            System.out.print("여름");
        }

        long afterTime1= System.currentTimeMillis();
        long sec1 = afterTime1-beforeTime1;


        // 두 번째 방법
        long beforeTime2= System.currentTimeMillis();
        // 새 StringBuilder 인스턴스를 만든다.
        StringBuilder builder = new StringBuilder();

        // 문자열을 추가하는 작업을 반복한다.
        for (int i = 0; i < 10000; i++) {
            builder.append("여름");
        }
        // String으로 변환한다.
        String result = builder.toString();

        // 결과를 출력한다.
        System.out.println(result);
        long afterTime2= System.currentTimeMillis();
                long sec2 = afterTime2-beforeTime2;
                System.out.println("String 더하기 시간 = "+sec1);
                System.out.println("StringBuilder 시간 = "+ sec2);
    }
}
