package lists;
import static org.junit.jupiter.api.Assertions.*;
public class PromotionQueueTest {
    @org.junit.jupiter.api.Test // 1 point
    void testPromoteExistingHead() {
        int[] values = {14, 56, 9, 17, 17, 3, 3, 2};
        String expectedRepr = "ID:1-14, ID:2-56, ID:3-9, ID:4-17, ID:5-17, ID:6-3, ID:7-3, ID:8-2";
        PromotionQueue<Integer> pq = new PromotionQueue<>();
        for(int v: values) {
            pq.addBack(v);
        }
        pq.promote(0);
        assertTrue(pq.toString().equals(expectedRepr));
    }

    @org.junit.jupiter.api.Test // 1 point
    void testPromoteToHead() {
        int[] values = {14, 56, 9, 17, 17, 3, 3, 2};
        String expectedRepr = "ID:2-56, ID:1-14, ID:3-9, ID:4-17, ID:5-17, ID:6-3, ID:7-3, ID:8-2";
        PromotionQueue<Integer> pq = new PromotionQueue<>();
        for(int v: values) {
            pq.addBack(v);
        }
        pq.promote(1);
        assertTrue(pq.toString().equals(expectedRepr));
    }

    @org.junit.jupiter.api.Test // 2 point
    void testMultiplePromotions() {
        int[] values = {14, 56, 9, 17, 17, 3, 3, 2};
        String expectedRepr = "ID:1-14, ID:2-56, ID:6-3, ID:3-9, ID:4-17, ID:5-17, ID:7-3, ID:8-2";
        PromotionQueue<Integer> pq = new PromotionQueue<>();
        for(int v: values) {
            pq.addBack(v);
        }
        pq.promote(5);
        pq.promote(4);
        pq.promote(3);
        assertTrue(pq.toString().equals(expectedRepr));
    }

    @org.junit.jupiter.api.Test // 1 point
    void testDemoteExistingTail() {
        int[] values = {14, 56, 9, 17, 17, 3, 3, 2};
        String expectedRepr = "ID:1-14, ID:2-56, ID:3-9, ID:4-17, ID:5-17, ID:6-3, ID:7-3, ID:8-2";
        PromotionQueue<Integer> pq = new PromotionQueue<>();
        for(int v: values) {
            pq.addBack(v);
        }
        pq.demote(7);
        assertTrue(pq.toString().equals(expectedRepr));
    }

    @org.junit.jupiter.api.Test // 1 point
    void testDemoteToTail() {
        int[] values = {14, 56, 9, 17, 17, 3, 3, 2};
        String expectedRepr = "ID:1-14, ID:2-56, ID:3-9, ID:4-17, ID:5-17, ID:6-3, ID:8-2, ID:7-3";
        PromotionQueue<Integer> pq = new PromotionQueue<>();
        for(int v: values) {
            pq.addBack(v);
        }
        pq.demote(6);
        assertTrue(pq.toString().equals(expectedRepr));
    }

    @org.junit.jupiter.api.Test // 2 point
    void testMultipleDemotions() {
        int[] values = {14, 56, 9, 17, 17, 3, 3, 2};
        String expectedRepr = "ID:1-14, ID:2-56, ID:3-9, ID:5-17, ID:6-3, ID:7-3, ID:4-17, ID:8-2";
        PromotionQueue<Integer> pq = new PromotionQueue<>();
        for(int v: values) {
            pq.addBack(v);
        }
        pq.demote(3);
        pq.demote(4);
        pq.demote(5);
        assertTrue(pq.toString().equals(expectedRepr));
    }

    @org.junit.jupiter.api.Test // 2 point
    void hiddenPromotionQueueTest() {
        int[] values = {14, 56, 9, 17, 17, 3, 3, 2};
        String expectedRepr = "ID:1-14, ID:2-56, ID:3-9, ID:4-17, ID:5-17, ID:6-3, ID:7-3, ID:8-2";
        PromotionQueue<Integer> pq = new PromotionQueue<>();
        for(int v: values) {
            pq.addBack(v);
        }

        pq.demote(3);
        pq.demote(4);
        pq.demote(5);

        pq.promote(6);
        pq.promote(5);
        pq.promote(4);
        assertTrue(pq.toString().equals(expectedRepr));
    }
}
