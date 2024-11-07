package java2.week7_Inheritance;
import java.util.*;
// stutter: 말 더듬다
public class StutterIntList extends ArrayIntList{ // ArrayIntList의 서브클래스로 선언!

    //"stretch factor(반복도)" - 원소를 추가할 때 몇 개씩이나 추가되게 할 것인가?
    private int stretch;

    /**
     * 생성자.
     * 주어진 stretch factor와 주어진 용량을 갖는 리스트를 구성한다.
     * @param stretch 반복도
     * @param capacity 용량(배열의 크기)
     */
    public StutterIntList(int stretch, int capacity) {
        super(capacity);

        if(stretch < 0) {
            throw new IllegalArgumentException("Stretch factor cannot be negative");
        }
        this.stretch = stretch;
    }

    /**
     * 생성자.
     * 주어진 stretch factor를 갖는 기본 용량의 리스트를 구성한다.
     * @param stretch 반복도. {@literal stretch >= 0}.
     */
    public StutterIntList(int stretch) {
        this(stretch, DEFAULT_CAPACITY); // 클래스의 다른 생성자를 호출한다.
    }

    /**
     * 주어진 값을 주어진 위치에 추가하되 stretch factor만큼 추가한다.
     */
    public void add(int index, int value) {
        for(int i=1; i<= stretch; i++) {
            super.add(index, value);
            // super.add라고 하지 않고 그냥 add라고 하면
            // 자기 자신을 호출하는 것이므로 무한 루프에 빠지게 된다
        }
    }

    /**
     * 이 StutterIntList의 stretch factor를 반환한다.
     * @return stretch factor.
     */
    public int getStretch() {
        return stretch;
    }
    /**
     * 주어진 값이 이 리스트에 몇 개나 들어 있는지 알아낸다.
     * @param value 주어진 값
     * @return 리스트에 value가 몇 개나 들어 있나?
     */

    public int count (int value) {
        int number = 0;

        for(int i=0; i<size; i++) {
            if(element[i] == value)
                number++;
        }
        return number;
    }
    /**
     * 이 리스트에 들어 있는 각 값이 각각 몇 개씩이나 들어 있는
     * @return 리스트에 value가 몇 개나 들어 있나
     * {-1=3. 3=3. 5=5, 7=3}
     */
    public Map<Integer, Integer> counts() {
         Map<Integer, Integer> map = new TreeMap<>();
         for(int i=0; i<size; i++) {
             map.put(this.element[i], map.getOrDefault(element[i], 0)+1);
         }
         return map;
    }
}
