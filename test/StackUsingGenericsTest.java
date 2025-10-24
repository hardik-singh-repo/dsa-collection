import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StackUsingGenericsTest {
    
    @Test
    void testPushMultipleIntegers() {
        Stack<Integer> s = new Stack<Integer>();
        s.push(10);
        s.push(20);
        s.push(30);
        assertEquals(30, s.pop());
        assertEquals(20, s.pop());
        assertEquals(10, s.pop());
    }

    @Test
    void pushMultipleStrings() {
        Stack<String> s = new Stack<>();
        s.push("cow");
        s.push("cat");
        s.push("goat");
        assertEquals("goat", s.pop());
    }

    @Test
    void stackShouldBeIterable() {
        Stack<String> s = new Stack<>();
        s.push("This");
        s.push("is");
        s.push("a cow");

        String output = "";
        for(String a : s) {
            output += a + '-';
        }
        assertEquals("a cow-is-This-", output);
    }
}
