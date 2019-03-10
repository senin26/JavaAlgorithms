import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCustomLinkedList {

    CustomLinkedList<Character> linkedList;

    @Before
    public void init() {
        linkedList = new CustomLinkedList();
        linkedList.addFirst('S');
        linkedList.add(1,'e');
        linkedList.add(2,'r');
        linkedList.add(3,'g');
        linkedList.add(4,'e');
        linkedList.add(5,'y');
    }

    @Test
    public void testGetFirst() {
        Character exp = 'S';
        Assert.assertEquals(exp, linkedList.getFirst());
    }

    @Test
    public void testRemoveFirst() {
        Character exp = 'S';
        Assert.assertEquals(exp, linkedList.removeFirst());
    }

    @Test
    public void testAddLast() {
        linkedList.addLast('I');
        Character exp = 'I';
        Assert.assertEquals(exp, linkedList.getLast());
    }

    @Test
    public void testRemoveLast() {
        linkedList.addLast('I');
        Character exp = 'I';
        Assert.assertEquals(exp, linkedList.removeLast());
    }

    @Test
    public void testGet() {
        Character exp = 'r';
        Assert.assertEquals(exp, linkedList.get(2));
    }

    @Test
    public void testSize() {
        int expectedSize = 6;
        Assert.assertEquals(expectedSize, linkedList.size());
    }

    @Test
    public void testToString() {
        String expectedToString = "S e r g e y ";
        Assert.assertTrue(expectedToString.equals(linkedList.toString()));
    }

    @Test
    public void testIndexOf() {
        Character testChar = 'g';
        Assert.assertEquals(3, linkedList.indexOf(testChar));
    }

    @Test(expected = RuntimeException.class)
    public void testException() {
        for (int i = 0; i < 20; i++) {
            linkedList.removeFirst();
        }
    }


}

