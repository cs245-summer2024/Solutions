package lists;


import static org.junit.jupiter.api.Assertions.*;

class DListTest {

    @org.junit.jupiter.api.Test // 1 point
    void getPositiveIndex() {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8};
        DList<Integer> numbers = new DList<>();
        for(int v: values) {
            numbers.insertElement(0, v);
        }
        assertTrue(numbers.get(2) == 6);
    }

    @org.junit.jupiter.api.Test // 1 point
    void getThrowExceptionPositiveIndex() {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8};
        boolean threwException = false;

        DList<Integer> numbers = new DList<>();
        for(int v: values) {
            numbers.insertElement(0, v);
        }
        try {
            numbers.get(8);
        } catch (IndexOutOfBoundsException e) {
            threwException = true;
        }
        assertTrue(threwException);
    }

    @org.junit.jupiter.api.Test // 1 point
    void getNegativeIndex() {
        int[] values = {10, 2, 30, 4, 50, 6, 7, 80};
        DList<Integer> numbers = new DList<>();
        for(int v: values) {
            numbers.insertElement(0, v);
        }
        assertTrue(numbers.get(-8) == 80);
        assertTrue(numbers.get(-3) == 30);
        assertTrue(numbers.get(0) == 80);
    }

    @org.junit.jupiter.api.Test // 1 point
    void getThrowExceptionNegativeIndex() {
        int[] values = {10, 2, 30, 4, 50, 6, 7, 80};
        boolean threwException = false;

        DList<Integer> numbers = new DList<>();
        for(int v: values) {
            numbers.insertElement(0, v);
        }
        try {
            numbers.get(-9);
        } catch (IndexOutOfBoundsException e) {
            threwException = true;
        }
        assertTrue(threwException);
    }
}