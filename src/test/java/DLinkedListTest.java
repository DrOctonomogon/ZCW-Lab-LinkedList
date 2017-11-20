
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DLinkedListTest {

//    DLinkedList list = new DLinkedList();
//    DNode node1 = new DNode(null, null, 10);
//    DNode node2 = new DNode(null, null, 100);
//    DNode node3 = new DNode(null, null, 1000);

    DLinkedList<Integer> linkedList;

    @Before
    public void setUp() {
        linkedList = new DLinkedList<>();
    }

    @Test
    public void add() throws Exception {
        linkedList.add(1);

        int expectedValue = 1;
        int actualValue =  linkedList.get(0);
        Assert.assertEquals(expectedValue,actualValue);
    }

    @Test
    public void size() throws Exception {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        int expected = 3;
        int actual = linkedList.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove() throws Exception {
        linkedList.add(1);

        linkedList.remove(0);

        int expected = 0;
        int actual = linkedList.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void find() throws Exception {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(5);
//        linkedList.add(4);

        int expected = 2;
        int actual = linkedList.find(5);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void contains() throws Exception {
//        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(5);

        Assert.assertTrue(linkedList.contains(2));

//        boolean expected = true;
//        boolean actual = linkedList.contains(2);
//        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get() throws Exception {

        linkedList.add(1);
        linkedList.add(4);
        linkedList.add(2);

        int expected = 4;
        int actual = linkedList.get(1);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void copy() throws Exception {

        linkedList.add(1);
        linkedList.add(4);
        linkedList.add(2);

        DLinkedList<Integer> listCopy = linkedList.copy();

        int expected = 7;

        int actual = listCopy.get(0) + listCopy.get(1) + listCopy.get(2);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void sort() throws Exception {

        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(4);

        linkedList.sort();

        String expected = "1 2 3 4";
        String actual = linkedList.get(0) + " " + linkedList.get(1) + " " + linkedList.get(2) + " " + linkedList.get(3);

        Assert.assertEquals(expected, actual);

    }


}
