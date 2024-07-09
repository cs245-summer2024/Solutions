package lists;

import static org.junit.jupiter.api.Assertions.*;


class SListTest {
    /*
        Test Cases for Question 6
     */
    @org.junit.jupiter.api.Test // 1 point
    void testNoCompress(){
        int[] numbersToAdd = {1, 2, 3, 4, 5, 6, 7, 8};

        SList numList = new SList();
        SList expected = new SList();
        for(int i: numbersToAdd) {
            numList.addFirst(i);
            expected.addFirst(i);
        }
        numList.compressNodes();
        assertTrue(numList.equals(expected));
    }

    @org.junit.jupiter.api.Test // 1.5 points
    void testCompressFront(){
        int[] numbersToAdd = {1, 2, 3, 4, 5, 8, 8, 8};
        int[] compressed = {1, 2, 3, 4, 5, 24};
        SList numList = new SList();
        SList expected = new SList();

        for(int i: numbersToAdd) {
            numList.addFirst(i);
        }

        for(int i: compressed) {
            expected.addFirst(i);
        }
        numList.compressNodes();
        assertTrue(numList.equals(expected));
    }

    @org.junit.jupiter.api.Test // 1.5 points
    void testCompressBack(){
        int[] numbersToAdd = {2, 2, 3, 4, 5, 6, 7, 8};
        int[] compressed = {4, 3, 4, 5, 6, 7, 8};
        SList numList = new SList();
        SList expected = new SList();

        for(int i: numbersToAdd) {
            numList.addFirst(i);
        }

        for(int i: compressed) {
            expected.addFirst(i);
        }

        numList.compressNodes();
        assertTrue(numList.equals(expected));
    }

    @org.junit.jupiter.api.Test // 2 points
    void testCompressAll(){
        int[] numbersToAdd = {2, 2, 2, 2, 2, 2, 2};
        int[] compressed = {14};
        SList numList = new SList();
        SList expected = new SList();

        for(int i: numbersToAdd) {
            numList.addFirst(i);
        }

        for(int i: compressed) {
            expected.addFirst(i);
        }
        numList.compressNodes();
        assertTrue(numList.equals(expected));
    }

    @org.junit.jupiter.api.Test // 2 points
    void hiddenCompressionCase(){
        int[] numbersToAdd = {1, 1, 8, 4, 4, 3, 2, 5, 1, 1};
        int[] compressed = {2, 8, 8, 3, 2, 5, 2};
        SList numList = new SList();
        SList expected = new SList();

        for(int i: numbersToAdd) {
            numList.addFirst(i);
        }

        for(int i: compressed) {
            expected.addFirst(i);
        }
        numList.compressNodes();
        assertTrue(numList.equals(expected));
    }
}