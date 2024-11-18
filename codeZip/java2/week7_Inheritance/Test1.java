package java2.week7_Inheritance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * SortedIntList 제1단계 구현을 테스트하는 프로그램.
 * 여러 상황을 테스트하기 위해 상수들을 변경할 수도 있다.
 */
import java.util.Random;

import org.junit.Test;

public class Test1 {
	
    // number of elements to use in the checkAdd and checkIndexOf tests
    private static final int BASIC_TEST_SIZE = 10;
    
    // number of elements to use in the checkSpeed test (should be very large)
    private static final int SPEED_TEST_SIZE = 200000;
    
    // This method adds a series of numbers to the list and makes sure that
    // the size increases and that it produces a sorted list.
    @Test(timeout = 2000)
    public void checkAdd() {
        int testSize = BASIC_TEST_SIZE;
        SortedIntList list = new SortedIntList(false, testSize);
        Random r = new Random();
        for (int i = 0; i < testSize; i++) {
            // remember old list contents in case of a problem
            String old = list.toString();
            // pick a number between -testSize and +testSize, add to list
            int next = r.nextInt(2 * testSize + 1) - testSize;
            
            // randomly add the element to the list
            // (it should stay sorted)
            int expectedSize = i + 1;
            list.add(next);
            
            // check list size and make sure list is sorted
            assertEquals(expectedSize, list.size(), "size after adding " + expectedSize + " items (unique=false)");
            assertTrue(isSorted(list), "after adding " + next + ", list is not sorted.  List before add = " + 
            		old + ";\nlist after  add = " + list);
        }
    }

    // This method adds values to the list and uses a boolean array to keep
    // track of what values have been added.  It then checks often to make
    // sure that indexOf returns values that make sense given the set of
    // values that have been added to the list.
    @Test(timeout = 2000)
    public void checkIndexOf() {
        int testSize = BASIC_TEST_SIZE;
        SortedIntList list = new SortedIntList(false, testSize);
        Random r = new Random();
        // numbers will be between -testSize and +testSize
        boolean[] chosen = new boolean[2 * testSize + 1];
        checkIndexes(testSize, chosen, list);
        for (int i = 0; i < testSize; i++) {
            // pick a number between -testSize and +testSize, add to list
            int next = r.nextInt(2 * testSize + 1) - testSize;
            list.add(next);
            chosen[next + testSize] = true;
            checkIndexes(testSize, chosen, list);
        }
    }

    // This method constructs a very large list of even numbers and calls
    // indexOf many times to make sure that the code is fast.
    @Test(timeout = SPEED_TEST_SIZE / 2)
    public void checkAddSpeed() {
        int testSize = SPEED_TEST_SIZE;
        
        // fill up the list with even numbers
        SortedIntList list = new SortedIntList(false, testSize);
        for (int i = 0; i < testSize; i++) {
            list.add(2 * i);
        }

        // keep track of starting time before indexOf tests
        for (int i = 0; i < testSize; i++) {
            for (int j = 0; j < 100; j++) {
                int actualIndex = list.indexOf(2 * i);
                assertEquals(i, actualIndex, "indexOf " + 2 * i);
            }
        }
    }

    // returns true if list is sorted, false otherwise
    private boolean isSorted(SortedIntList list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // Compares the boolean array to the SortedIntList to make sure that
    // they match.  If a number has not been chosen, then its index should be
    // reported as -1.  If it has been chosen, then it should have a 
    // non-negative index and the number should actually be at that index.
    private void checkIndexes(int testSize, boolean[] chosen, SortedIntList list) {
        for (int i = 0; i < chosen.length; i++) {
            int original = i - testSize;
            int index = list.indexOf(original);
            
            // then check for bad cases
            if (chosen[i]) {
            	// item SHOULD be found
                assertTrue(index >= 0, "indexOf " + original + " should not be negative (" + index
                        + "); list = " + list);
                assertTrue(index < list.size(), "indexOf " + original + " should not be past the end of the list (" + 
                		index + "); list = " + list);
                assertEquals(original, list.get(index), "indexOf " + original + "; list = " + list);
            } else {
            	// item should NOT be found (negative index returned)
                assertTrue(index < 0, "indexOf " + original + " must be negative; list = " + list);
            }
        }
    }
    
    // Briefly tests the toString method for a non-unique list.
    @Test(timeout = 1000)
    public void checkToString() {
        SortedIntList list = new SortedIntList(5);
        list.add(5);
        list.add(-1);
        list.add(17);
        list.add(2);
        assertEquals("S:[-1, 2, 5, 17]", list.toString());
    }
    
    // Briefly tests the min/max methods.
    @Test(timeout = 1000)
    public void checkMinMax() {
        SortedIntList list = new SortedIntList();
        list.add(5);
        list.add(17);
        list.add(-6);
        list.add(2);
        assertEquals(-6, list.min(), "minimum value in " + list);
        assertEquals(17, list.max(), "maximum value in " + list);
    }
}
