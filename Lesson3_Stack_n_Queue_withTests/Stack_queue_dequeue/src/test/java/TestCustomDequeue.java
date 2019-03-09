import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCustomDequeue {

    CustomDequeue<Character> dequeue;
    Character expectedCharLeft;
    Character expectedCharPeekLeft;
    Character expectedCharRight;
    Character expectedCharPeekRight;
    int expectedSize = 0;
    String expectedToString = null;
    @Before
    public void init() {
        expectedCharPeekLeft = 'S';
        expectedCharPeekRight = 'n';
        expectedCharLeft = 'e';
        expectedCharRight = 'o';
        //expectedToString = "S e r ";
        //expectedToString = "e r g e y I o ";
        expectedToString = "e y ";
        expectedSize = 9;
        dequeue = new CustomDequeue<Character>(4,16);
        dequeue.insertLeft('g');
        dequeue.insertLeft('r');
        dequeue.insertLeft('e');
        dequeue.insertLeft('S');
        dequeue.insertRight('e');
        dequeue.insertRight('y');
        dequeue.insertRight('I');
        dequeue.insertRight('o');
        dequeue.insertRight('n');
        //queue.dequeue();
        //queue.dequeue();
        /*queue.enqueue('I');
        queue.enqueue('o');*/
    }

    @Test
    public void testPeekLeft() {
        Assert.assertEquals(expectedCharPeekLeft, dequeue.getLeft());
    }

    @Test
    public void testPeekRight() {
        Assert.assertEquals(expectedCharPeekRight, dequeue.getRight());
    }

    @Test
    public void testPullLeft() {
        dequeue.pullLeft();
        Assert.assertEquals(expectedCharLeft, dequeue.getLeft());
    }

    @Test
    public void testPullRight() {
        dequeue.pullRight();
        Assert.assertEquals(expectedCharRight, dequeue.getRight());
    }

    @Test
    public void testSize() {
        Assert.assertEquals(expectedSize, dequeue.size());
    }

    @Test
    public void testToString() {
        dequeue.pullLeft();
        dequeue.pullLeft();
        dequeue.pullLeft();
        dequeue.pullLeft();
        dequeue.pullRight();
        dequeue.pullRight();
        dequeue.pullRight();
        Assert.assertTrue(expectedToString.equals(dequeue.toString()));
    }

    @Test(expected = RuntimeException.class)
    public void testException() {
        for (int i = 0; i < 20; i++) {
            dequeue.pullLeft();
        }
    }


}
