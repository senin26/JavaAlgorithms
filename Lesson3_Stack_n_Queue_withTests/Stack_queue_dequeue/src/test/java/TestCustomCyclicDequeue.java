import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCustomCyclicDequeue {

    CustomCyclicDequeue<Character> dequeue;
    @Before
    public void init() {
        dequeue = new CustomCyclicDequeue<Character>(6,32);
        dequeue.insertLeft('s');
        dequeue.insertLeft('i');
        dequeue.insertRight('F');
        dequeue.insertLeft('e');
        dequeue.insertRight('*');
        dequeue.insertLeft('u');
        dequeue.insertRight('c');
        dequeue.insertLeft('e');
        dequeue.insertRight('k');
        dequeue.insertLeft('u');
        dequeue.insertRight('i');

        dequeue.insertRight('n');
        dequeue.insertRight('g');
        dequeue.insertLeft('q');
        dequeue.insertRight('G');
        dequeue.insertRight('r');
        dequeue.insertRight('e');
        dequeue.insertLeft('e');
        dequeue.insertRight('a');
        dequeue.insertLeft('D');
        dequeue.insertRight('t');

    }

    @Test
    public void testPeekLeft() {
        dequeue.pullLeft();
        dequeue.pullLeft();
        dequeue.pullLeft();
        dequeue.insertLeft('q');
        Character expected = 'q';
        Assert.assertEquals(expected, dequeue.getLeft());
    }

    @Test
    public void testPeekRight() {
        System.out.println();
        dequeue.pullRight();
        dequeue.pullRight();
        dequeue.insertRight('a');
        Character expected = 'a';
        Assert.assertEquals(expected, dequeue.getRight());
    }

    @Test
    public void testPullLeft() {
        dequeue.pullLeft();
        dequeue.pullLeft();
        dequeue.pullLeft();
        Character expected = 'u';
        Assert.assertEquals(expected, dequeue.getLeft());
    }

    @Test
    public void testPullRight() {
        dequeue.pullRight();
        dequeue.pullRight();
        dequeue.pullRight();
        Character expected = 'r';
        Assert.assertEquals(expected, dequeue.getRight());
    }

    @Test
    public void testSize() {
        int expectedSize = 21;
        Assert.assertEquals(expectedSize, dequeue.size());
    }

    @Test
    public void testToString() {
        String expectedToString = "D e q u e u e i s F * c k i n g G r e a t ";
        System.out.println(dequeue.toString());
        Assert.assertTrue(expectedToString.equals(dequeue.toString()));
    }

    @Test
    public void testToString2() {
        dequeue.pullRight();
        dequeue.pullRight();
        dequeue.insertRight('a');
        System.out.println(dequeue.toString());
        String exp = "D e q u e u e i s F * c k i n g G r e a ";
        Assert.assertTrue(exp.equals(dequeue.toString()));
    }

    @Test(expected = RuntimeException.class)
    public void testException() {
        for (int i = 0; i < 50; i++) {
            dequeue.pullLeft();
        }
    }


}
