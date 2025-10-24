import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackUsingResizingArrayTest {

    @Test
    void testPushAndPopSingleElement() {
        StackUsingResizingArray stack = new StackUsingResizingArray();
        stack.push(10);
        assertEquals(1, stack.length());
        int popped = stack.pop();
        assertEquals(10, popped);
        assertEquals(0, stack.length());
    }

    @Test
    void testPushMultipleElements() {
        StackUsingResizingArray stack = new StackUsingResizingArray();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
            assertEquals(i, stack.length());
        }
        for (int i = 5; i >= 1; i--) {
            assertEquals(i, stack.pop());
            assertEquals(i - 1, stack.length());
        }
    }

    @Test
    void testResizingOnPush() {
        StackUsingResizingArray stack = new StackUsingResizingArray();
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }
        assertEquals(20, stack.length());
        for (int i = 19; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }
        assertEquals(0, stack.length());
    }

    @Test
    void testResizingOnPop() {
        StackUsingResizingArray stack = new StackUsingResizingArray();
        for (int i = 0; i < 16; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 13; i++) {
            stack.pop();
        }
        assertEquals(3, stack.length());
    }

    @Test
    void testPopFromEmptyStackThrowsException() {
        StackUsingResizingArray stack = new StackUsingResizingArray();
        assertThrows(NullPointerException.class, stack::pop);
    }
}