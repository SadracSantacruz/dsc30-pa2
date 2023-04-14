import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import java.util.NoSuchElementException;

class CharQueueTest {


    static CharQueue testQue;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        testQue = new CharQueue();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void isEmptyTest() {
        testQue.clear();
        assertTrue(testQue.isEmpty());
        testQue.enqueue('I');
        assertFalse(testQue.isEmpty());
        testQue.dequeue();
        assertTrue(testQue.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void sizeTest() {
        testQue.clear();
        assertEquals(0, testQue.size());

        testQue.enqueue('H');
        testQue.enqueue('I');
        assertEquals(2, testQue.size());

        testQue.dequeue();
        assertEquals(1, testQue.size());
    }

    @org.junit.jupiter.api.Test
    void clearTest() {
        testQue.clear();
        assertEquals(0, testQue.size());

        testQue.enqueue('H');
        testQue.enqueue('I');
        testQue.clear();
        assertEquals(0, testQue.size());

        testQue.clear();
        assertEquals(0, testQue.size());
    }
    @org.junit.jupiter.api.Test
    void enqueueTest() {
        testQue.clear();
        testQue.enqueue('H');
        assertEquals('H', testQue.peek());

        testQue.enqueue('I');
        assertEquals('H',testQue.peek());

        testQue.dequeue();
        assertEquals('I', testQue.peek());
    }

    @org.junit.jupiter.api.Test
    void peekTest() {
        testQue.clear();
        testQue.enqueue('H');
        testQue.enqueue('I');
        assertEquals('H', testQue.peek());
        testQue.dequeue();
        assertEquals('I',testQue.peek());
        testQue.dequeue();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            char error = testQue.peek();
        });

    }

    @org.junit.jupiter.api.Test
    void dequeue() {
    }
}