import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCustomQueue {

    CustomQueue<Character> queue;
    Character expectedCharPeek;
    Character expectedCharDequeue;
    int expectedSize = 0;
    String expectedToString = null;
    @Before
    public void init() {
        expectedCharPeek = 'S';
        expectedCharDequeue = 'e';
        //expectedToString = "S e r ";
        expectedToString = "e y I o n ";
        expectedSize = 3;
        queue = new CustomQueue<Character>();
        queue.enqueue('S');
        queue.enqueue('e');
        queue.enqueue('r');
        queue.enqueue('g');
        queue.enqueue('e');
        queue.enqueue('y');
        //queue.dequeue();
        //queue.dequeue();
        /*queue.enqueue('I');
        queue.enqueue('o');*/
    }

    @Test
    public void testPeek() {
        Assert.assertEquals(expectedCharPeek, queue.peek());
    }

    @Test
    public void testDequeue() {
        queue.dequeue();
        Assert.assertEquals(expectedCharDequeue, queue.dequeue());
    }

    @Test
    public void testSize() {
        Assert.assertEquals(expectedSize, queue.size());
    }

    @Test
    public void testToString() {
        for (int i = 0; i < 4; i++) {
            queue.dequeue();
        }
        queue.enqueue('I');
        queue.enqueue('o');
        queue.enqueue('n');
        Assert.assertTrue(expectedToString.equals(queue.toString()));
    }

    @Test(expected = RuntimeException.class)
    public void testException() {
        for (int i = 0; i < expectedSize+1; i++) {
            queue.dequeue();
        }
    }


}
