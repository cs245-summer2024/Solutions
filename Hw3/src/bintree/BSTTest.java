package bintree;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.Assert.assertTrue;

class BSTTest {
    @Test // 1 point
    public void testNoOverlap(){
        int[] numbers = {25, 15, 10, 18, 6, 12, 30, 27, 40, 50, 17, 22, 41};
        BST<Integer> bstTree = new BST();
        for(int n: numbers) {
            bstTree.insert(n);
        }
        List<Integer> rangeResult = bstTree.rangeQuery(-10, 0);
        assertTrue(rangeResult.size() == 0);
    }

    @Test // 1 point
    public void testOverLapLeft(){
        int[] numbers = {25, 15, 10, 18, 6, 12, 30, 27, 40, 50, 17, 22, 41};
        int[] outputExpected = {6, 10, 12};
        Set<Integer> outputSet = new HashSet<>();
        for(int n: outputExpected){
            outputSet.add(n);
        }

        BST<Integer> bstTree = new BST();
        for(int n: numbers) {
            bstTree.insert(n);
        }

        List<Integer> rangeResult = bstTree.rangeQuery(4, 13);
        Set<Integer> rangeOutput = new HashSet<>();
        for(int n: rangeResult){
            rangeOutput.add(n);
        }
        assertTrue(rangeOutput.equals(outputSet));
    }

    @Test // 1 point
    public void testOverLapRight(){
        int[] numbers = {25, 15, 10, 18, 6, 12, 30, 27, 40, 50, 17, 22, 41};
        int[] outputExpected = {27, 41, 40, 30, 50};
        Set<Integer> outputSet = new HashSet<>();
        for(int n: outputExpected){
            outputSet.add(n);
        }

        BST<Integer> bstTree = new BST();
        for(int n: numbers) {
            bstTree.insert(n);
        }

        List<Integer> rangeResult = bstTree.rangeQuery(26, 100);
        Set<Integer> rangeOutput = new HashSet<>();
        for(int n: rangeResult){
            rangeOutput.add(n);
        }
        assertTrue(rangeOutput.equals(outputSet));
    }

    @Test // 1 point
    public void testOverLapBoth(){
        int[] numbers = {25, 15, 10, 18, 6, 12, 30, 27, 40, 50, 17, 22, 41};
        int[] outputExpected = {22, 25, 27, 30};
        Set<Integer> outputSet = new HashSet<>();
        for(int n: outputExpected){
            outputSet.add(n);
        }

        BST<Integer> bstTree = new BST();
        for(int n: numbers) {
            bstTree.insert(n);
        }

        List<Integer> rangeResult = bstTree.rangeQuery(19, 35);
        Set<Integer> rangeOutput = new HashSet<>();
        for(int n: rangeResult){
            rangeOutput.add(n);
        }
        assertTrue(rangeOutput.equals(outputSet));
    }

    @Test // 2 points (hidden test case)
    public void testOverLapBothV2(){
        int[] numbers = {25, 15, 10, 18, 6, 12, 30, 27, 40, 50, 17, 22, 41, -10};
        int[] outputExpected = {-10, 6, 10, 12, 15, 17, 18, 22, 22, 25, 27};
        Set<Integer> outputSet = new HashSet<>();
        for(int n: outputExpected){
            outputSet.add(n);
        }

        BST<Integer> bstTree = new BST();
        for(int n: numbers) {
            bstTree.insert(n);
        }

        List<Integer> rangeResult = bstTree.rangeQuery(-20, 29);
        Set<Integer> rangeOutput = new HashSet<>();
        for(int n: rangeResult){
            rangeOutput.add(n);
        }

        assertTrue(rangeOutput.equals(outputSet));
    }
}