import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueUsingResizingArrayTest {
    
    @Test
    void testEnqueueingAnElement() {
        QueueUsingResizingArray queue = new QueueUsingResizingArray();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        assertEquals( 10, queue.dequeue());
        assertEquals( 20, queue.dequeue());
        assertEquals( 30, queue.dequeue());
    }

    @Test
    void testEnqueueResizing() {
        QueueUsingResizingArray q = new QueueUsingResizingArray();
        for(int i = 1; i <= 20; i++) {
            q.enqueue(i);
        }

        for(int i = 1; i <= 20; i++) {
            assertEquals(i, q.dequeue());
        }
    }

    @Test 
    void testSizeOfQueue() {
        QueueUsingResizingArray q = new QueueUsingResizingArray();
        for(int i = 1; i <= 20; i++) {
            q.enqueue(i);
        }

        for(int i = 1; i <= 14; i++) {
            assertEquals(i, q.dequeue());
        }
        assertEquals(6, q.Size());
    }

}
