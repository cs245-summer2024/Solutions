package hw1;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void testNoSquish() {
        int[] original = {1,2,3,4};
        int[] expected = {1,2,3,4};
        Main.squishArray(original);
        assertArrayEquals(original, expected);
    }

    @org.junit.jupiter.api.Test
    void testSquishArray() {
        int[] original = {1,1,2,3,3,4,4,4,5};
        int[] expected = {1,2,3,4,5,-1,-1,-1,-1};
        Main.squishArray(original);
        assertArrayEquals(original, expected);
    }

    @org.junit.jupiter.api.Test
    void testAllSquish() {
        int[] original = {3,3,3,3,3};
        int[] expected = {3,-1,-1,-1,-1};
        Main.squishArray(original);
        assertArrayEquals(original, expected);
    }

    @org.junit.jupiter.api.Test
    void testSingleCompression() {
        String decompressed = "abcd";
        String outputCompression = Main.compressString(decompressed);
        String expectedCompression = "1a1b1c1d";
        assertTrue(expectedCompression.equals(outputCompression));
    }
    @org.junit.jupiter.api.Test
    void testGeneralCompression() {
        String decompressed = "aaabbcadde";
        String outputCompression = Main.compressString(decompressed);
        String expectedCompression = "3a2b1c1a2d1e";
        assertTrue(expectedCompression.equals(outputCompression));
    }
}