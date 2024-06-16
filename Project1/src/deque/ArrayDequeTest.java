package deque;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @org.junit.Test // 1 point
    public void testAddFirstEmpty(){
        ArrayDeque<String> arrayDeque = new ArrayDeque<String>();

        arrayDeque.addFirst("front");
        assertTrue(arrayDeque.size() == 1);
    }

    @org.junit.Test // 2 points
    public void testAddFirstNonEmpty(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();

        arrayDeque.addFirst(10);
        arrayDeque.addFirst(20);
        arrayDeque.addFirst(30);

        assertTrue("The first element in the deque is incorrect", arrayDeque.get(0) == 30);
    }

    @org.junit.Test // 2 points
    public void testAddFirstNonEmptyLarge(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();

        arrayDeque.addFirst(10);
        arrayDeque.addFirst(20);
        arrayDeque.addFirst(30);

        for(int i = 50; i <= 100; i ++){
            arrayDeque.addFirst(i);
        }

        assertTrue("The first element in the deque is incorrect", arrayDeque.get(0) == 100);
    }

    @org.junit.Test // 1 point
    public void testAddLastEmpty(){
        ArrayDeque<String> arrayDeque = new ArrayDeque<String>();

        arrayDeque.addLast("front");
        assertTrue(arrayDeque.size() == 1);
    }

    @org.junit.Test // 2 points
    public void testAddLastNonEmpty(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();

        arrayDeque.addLast(10);
        arrayDeque.addLast(20);
        arrayDeque.addLast(30);

        assertTrue("The last element in the deque is incorrect", arrayDeque.get(2) == 30);
    }

    @org.junit.Test // 2 points (hide this test case)
    public void testAddLastNonEmptyLarge(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();

        arrayDeque.addLast(10);
        arrayDeque.addLast(20);
        arrayDeque.addLast(30);

        for(int i = 0; i < 100; i ++){
            arrayDeque.addLast(i);
        }

        assertTrue("Hidden test case: Testing adding large number of elements to end of deque. The last element in the deque is incorrect",
                arrayDeque.get(102) == 99);
    }

    @org.junit.Test // 1 point
    public void testRemoveFirst(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();

        for(int i = 0; i < 100; i ++){
            if(i % 2 == 0) {
                arrayDeque.addFirst(i);
            } else {
                arrayDeque.addLast(i);
            }
        }

        int firstValue = arrayDeque.removeFirst();
        assertTrue(firstValue == 98);
    }

    @org.junit.Test // 1 point
    public void testRemoveLast(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();

        for(int i = 0; i < 100; i ++){
            if(i % 2 == 0) {
                arrayDeque.addFirst(i);
            } else {
                arrayDeque.addLast(i);
            }
        }

        int firstValue = arrayDeque.removeLast();
        assertTrue(firstValue == 99);
    }

    @org.junit.Test // 1 point
    public void testRemoveFirstEmpty(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();

        for(int i = 0; i < 2; i ++){
            if(i % 2 == 0) {
                arrayDeque.addFirst(i);
            } else {
                arrayDeque.addLast(i);
            }
        }

        for(int timesToRemove = 0; timesToRemove < 2; timesToRemove ++) {
            arrayDeque.removeFirst();
        }
        assertTrue(arrayDeque.removeFirst() == null);
    }

    @org.junit.Test // 1 point
    public void testRemoveLastEmpty(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();

        for(int i = 0; i < 2; i ++){
            if(i % 2 == 0) {
                arrayDeque.addFirst(i);
            } else {
                arrayDeque.addLast(i);
            }
        }

        for(int timesToRemove = 0; timesToRemove < 2; timesToRemove ++) {
            arrayDeque.removeLast();
        }
        assertTrue(arrayDeque.removeLast() == null);
    }
    @org.junit.Test // 6 points
    public void testRemoveBothEnds(){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();

        for(int i = 0; i < 5000; i ++){
            if(i % 2 == 0) {
                arrayDeque.addFirst(i);
            } else {
                arrayDeque.addLast(i);
            }
        }
        assertTrue(arrayDeque.removeLast() == 4999);
        assertTrue(arrayDeque.removeFirst() == 4998);
        assertTrue(arrayDeque.removeLast() == 4997);
        assertTrue(arrayDeque.removeFirst() == 4996);
    }
    @org.junit.Test // 1 point
    public void testSize() {
        int upperBound = 10000;

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for(int value = 1; value <= upperBound; value += 1){
            if(value % 2 == 1){
                arrayDeque.addFirst(value);
            } else {
                arrayDeque.addLast(value);
            }
        }

        for(int numRemovals = 1; numRemovals <= 50; numRemovals += 1){
            if(numRemovals % 2 == 1){
                arrayDeque.removeFirst();
            } else {
                arrayDeque.removeLast();
            }
        }
        assertTrue(arrayDeque.size() == upperBound - 50);
    }

    @org.junit.Test // 1 point
    public void testGetFront() {
        int upperBound = 500;

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for(int value = 0; value < upperBound; value += 1){
            if(value % 2 == 1){
                arrayDeque.addFirst(value);
            } else {
                arrayDeque.addLast(value);
            }
        }
        assertTrue(arrayDeque.get(0) == 499);
    }

    @org.junit.Test // 3 points (hide this test case)
    public void testGetMiddle() {
        int upperBound = 500;

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for(int value = 1; value <= upperBound; value += 1){
            if(value % 2 == 1){
                arrayDeque.addFirst(value);
            } else {
                arrayDeque.addLast(value);
            }
        }

        assertTrue("Hidden Test Case: Wrong value returned when retrieving element from middle of deque",
                arrayDeque.get(249) == 1);
    }

    @org.junit.Test // 1 point
    public void testGetEnd() {
        int upperBound = 500;

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for(int value = 1; value <= upperBound; value += 1){
            if(value % 2 == 1){
                arrayDeque.addFirst(value);
            } else {
                arrayDeque.addLast(value);
            }
        }
        assertTrue(arrayDeque.get(499) == 500);
    }
    @org.junit.Test // 1 point
    public void testGetNull() {
        int upperBound = 500;

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for(int value = 1; value <= upperBound; value += 1){
            if(value % 2 == 1){
                arrayDeque.addFirst(value);
            } else {
                arrayDeque.addLast(value);
            }
        }
        assertTrue(arrayDeque.get(501) == null);
        assertTrue(arrayDeque.get(-2) == null);
    }

    @org.junit.Test // 0.5 points
    public void testIteratorEmpty() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        assertFalse(arrayDeque.iterator().hasNext());
    }
    @org.junit.Test // 1.5 points
    public void testIteratorSmall() {
        int upperBound = 50;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int[] numbers = new int[upperBound];
        int idx = 0;

        for(int value = 1; value <= upperBound; value += 1){
            if(value % 2 == 1){
                arrayDeque.addFirst(value);
            } else {
                arrayDeque.addLast(value);
            }
        }

        // Odd numbers in descending order are expected at front of deque
        for(int i = upperBound - 1; i >= 1; i -= 2){
            numbers[idx] = i;
            idx += 1;
        }

        // Even numbers in ascending order are expected at front of deque
        for(int i = 2; i <= upperBound; i += 2){
            numbers[idx] = i;
            idx += 1;
        }

        idx = 0;
        for(int i: arrayDeque){
            assertTrue(i == numbers[idx]);
            idx += 1;
        }
    }

    @org.junit.Test // 2 points
    public void testIteratorLarge() {
        int upperBound = 5000;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int[] numbers = new int[upperBound];
        int idx = 0;

        for(int value = 1; value <= upperBound; value += 1){
            if(value % 2 == 1){
                arrayDeque.addFirst(value);
            } else {
                arrayDeque.addLast(value);
            }
        }

        // Odd numbers in descending order are expected at front of deque
        for(int i = upperBound - 1; i >= 1; i -= 2){
            numbers[idx] = i;
            idx += 1;
        }

        // Even numbers in ascending order are expected at front of deque
        for(int i = 2; i <= upperBound; i += 2){
            numbers[idx] = i;
            idx += 1;
        }

        idx = 0;
        for(int i: arrayDeque){
            assertTrue(i == numbers[idx]);
            idx += 1;
        }
    }

    @org.junit.Test // 2 points
    public void testIteratorRemoveFront() {
        int upperBound = 5000;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int[] numbers = new int[upperBound - 1];
        int idx = 0;

        for(int value = 1; value <= upperBound; value += 1){
            if(value % 2 == 1){
                arrayDeque.addFirst(value);
            } else {
                arrayDeque.addLast(value);
            }
        }

        arrayDeque.removeFirst();
        // Odd numbers in descending order are expected at front of deque
        for(int i = upperBound - 3; i >= 1; i -= 2){
            numbers[idx] = i;
            idx += 1;
        }

        // Even numbers in ascending order are expected at front of deque
        for(int i = 2; i <= upperBound; i += 2){
            numbers[idx] = i;
            idx += 1;
        }

        idx = 0;
        for(int i: arrayDeque){
            assertTrue(i == numbers[idx]);
            idx += 1;
        }
    }

    @org.junit.Test // 2 points
    public void testIteratorRemoveLast() {
        int upperBound = 5000;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int[] numbers = new int[upperBound - 1];
        int idx = 0;

        for(int value = 1; value <= upperBound; value += 1){
            if(value % 2 == 1){
                arrayDeque.addFirst(value);
            } else {
                arrayDeque.addLast(value);
            }
        }

        arrayDeque.removeLast();
        // Odd numbers in descending order are expected at front of deque
        for(int i = upperBound - 1; i >= 1; i -= 2){
            numbers[idx] = i;
            idx += 1;
        }

        // Even numbers in ascending order are expected at back of deque
        for(int i = 2; i <= upperBound - 2; i += 2){
            numbers[idx] = i;
            idx += 1;
        }

        idx = 0;
        for(int i: arrayDeque){
            assertTrue(i == numbers[idx]);
            idx += 1;
        }
    }
}