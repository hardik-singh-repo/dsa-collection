import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackUsingLinkedListTest {

    @Test
    void testPushSingleElement() {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(10);
        assertEquals(1, stack.length());
    }

    @Test
    void testPushMultipleElements() {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(5);
        stack.push(15);
        stack.push(25);
        assertEquals(3, stack.length());
    }

    @Test
    void testPushOrder() {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    void testPopSingleElement() {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(42);
        int popped = stack.pop();
        assertEquals(42, popped);
        assertEquals(0, stack.length());
    }

    @Test
    void testPopMultipleElements() {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(7);
        stack.push(8);
        stack.push(9);
        assertEquals(9, stack.pop());
        assertEquals(8, stack.pop());
        assertEquals(7, stack.pop());
        assertEquals(0, stack.length());
    }

    @Test
    void testPopOnEmptyStackThrowsException() {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        assertThrows(java.util.NoSuchElementException.class, stack::pop);
    }
}