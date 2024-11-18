package java2.week7_Inheritance;

// CSE 143, Homework 2 (SortedIntList)
//
// This program tests stage 3 of the SortedIntList project, making sure that you
// handle the unique flag and duplicate value elimination correctly.  The methods
// called in main each perform a series of checks and throw an exception if
// anything test fails.  The program uses the list size as its primary
// measure of correctness.  It doesn't verify, for example, that the list
// stores the correct numbers.  It just verifies that it has the expected
// number of values.
//
// adapted from 1/6/07 version by Stuart Reges

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.*;

public class Test3 {
    // number of times to repeat each test at each size (try 2--10)
    public static final int REPETITIONS = 2;
    
    // maximum list size to use in a test (start small, then increase it)
    public static final int MAX_TEST_SIZE = 50;
    
    // set to false if you don't want to see printlns for every passed test run
    public static final boolean VERBOSE = true;
    
    @Test(timeout = 5000)
    public void test1() {
        // the program performs 10 tests each for test sizes from 0 to MAX_TEST_SIZE
        for (int testSize = 0; testSize <= MAX_TEST_SIZE; testSize++) {
            for (int i = 0; i < REPETITIONS; i++) {
                SortedIntList list1 = new SortedIntList(true, testSize);
                testTrue(list1, testSize);
                SortedIntList list2 = new SortedIntList(false, 2 * testSize);
                testFalse(list2, testSize);
            }
        }
    }

    // This method tests the case where unique is set to true most of the time
    private void testTrue(SortedIntList list, int testSize) {
        setAndTestUnique(list, true, testSize);
        boolean[] chosen = new boolean[testSize];
        int count = 0;
        Random r = new Random();

        // this loop generates random numbers until all test numbers have
        // been added to the list
        while (count < testSize) {
            int next = r.nextInt(testSize);
            list.add(next);
            if (!chosen[next]) {
                count++;
                chosen[next] = true;
            }
            checkSize("while adding initial numbers to list", list, count, testSize);
        }

        // make sure we can turn unique off and on again
        setAndTestUnique(list, false, testSize);
        setAndTestUnique(list, true, testSize);
        checkSize("after setting unique to false and then back to true", list, testSize, testSize);

        // batter the list with duplicates to make sure it works
        for (int i = 0; i < testSize * 10; i++) {
            int next = r.nextInt(testSize);
            list.add(next);
        }
        checkSize("after attempting to add many duplicates", list, testSize, testSize);
    }

    // This method tests the case where unique is set to false most of the time
    private void testFalse(SortedIntList list, int testSize) {
        setAndTestUnique(list, false, testSize);
        boolean[] chosen = new boolean[testSize];
        int count = 0;
        Random r = new Random();

        // this loop will add each test number exactly once to the list
        while (count < testSize) {
            int next = r.nextInt(testSize);
            if (!chosen[next]) {
                list.add(next);
                count++;
                chosen[next] = true;
            }
            checkSize("after adding many distinct values to the list", list, count, testSize);
        }

        // then we add testSize duplicates to the list
        for (int i = 1; i <= testSize; i++) {
            int next = r.nextInt(testSize);
            list.add(next);
            checkSize("after adding a duplicate of value " + next, list, testSize + i, testSize);
        }

        // and make sure that they are removed when we set unique back to true
        System.out.println("before setUnique " + list);
        setAndTestUnique(list, true, testSize);
        System.out.println("after setUnique " + list);
        System.out.println("testSize " + testSize);
        checkSize("after setting unique to true", list, testSize, testSize); // 오류 발생

        // then add testSize more duplicates
        setAndTestUnique(list, false, testSize);
        for (int i = 1; i <= testSize; i++) {
            int next = r.nextInt(testSize);
            list.add(next);
            checkSize("after setting unique back to false and then adding a duplicate of value " + next, list, testSize + i, testSize);
        }

        // and again make sure they are removed when unique is set to false
        setAndTestUnique(list, true, testSize);
        checkSize("after setting unique back to true (duplicates should be removed)", list, testSize, testSize);
    }

    // sets the unique property to the given value and makes sure that
    // getUnique returns the same value
    private void setAndTestUnique(SortedIntList list, boolean unique, int testSize) {
        list.setUnique(unique);
        if (unique) {
            assertTrue(list.getUnique(), " after setting it to " + unique +
                    " with test size = " + testSize);
        } else {
            assertFalse(list.getUnique(), " after setting it to " + unique +
                    " with test size = " + testSize);
        }
    }

    // Checks to see if the list has the appropriate size.
    private void checkSize(String message, SortedIntList list, int size, int testSize) {
        assertEquals(size, list.size(), message + ", list = " + list +
                " (if your size does match the number of elements in your list, " +
                "this error probably means you have not properly added the " +
                "number of elements requested by the test case.  " +
                "Or you may have a bug related to uniqueness/duplicates.)  " +
                "Size does not match what is expected.");
    }
}
