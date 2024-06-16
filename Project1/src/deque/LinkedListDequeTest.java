package deque;
import static org.junit.Assert.*;

public class LinkedListDequeTest {
    @org.junit.Test // 1 point
    public void testAddFirstEmpty(){
        LinkedListDeque<String> LinkedListDeque = new LinkedListDeque<String>();

        LinkedListDeque.addFirst("front");
        assertTrue(LinkedListDeque.size() == 1);
    }

    @org.junit.Test // 2 points
    public void testAddFirstNonEmpty(){
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<Integer>();

        LinkedListDeque.addFirst(10);
        LinkedListDeque.addFirst(20);
        LinkedListDeque.addFirst(30);

        assertTrue("The first element in the deque is incorrect", LinkedListDeque.get(0) == 30);
    }

    @org.junit.Test // 2 points
    public void testAddFirstNonEmptyLarge(){
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<Integer>();

        LinkedListDeque.addFirst(10);
        LinkedListDeque.addFirst(20);
        LinkedListDeque.addFirst(30);

        for(int i = 50; i <= 100; i ++){
            LinkedListDeque.addFirst(i);
        }

        assertTrue("The first element in the deque is incorrect", LinkedListDeque.get(0) == 100);
    }

    @org.junit.Test // 1 point
    public void testAddLastEmpty(){
        LinkedListDeque<String> LinkedListDeque = new LinkedListDeque<String>();

        LinkedListDeque.addLast("front");
        assertTrue(LinkedListDeque.size() == 1);
    }

    @org.junit.Test // 2 points
    public void testAddLastNonEmpty(){
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<Integer>();

        LinkedListDeque.addLast(10);
        LinkedListDeque.addLast(20);
        LinkedListDeque.addLast(30);

        assertTrue("The last element in the deque is incorrect", LinkedListDeque.get(2) == 30);
    }

    @org.junit.Test // 2 points (hide this test case)
    public void testAddLastNonEmptyLarge(){
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<Integer>();

        LinkedListDeque.addLast(10);
        LinkedListDeque.addLast(20);
        LinkedListDeque.addLast(30);

        for(int i = 0; i < 100; i ++){
            LinkedListDeque.addLast(i);
        }

        assertTrue("Hidden test case: Testing adding large number of elements to end of deque. The last element in the deque is incorrect",
                LinkedListDeque.get(102) == 99);
    }

    @org.junit.Test // 1 point
    public void testRemoveFirst(){
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<Integer>();

        for(int i = 0; i < 100; i ++){
            if(i % 2 == 0) {
                LinkedListDeque.addFirst(i);
            } else {
                LinkedListDeque.addLast(i);
            }
        }

        int firstValue = LinkedListDeque.removeFirst();
        assertTrue(firstValue == 98);
    }

    @org.junit.Test // 1 point
    public void testRemoveLast(){
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<Integer>();

        for(int i = 0; i < 100; i ++){
            if(i % 2 == 0) {
                LinkedListDeque.addFirst(i);
            } else {
                LinkedListDeque.addLast(i);
            }
        }

        int firstValue = LinkedListDeque.removeLast();
        assertTrue(firstValue == 99);
    }

    @org.junit.Test // 1 point
    public void testRemoveFirstEmpty(){
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<Integer>();

        for(int i = 0; i < 2; i ++){
            if(i % 2 == 0) {
                LinkedListDeque.addFirst(i);
            } else {
                LinkedListDeque.addLast(i);
            }
        }

        for(int timesToRemove = 0; timesToRemove < 2; timesToRemove ++) {
            LinkedListDeque.removeFirst();
        }
        assertTrue(LinkedListDeque.removeFirst() == null);
    }

    @org.junit.Test // 1 point
    public void testRemoveLastEmpty(){
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<Integer>();

        for(int i = 0; i < 2; i ++){
            if(i % 2 == 0) {
                LinkedListDeque.addFirst(i);
            } else {
                LinkedListDeque.addLast(i);
            }
        }

        for(int timesToRemove = 0; timesToRemove < 2; timesToRemove ++) {
            LinkedListDeque.removeLast();
        }
        assertTrue(LinkedListDeque.removeFirst() == null);
        assertTrue(LinkedListDeque.removeLast() == null);
    }
    @org.junit.Test // 6 points
    public void testRemoveBothEnds(){
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<Integer>();

        for(int i = 0; i < 5000; i ++){
            if(i % 2 == 0) {
                LinkedListDeque.addFirst(i);
            } else {
                LinkedListDeque.addLast(i);
            }
        }
        assertTrue(LinkedListDeque.removeLast() == 4999);
        assertTrue(LinkedListDeque.removeFirst() == 4998);
        assertTrue(LinkedListDeque.removeLast() == 4997);
        assertTrue(LinkedListDeque.removeFirst() == 4996);
    }
    @org.junit.Test // 1 point
    public void testSize() {
        int upperBound = 10000;

        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<>();
        for(int value = 1; value <= upperBound; value += 1){
            if(value % 2 == 1){
                LinkedListDeque.addFirst(value);
            } else {
                LinkedListDeque.addLast(value);
            }
        }

        for(int numRemovals = 1; numRemovals <= 50; numRemovals += 1){
            if(numRemovals % 2 == 1){
                LinkedListDeque.removeFirst();
            } else {
                LinkedListDeque.removeLast();
            }
        }
        assertTrue(LinkedListDeque.size() == upperBound - 50);
    }

