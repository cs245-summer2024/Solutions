package lists;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MaxStackTest {

    @org.junit.jupiter.api.Test // 1 point
    void testAscendingOrder() {
        int[] values = {9, 14, 15, 21, 45, 56, 67, 85, 94, 95, 96};
        MaxStack<Integer> stack = new MaxStack<>();
        for(int v: values) {
            stack.push(v);
        }
        assertTrue(stack.pop() == 96);

    }

    @org.junit.jupiter.api.Test // 1 point
    void testDescendingOrder() {
        int[] values = {100, 90, 80, 70, 55, 43, 32, 31, 30};
        int[] popValues = new int[values.length];
        MaxStack<Integer> stack = new MaxStack<>();
        for(int v: values) {
            stack.push(v);
        }
        for(int i = 0; i < values.length; i ++) {
            popValues[i] = stack.pop();
        }
        assertTrue(Arrays.equals(popValues, values));
    }

    @org.junit.jupiter.api.Test // 2 point
    void testRandomOrder() {
        int[] values = {17, 4, 9, 3, 1, 56, 56, 56, 56, 14};
        int[] expectedPopValues = {56, 56, 56, 56, 17, 14, 9, 4, 3, 1};
        int[] returnedValues = new int[values.length];
        MaxStack<Integer> stack = new MaxStack<>();
        for(int v: values) {
            stack.push(v);
        }
        for(int i = 0; i < values.length; i ++) {
            returnedValues[i] = stack.pop();
        }

        assertTrue(Arrays.equals(returnedValues, expectedPopValues));
    }
}