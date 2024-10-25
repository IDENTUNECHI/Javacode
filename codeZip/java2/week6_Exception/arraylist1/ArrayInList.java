package java2.week6_Exception.arraylist1;
import java.util.*;

public class ArrayInList {
    // 초기 배열의 크기
    private static final int DEFAULT_CAPACITY = 10;

    // fields

    private int size; // 원소 수
    private int[] element; // 배열


    /**
     * size를 0으로 하고
     * 새로운 배열을 구성한뒤 크기를 DEFAULT_CAPACITY
     */
    public ArrayInList(){
        size = 0;
        element = new int [DEFAULT_CAPACITY];
    }

    /**
     * 주어진 값을 리스트의 주어진 인덱스 방에 삽입한다.
     * index 이후의 값들을 한 칸씩 뒤로 옮겨야 한다.
     * /
     * 만약 배열이 이미 꽉찬 상태이면 배열의 크기를 늘인다.
     * 더 큰 배열을 새로 생성하고 기존 배열에 있던 모든 값들을 새 배열로 복사해준다.
     * 기존 배열을 가리키던 element 상태 변수가 새 배열을 가리키게 한다.
     * 값을 삽입한 후에는 원소 수를 관리하는 데 사용하는 size 상태 변수를 1만큼 증가시킨다.
     * /
     * index 0 이상, size 이하이어야 한다.
     * @param index 인덱스
     * @param value 삽입할 값
     */
    public void add(int index, int value) {
        checkResize();

        if(0> index || index > size){
            throw new IndexOutOfBoundsException();
        }
        for(int i= size; i>index; i--) { // index 이후의 값들을 한 칸씩 뒤로 옮김
            element[i] = element [i-1];
        }
        element[index] = value;
        size++;
    }

    /**
     * private helper method.
     * 배열이 꽉 찼는지 검사하고 isFull() 메소드를 활용
     * 꽉 찬 경우 배열의 크기(size)를 두배로 늘여준다.
     * add메소드를 구현할 때 그 첫 문장으로 checkResize()를 호출하면 된다.
     * /
     * 어떤 크기의 배열을 새로 생성하고 기존 배열에 있던 모든 값들을 새 배열로
     * 복사해 주려면 java.util.Arrays 클래스의 아래 메소드를 사용하면 편리
     * Arrays.copyOf(int [] original, int newLength)
     */
    private void checkResize() {

        if(size >= element.length) {
            element = Arrays.copyOf(element, element.length*2);
        }

    }

    /**
     * 주어진 값을 리스트의 마지막에 추가한다.
     * 만약 배열이 이미 꽉 찬 상태이면 배열의 크기를 늘인다.
     * @param value 추가할 값
     */
    public void add(int value) {
        checkResize();
        element[size] = value;
        size++;
    }

    /**
     * 주어진 인덱스의 값을 읽는다.
     * 일단, index는 0이상, size 미만이라고 가정한다.
     * @param index 인덱스
     * @return 읽은 값
     */
    public int get(int index) {
        return element[index];
    }

    /**
     * 주어진 인덱스의 값을 설정한다.
     * 일단, index는 0이상, size 미만이라고 가정한다.
     * @param index 인덱스
     * @param value 값
     */
    public void set(int index, int value) {
        element[index] = value;
    }

    /**
     * 원소의 수가 얼마인지 알아낸다.
     * @return 원소의 수
     */
    public int size() {
        return size;
    }

    /**
     * 빈 리스트인가?
     * @return 빈 리스트인 경우 true, 그렇지 않으면 false.
     */
    public boolean isEmpty() {
        if(size == 0)
            return true;
        else
            return false;
    }

    /**
     * 주어진 인덱스의 값을 제거하고 그 이후에 있는 값들을
     * 앞으로 한 칸씩 이동한다.
     * 일단 index는 0이상, size 미만이라고 가정한다.
     * @param index 인덱스.
     */
    public void remove(int index) {
        element[index] = 0;
        for(int i=index; i<size-1; i++){
            element[i] = element[i+1];
        }
        size--;
    }
    /**
     * 리스트를 아래 형식의 문자열로 반환한다.
     * "[12, 35, -54, 3]"
     * 빈 문자열이면 "[]"를 반환한다.
     * @return 출력 함수
     */
    public String toStirng(){
        if(size == 0){
            return "[]";
        }
        return Arrays.toString(Arrays.copyOf(element, size));

    }

}
