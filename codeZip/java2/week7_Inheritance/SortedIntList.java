package java2.week7_Inheritance;
import java.util.*;

/**
 * SortedIntList는 원소들을 오름차순으로 저장합니다.
 * SortedIntList는 원소의 중복을 금지할지 말지 결정 가능
 */

public class SortedIntList extends ArrayIntList{
    protected boolean uniqueness;
    //protected int size = 0;
    /**
     * 기본 용량 10을 갖는, uniqueness가 false로 설정된 리스트를 생성한다.
     * 원소의 중복 허용
     */
    public SortedIntList() {
        this(false);
        element = new int[10];
    }
    /**
     * uniqueness true 원소 중복 x
     * uniqueness false 원소 중복 o
     */
    public SortedIntList(boolean unique){
        uniqueness = unique;
        element = new int [10];

    }

    /**
     * 주어진 용량을 갖는 uniqueness가 false로 설정된 리스트를 생성
     * 만약 capacity가 음수라면 illegalArgumentException이 발생
     */
    public SortedIntList(int capacity) {
        if(capacity<0)
            throw new IllegalArgumentException("capacity cannot be negative: "+capacity);

        uniqueness = false;
        element = new int [capacity];
    }

    public SortedIntList(boolean unique, int capacity) {
        uniqueness = unique;
        if(capacity<0)
            throw new IllegalArgumentException("capacity cannot be negative: "+capacity);

        element = new int [capacity];
    }

    /**
     * value를 리스트의 끝에 추가하는 대신 오름차순이 유지되도록 하는 위치에 삽입
     * uniqueness가 true일때 value가 중복되었다면 넣지 말아야함
     * @param value 추가할 값.
     */
    public void add(int value){
         // 오름차순으로 정렬
        int index1 = Arrays.binarySearch(element, 0, size, value);

            if (uniqueness) { // 중복 불가능
                if (index1 < 0) { // value가 해당 배열에 없음
                    int index = Math.abs(index1 + 1);
                    super.add(index, value);
                    //size++;
                }
            }
            else {
                if (index1 < 0) { // value가 해당 배열에 없음
                    int index = Math.abs(index1 + 1);
                    super.add(index, value);
                    //size++;

                } else {
                    int index = Math.abs(index1 + 1);
                    super.add(index, value);
                    //size++;
                }
            }
    }
    public void add(int index, int value){
        throw new UnsupportedOperationException();
    }

    /**
     * 현재의 uniqueness 설정 내역을 반환
     * @return uniqueness
     */
    public boolean getUnique(){
        return this.uniqueness;
    }

    /**
     * 리스트의 원소중복금지 여부를 설정
     * 근데 중간에 삭제를 어떤식으로 하면 좋을까
     * 여기는 내일 다시 해보자
     * @param value true or false
     */
    public void setUnique(boolean value) {
        if(uniqueness == value){
            return;
        }
        uniqueness = value;

        if (uniqueness) {
            // 중복을 제거하기 위해 리스트를 정렬합니다.

            int uniqueCount = 0; // 중복되지 않은 원소의 개수
            for (int i = 0; i < size; i++) {
                if (i==0 || element[i] != element[uniqueCount - 1]) {
                    // 첫 원소이거나, 이전 원소와 다른 경우
                    element[uniqueCount] = element[i];
                    uniqueCount++;
                }
            }

            size = uniqueCount;
        }
    }

    public int max(){
        if(size == 0)
            throw new NoSuchElementException();
        return element[size-1];
    }
    public int min(){
        if(size == 0)
            throw new NoSuchElementException();
        return element[0];
    }

    public String toString() {

        int[] activeElements = Arrays.copyOfRange(element, 0, size);

        if (uniqueness) {
            return "S:" + Arrays.toString(activeElements) + "U";
        }
        return "S:" + Arrays.toString(activeElements);

    }

    public int indexOf(int value) {

        int index = Arrays.binarySearch(element, 0, size, value);

        return index >= 0 ? index : -1;
    }

}
