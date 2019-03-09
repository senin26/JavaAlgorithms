import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCustomStack {

    CustomStack<Character> stack;
    Character expectedChar;
    int expectedSize = 0;
    String expectedToString = null;
    @Before
    public void init() {
        expectedChar = 'o';
        expectedToString = "r e S ";
        expectedSize = 0;
        stack = new CustomStack();
        stack.push('S');
        stack.push('e');
        stack.push('r');
        stack.pop();
        stack.pop();
        stack.pop();
        /*stack.push('I');
        stack.push('o');*/
    }

    @Test
    public void testPeek() {
        Assert.assertEquals(expectedChar, stack.peek());
    }

    @Test
    public void testSize() {
        Assert.assertEquals(expectedSize, stack.size());
    }

    @Test
    public void testToString() {
        Assert.assertTrue(expectedToString.equals(stack.toString()));
    }

    @Test(expected = RuntimeException.class)
    public void testException() {
        stack.pop();
    }


}
