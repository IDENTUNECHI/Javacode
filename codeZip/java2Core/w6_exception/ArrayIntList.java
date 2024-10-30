package java2Core.w6_exception;

import java.util.Arrays;

public class ArrayIntList {
    // fields
    private static final int DEFAULT_CAPACITY = 10;
    private int size; // 원소 수
    private int[] element; // 배열
    private int min;
    private int max;

    public ArrayIntList(){
        element = new int [DEFAULT_CAPACITY];
        size = 0;
        min = 0;
        max = 0;
    }

    /**
     * size를 0으로 하고
     * @param capacity 초기 용량 (0 이상)
     */
    public ArrayIntList(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException();
        }

        element = new int [capacity];
        size = 0;
        min = 0;
        max = 0;
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
        checkIndexForAdd(index, min, max);
        checkResize();

        for (int i = size; i > index; i--) { // index 이후의 값들을 한 칸씩 뒤로 옮김
            element[i] = element[i - 1];
        }
        element[index] = value;
        size++;
        max = size;
    }

    /**
     * 주어진 인덱스의 값을 제거하고 그 이후에 있는 값들을
     * 앞으로 한 칸씩 이동한다.
     * 일단 index는 0이상, size 미만이라고 가정한다.
     * @param index 인덱스.
     */
    public void remove(int index) {
        checkIndex(index, min, max);

        element[index] = 0;
        for(int i=index; i<size-1; i++){
            element[i] = element[i+1];
        }
        size--;
        max = size;
    }

    /**
     * 주어진 값을 리스트의 마지막에 추가한다.
     * 만약 배열이 이미 꽉 찬 상태이면 배열의 크기를 늘인다.
     * @param value 추가할 값
     */
    public void add(int value) {
        element[size] = value;
        size++;
        max = size;
    }

    /**
     * private helper method.
     * 배열이 꽉 찼는지 검사하고 isFull() 메소드를 활용
     * 꽉 찬 경우 배열의 크기를 두배로 늘여준다.
     * add메소드를 구현할 때 그 첫 문장으로 checkResize()를 호출하면 된다.
     * /
     * 어떤 크기의 배열을 새로 생성하고 기존 배열에 있던 모든 값들을 새 배열로
     * 복사해 주려면 java.util.Arrays 클래스의 아래 메소드를 사용하면 편리
     * Arrays.copyOf(int [] original, int newLength)
     */
    private void checkResize() {
        if(element.length >= size){
            element = Arrays.copyOf(element, element.length*2);
        }

    }

    /**
     * 주어진 인덱스의 값을 읽는다.
     * 일단, index는 0이상, size 미만이라고 가정한다.
     * @param index 인덱스
     * @return 읽은 값
     */
    public int get(int index) {
        checkIndex(index, min, max);
        return element[index];
    }

    /**
     * 주어진 인덱스의 값을 설정한다.
     * 일단, index는 0이상, size 미만이라고 가정한다.
     * @param index 인덱스
     * @param value 값
     */
    public void set(int index, int value) {
        checkIndex(index, min, max);
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
        return size == 0;
    }

    /**
     * 주어진 값이 리스트에 들어 있나?
     * @return
     */
    public boolean contains(int value){
        for(int factor : element){
            if(factor == value)
                return true;
        }
        return false;
    }
    /**
     * 주어진 값이 리스트에서 몇 번 방에 있는지 알아본다
     * @param value 값
     * @return index 값
     */
    public int indexOf(int value){
        for(int i=0; i<size; i++){
            if(element[i] == value){
                return i;
            }
        }
        return -1;
    }

    /**
     * private helper method.
     * 인덱스가 주어진 범위 내에 있는지 검사한다.
     * min 이상이고 max 이하이면 유효하다.
     * @param index 인덱스
     * @param min 최소값
     * @param max 최대값
     */
    private void checkIndex(int index, int min, int max) {
        if(min > index || index >= max){
            throw new IndexOutOfBoundsException("wrong index: "+ index);
        }
    }

    private void checkIndexForAdd(int index, int min, int max) {
        if(min > index || index > max){
            throw new IndexOutOfBoundsException("wrong index: "+ index);
        }
    }

    /**
     * 리스트를 아래 형식의 문자열로 반환한다.
     * "[12, 35, -54, 3]"
     * 빈 문자열이면 "[]"를 반환한다.
     * @return 출력 함수
     */
    public String toString(){


        return Arrays.toString(Arrays.copyOf(element, size));
    }

}
