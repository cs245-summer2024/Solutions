package bintree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

class AVLTest {
    @Test // 1 point
    public void testLeftRotationSmall(){
        AVL<Integer> avlTree = new AVL<Integer>();
        BST<Integer> solution = new BST<Integer>();
        int[] avlNumbers = {20, 10, 30, 40, 50};
        int[] bstNumbers = {20, 10, 40, 30, 50};

        for(int idx = 0; idx < avlNumbers.length; idx ++) {
            avlTree.insert(avlNumbers[idx]);
            solution.insert(bstNumbers[idx]);
        }

        System.out.println("The balanced tree should look like");
        System.out.println(solution);
        System.out.println();

        System.out.println("Your tree looks like");
        System.out.println(avlTree);

        assertTrue(solution.equals(avlTree));
    }

    @Test // 1 point
    public void testRightRotationSmall(){
        AVL<Integer> avlTree = new AVL<Integer>();
        BST<Integer> solution = new BST<Integer>();
        int[] avlNumbers = {20, 10, 30, 5, 0};
        int[] bstNumbers = {20, 5, 30, 10, 0};
        for(int idx = 0; idx < avlNumbers.length; idx ++) {
            avlTree.insert(avlNumbers[idx]);
            solution.insert(bstNumbers[idx]);
        }

        System.out.println("The balanced tree should look like");
        System.out.println(solution);
        System.out.println();

        System.out.println("Your tree looks like");
        System.out.println(avlTree);

        assertTrue(solution.equals(avlTree));
    }

    @Test // 1.5 point
    public void testRightLeftRotationSmall(){
        AVL<Integer> avlTree = new AVL<>();
        BST<Integer> solution = new BST<>();
        int[] avlNumbers = {9, 8, 10, 12, 11};
        int[] bstNumbers = {9, 8, 11, 12, 10};
        for(int idx = 0; idx < avlNumbers.length; idx ++) {
            avlTree.insert(avlNumbers[idx]);
            solution.insert(bstNumbers[idx]);
        }

        System.out.println("The balanced tree should look like");
        System.out.println(solution);
        System.out.println();

        System.out.println("Your tree looks like");
        System.out.println(avlTree);

        assertTrue(solution.equals(avlTree));
    }

    @Test // 1.5 point
    public void testLeftRightRotationSmall(){
        AVL<Integer> avlTree = new AVL<>();
        BST<Integer> solution = new BST<>();
        int[] avlNumbers = {20, 10, 30, 8, 9};
        int[] bstNumbers = {20, 9, 30, 10, 8};
        for(int idx = 0; idx < avlNumbers.length; idx ++) {
            avlTree.insert(avlNumbers[idx]);
            solution.insert(bstNumbers[idx]);
        }

        System.out.println("The balanced tree should look like");
        System.out.println(solution);
        System.out.println();

        System.out.println("Your tree looks like");
        System.out.println(avlTree);

        assertTrue(solution.equals(avlTree));
    }

//    @Test // (hidden test case) 2 points
//    public void testMediumAVL(){
//        AVL<Integer> avlTree = new AVL<>();
//        AVLSolution<Integer> solution = new AVLSolution<>();
//        for(int i = 1; i <= 20; i++){
//            avlTree.insert(i);
//            solution.insert(i);
//        }
//
//        assertTrue(avlTree.toString().equals(solution.toString()));
//    }
}