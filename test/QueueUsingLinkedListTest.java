import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueUsingLinkedListTest {

    @Test
    void testIsEmptyInitially() {
        QueueUsingLinkedList q = new QueueUsingLinkedList();
        assertTrue(q.isEmpty());
    }

    @Test
    void testEnqueueDequeueOrder() {
        QueueUsingLinkedList q = new QueueUsingLinkedList();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        assertFalse(q.isEmpty());
        assertEquals(1, q.dequeue());
        assertEquals(2, q.dequeue());
        assertEquals(3, q.dequeue());
        assertTrue(q.isEmpty());
    }

    @Test
    void testInterleavedOperations() {
        QueueUsingLinkedList q = new QueueUsingLinkedList();
        q.enqueue(10);
        assertEquals(10, q.dequeue());
        assertTrue(q.isEmpty());

        q.enqueue(20);
        q.enqueue(30);
        assertEquals(20, q.dequeue());
        assertFalse(q.isEmpty());
        assertEquals(30, q.dequeue());
        assertTrue(q.isEmpty());
    }

    @Test
    void testDequeueOnEmptyThrows() {
        QueueUsingLinkedList q = new QueueUsingLinkedList();
        q.dequeue(); // should throw NullPointerException because queue is empty
    }
}