    @org.junit.Test // 1 point
    public void testGetFront() {
        int upperBound = 500;

        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<>();
        for(int value = 0; value < upperBound; value += 1){
            if(value % 2 == 1){
                LinkedListDeque.addFirst(value);
            } else {
                LinkedListDeque.addLast(value);
            }
        }
        assertTrue(LinkedListDeque.get(0) == 499);
    }

    @org.junit.Test // 3 points (hide this test case)
    public void testGetMiddle() {
        int upperBound = 500;

        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<>();
        for(int value = 1; value <= upperBound; value += 1){
            if(value % 2 == 1){
                LinkedListDeque.addFirst(value);
            } else {
                LinkedListDeque.addLast(value);
            }
        }

        assertTrue("Hidden Test Case: Wrong value returned when retrieving element from middle of deque",
                LinkedListDeque.get(249) == 1);
    }

    @org.junit.Test // 1 point
    public void testGetEnd() {
        int upperBound = 500;

        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<>();
        for(int value = 1; value <= upperBound; value += 1){
            if(value % 2 == 1){
                LinkedListDeque.addFirst(value);
            } else {
                LinkedListDeque.addLast(value);
            }
        }
        assertTrue(LinkedListDeque.get(499) == 500);
    }
    @org.junit.Test // 1 point
    public void testGetNull() {
        int upperBound = 500;

        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<>();
        for(int value = 1; value <= upperBound; value += 1){
            if(value % 2 == 1){
                LinkedListDeque.addFirst(value);
            } else {
                LinkedListDeque.addLast(value);
            }
        }
        assertTrue(LinkedListDeque.get(501) == null);
        assertTrue(LinkedListDeque.get(-2) == null);
    }

    @org.junit.Test // 0.5 points
    public void testIteratorEmpty() {
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<>();
        assertFalse(LinkedListDeque.iterator().hasNext());
    }
    @org.junit.Test // 1.5 points
    public void testIteratorSmall() {
        int upperBound = 50;
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<>();
        int[] numbers = new int[upperBound];
        int idx = 0;

        for(int value = 1; value <= upperBound; value += 1){
            if(value % 2 == 1){
                LinkedListDeque.addFirst(value);
            } else {
                LinkedListDeque.addLast(value);
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
        for(int i: LinkedListDeque){
            assertTrue(i == numbers[idx]);
            idx += 1;
        }
    }

    @org.junit.Test // 2 points
    public void testIteratorLarge() {
        int upperBound = 5000;
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<>();
        int[] numbers = new int[upperBound];
        int idx = 0;

        for(int value = 1; value <= upperBound; value += 1){
            if(value % 2 == 1){
                LinkedListDeque.addFirst(value);
            } else {
                LinkedListDeque.addLast(value);
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
        for(int i: LinkedListDeque){
            assertTrue(i == numbers[idx]);
            idx += 1;
        }
    }

    @org.junit.Test // 2 points
    public void testIteratorRemoveFront() {
        int upperBound = 5000;
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<>();
        int[] numbers = new int[upperBound - 1];
        int idx = 0;

        for(int value = 1; value <= upperBound; value += 1){
            if(value % 2 == 1){
                LinkedListDeque.addFirst(value);
            } else {
                LinkedListDeque.addLast(value);
            }
        }

        LinkedListDeque.removeFirst();
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
        for(int i: LinkedListDeque){
            assertTrue(i == numbers[idx]);
            idx += 1;
        }
    }

    @org.junit.Test // 2 points
    public void testIteratorRemoveLast() {
        int upperBound = 5000;
        LinkedListDeque<Integer> LinkedListDeque = new LinkedListDeque<>();
        int[] numbers = new int[upperBound - 1];
        int idx = 0;

        for(int value = 1; value <= upperBound; value += 1){
            if(value % 2 == 1){
                LinkedListDeque.addFirst(value);
            } else {
                LinkedListDeque.addLast(value);
            }
        }

        LinkedListDeque.removeLast();
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
        for(int i: LinkedListDeque){
            assertTrue(i == numbers[idx]);
            idx += 1;
        }
    }
}