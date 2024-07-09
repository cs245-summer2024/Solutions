package misc;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class InterleaveIteratorTest {

    //Q3 Tests
    @org.junit.jupiter.api.Test // 1 point
    void testIteratorSameLength() {
        String expectedResult = "cdbaoetge";
        String[] words = {"cat", "dog", "bee"};
        List<String> iteratorStrings = new ArrayList<>();

        for(String s: words) {
            iteratorStrings.add(s);
        }
        InterLeaveIterator iterator = new InterLeaveIterator(iteratorStrings);
        StringBuilder iteratorOutput = new StringBuilder();
        while(iterator.hasNext()) {
            iteratorOutput.append(iterator.next());
        }
        assertTrue(iteratorOutput.toString().equals(expectedResult));
    }

    @org.junit.jupiter.api.Test // 1 point
    void testIteratorEmptyStrings() {
        String expectedResult = "";
        String[] words = {"", "", "", "", ""};
        List<String> iteratorStrings = new ArrayList<>();

        for(String s: words) {
            iteratorStrings.add(s);
        }
        InterLeaveIterator iterator = new InterLeaveIterator(iteratorStrings);
        StringBuilder iteratorOutput = new StringBuilder();
        while(iterator.hasNext()) {
            iteratorOutput.append(iterator.next());
        }
        assertTrue(iteratorOutput.toString().equals(expectedResult));
    }

    @org.junit.jupiter.api.Test // 2 point
    void testIteratorSameLengthV2() {
        String expectedResult = "cdbaoetgecdbaoetge";
        String[] words = {"", "catcat", "", "dogdog", "", "beebee"};
        List<String> iteratorStrings = new ArrayList<>();

        for(String s: words) {
            iteratorStrings.add(s);
        }
        InterLeaveIterator iterator = new InterLeaveIterator(iteratorStrings);
        StringBuilder iteratorOutput = new StringBuilder();
        while(iterator.hasNext()) {
            iteratorOutput.append(iterator.next());
        }
        assertTrue(iteratorOutput.toString().equals(expectedResult));
    }

    @org.junit.jupiter.api.Test // 3 points
    void testIteratorDifferentLengths() {
        String expectedResult = "1whb2oeenladlteosrful";
        String[] words = {"", "12", "", "wonderful", "", "hello", "beats"};
        List<String> iteratorStrings = new ArrayList<>();

        for(String s: words) {
            iteratorStrings.add(s);
        }
        InterLeaveIterator iterator = new InterLeaveIterator(iteratorStrings);
        StringBuilder iteratorOutput = new StringBuilder();
        while(iterator.hasNext()) {
            iteratorOutput.append(iterator.next());
        }
        assertTrue(iteratorOutput.toString().equals(expectedResult));
    }

    @org.junit.jupiter.api.Test // 3 points
    void hiddenIteratorTest() {
        String expectedResult = "a1bdQ2ce3f4";
        String[] words = {"a", "1234", "", "bc", "", "def", "Q"};
        List<String> iteratorStrings = new ArrayList<>();

        for(String s: words) {
            iteratorStrings.add(s);
        }
        InterLeaveIterator iterator = new InterLeaveIterator(iteratorStrings);
        StringBuilder iteratorOutput = new StringBuilder();
        while(iterator.hasNext()) {
            iteratorOutput.append(iterator.next());
        }
        assertTrue(iteratorOutput.toString().equals(expectedResult));
    }
}