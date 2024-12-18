package Java2Practice2.Inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class SortedIntList extends ArrayIntList {
    // fields
    protected boolean uniqueness;

    /**
     * DEFAULT_CAPACITY 크기의 배열을 구성하고
     * size를 0으로 설정한다.
     */
    public SortedIntList() {
        element = new int[DEFAULT_CAPACITY];
        uniqueness = false;
    }

    // uniqueness == true 원소 중복 금지
    // uniqueness == false 원소 중복 허용
    public SortedIntList(boolean uniqueness){
        this.uniqueness = uniqueness;
    }

    public SortedIntList(boolean uniqueness, int capacity){
        this.uniqueness = uniqueness;
        if(capacity < 0)
            throw new IllegalArgumentException("capacity cannot be negative: " + capacity);

        element = new int[capacity];
    }

    /**
     * 주어진 크기의 크기의 배열을 구성하고
     * size를 0으로 설정한다.
     * @param capacity 초기 용량 (0 이상이어야 함).
     */
    public SortedIntList(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("capacity cannot be negative: " + capacity);

        size = 0;
        element = new int[capacity];
    }

    /**
     * 주어진 값을 리스트의 마지막에 추가한다.
     * 만약 배열이 이미 꽉 찬 상태이면 배열의 크기를 늘인다.
     * @param value 추가할 값.
     */
    public void add(int value) {
        Arrays.sort(element);
        int index1 = Arrays.binarySearch(element, value);
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

    /**
     * 주어진 값을 리스트의 주어진 인덱스 방에 삽입한다.
     * 만약 배열이 이미 꽉 찬 상태이면 배열의 크기를 늘인다.
     * 일단, index는 0 이상, size 이하라고 가정한다.
     * @param index 인덱스.
     * @param value 삽입할 값.
     */
    public void add(int index, int value) {
        throw new UnsupportedOperationException();
    }

    public boolean getUnique() {
        return uniqueness;
    }

    public void setUnique(boolean value) {
        if(uniqueness == value) return;
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

        return element[element.length-1];
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
