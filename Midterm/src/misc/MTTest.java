package misc;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MTTest {

    //Q1 Tests
    @org.junit.jupiter.api.Test // 1 point
    void testReachForward() {
        String instructions = "FFF";
        assertTrue(MT.canReach(instructions, 7));
        assertFalse(MT.canReach(instructions, 8));
    }

    @org.junit.jupiter.api.Test // 1 point
    void testReachBackward() {
        String instructions = "RRR";
        assertTrue(MT.canReach(instructions, -7));
        assertFalse(MT.canReach(instructions, -8));
    }

    @org.junit.jupiter.api.Test // 1 point
    void testMixedInstructions() {
        String instructions = "RFFFRR";
        assertTrue(MT.canReach(instructions, 3));
        assertFalse(MT.canReach(instructions, 63));
        assertFalse(MT.canReach(instructions, -63));
    }

    @org.junit.jupiter.api.Test // 1 point
    void testSameSpot() {
        String instructions = "RRRFFFRRRFFFRFRFRFRFRFRFRFRFRFRFRFRFRFRF";
        assertFalse(MT.canReach(instructions, 1));
        assertTrue(MT.canReach(instructions, 0));
    }

    // Q2 Tests
    @org.junit.jupiter.api.Test // 1 points
    void testNoMerge() {
        int[][] board = {{-1, -1, -1, -1},
                         {-1,  4,  2,  -1},
                         {-1,  8,  4, 2}};

        int[][] expected = {{-1,  4,   2,   2},
                            {-1,  8,   4,  -1},
                            {-1,  -1, -1,  -1}};
        MT.tilt(board);
        assertTrue(Arrays.deepEquals(board, expected));
    }

    @org.junit.jupiter.api.Test // 2 point
    void testSingleMerge() {
        int[][] board = {{-1, -1,  4,  8},
                         {2,   4,  4,  2},
                         {2,   8,  2,  8},
                         {-1,  8,  2,  2},
                         };

        int[][] expected = {{ 4,    4,   8,  8},
                            {-1,   16,   4,  2},
                            {-1,   -1,  -1,  8},
                            {-1,   -1,  -1,  2},
                           };
        MT.tilt(board);
        assertTrue(Arrays.deepEquals(board, expected));
    }

    @org.junit.jupiter.api.Test // 3 point
    void testLeadingMerge() {
        int[][] board = {{4,   4,  -1,  8},
                         {4,   4,  -1,  2},
                         {4,   -1,  4,  2},
                         {-1,   4,  4,  2},

        };

        int[][] expected = {{8,   8,   8,  8},
                            {4,   4,  -1,  4},
                            {-1,  -1, -1,  2},
                            {-1,  -1, -1, -1},

        };
        MT.tilt(board);
        assertTrue(Arrays.deepEquals(board, expected));
    }

    @org.junit.jupiter.api.Test // 3 point
    void testNoRecursiveMerge() {
        int[][] board = {{4,  2,  8},
                         {2,  8, -1},
                         {2,  4,  8},
                         {-1, 4, 16},

        };

        int[][] expected = {{4,  2,  16},
                            {4,  8,  16},
                            {-1, 8,  -1},
                            {-1, -1, -1},

        };
        MT.tilt(board);
        assertTrue(Arrays.deepEquals(board, expected));
    }

    @org.junit.jupiter.api.Test // 6 point
    void hiddenTestTiltMethod() {
        int[][] board = {{8,   2,   4,  16, -1, 2},
                         {4,   4,   4,   8, -1, 4},
                         {4,  -1,   4,  -1,  2, 8},
                         {2,  -1,   4,   8, -1, 16},
                         {2,  -1,   4,   8,  8, 32},

        };

        int[][] expected = {{8,   2,   8,  16,  2, 2},
                            {8,   4,   8,  16,  8, 4},
                            {4,  -1,   4,   8, -1, 8},
                            {-1,  -1, -1,  -1, -1, 16},
                            {-1,  -1, -1,  -1, -1, 32},

        };
        MT.tilt(board);
        assertTrue(Arrays.deepEquals(board, expected));
    }


    /*
        Q4 Test Cases
     */
    @org.junit.jupiter.api.Test // 1 point
    void testSingleDigit() {
        int[] A = {0, 4}; // 4
        int[] B = {5}; // 5
        int[] C = {9};
        assertTrue(MT.correctSum(A, B, C));
    }

    @org.junit.jupiter.api.Test
    void testDoubleDigit() { // 1 point
        int[] A = {4, 5};
        int[] B = {3, 6};
        int[] C = {8, 1};
        int[] D = {8, 0};
        assertTrue(MT.correctSum(A, B, C));
        assertFalse(MT.correctSum(A, B, D));
    }

    @org.junit.jupiter.api.Test // 2points
    void testDifferentLength() {
        int[] A = {1, 4, 9};
        int[] B = {0, 0, 4, 9};
        int[] C = {1, 9, 8};
        int[] D = {0, 0, 1, 9, 8};
        int[] E = {0, 0, 0, 9, 8};
        assertTrue(MT.correctSum(A, B, C));
        assertTrue(MT.correctSum(A, B, D));
        assertFalse(MT.correctSum(A, B, E));
    }

    @org.junit.jupiter.api.Test // 2point
    void testCarry() {
        int[] A = {9, 9, 8, 4}; // 9984
        int[] B = {1, 8}; // 18
        int[] C = {1, 0, 0, 0, 2}; // 10,002
        int[] D = {0, 0, 0, 0, 2};
        assertTrue(MT.correctSum(A, B, C));
        assertFalse(MT.correctSum(A, B, D));
    }

    @org.junit.jupiter.api.Test // 2 point
    void hiddenCaseArraySum() {
        int[] A = {8, 6, 1, 4, 5}; //86,145
        int[] B = {0, 4, 3, 6}; // 436
        int[] C = {8, 6, 5, 8, 1};// 86,581
        int[] D = {0, 0, 0, 8, 6, 5, 8, 1};
        int[] E = {8, 6, 5, 8, 1, 8, 6, 5, 8, 1, 8, 6, 5, 8, 1};
        assertTrue(MT.correctSum(A, B, C));
        assertTrue(MT.correctSum(A, B, D));
        assertFalse(MT.correctSum(A, B, E));
    }
}