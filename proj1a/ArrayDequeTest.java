import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayDequeTest {

    @Test
    public void testAddRemove() {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addFirst(1);
        arr.addFirst(2);
        arr.addLast(3);
        arr.addLast(4);
        assertEquals(4, arr.size());
        assertEquals(Integer.valueOf(2), arr.get(0));
        assertEquals(Integer.valueOf(1), arr.get(1));
        assertEquals(Integer.valueOf(3), arr.get(2));
        assertEquals(Integer.valueOf(4), arr.get(3));
        arr.printDeque();

        // test remove
        int n = arr.removeFirst();
        assertEquals(2, n);
        assertEquals(3, arr.size());

        n = arr.removeLast();
        assertEquals(4, n);
        assertEquals(2, arr.size());
        assertEquals(Integer.valueOf(1), arr.get(0));
        assertEquals(Integer.valueOf(3), arr.get(1));

        arr.removeFirst();
        arr.removeLast();
        assertTrue(arr.isEmpty());
        arr.printDeque();

        // test resizing
        arr.addFirst(1);
        arr.addFirst(2);
        arr.addLast(3);
        assertEquals(4, arr.length());
        arr.addLast(4);
        arr.addFirst(1);
        assertEquals(8, arr.length());
        arr.addFirst(2);
        arr.addLast(3);
        arr.addLast(4);
        arr.addFirst(1);
        arr.addFirst(2);
        arr.addLast(3);
        arr.addLast(4);
        arr.addFirst(1);
        arr.addFirst(2);
        arr.addLast(3);
        arr.addLast(4);
        assertEquals(16, arr.size());
        assertEquals(16, arr.length());

        arr.removeFirst();
        arr.removeLast();
        arr.removeFirst();
        arr.removeLast();
        arr.removeFirst();
        arr.removeLast();
        assertEquals(16, arr.length());
        arr.removeFirst();
        arr.removeLast();
        arr.removeFirst();
        arr.removeLast();
        arr.removeFirst();
        arr.removeLast();
        assertEquals(4, arr.size());
        assertEquals(16, arr.length());
        arr.removeLast();
        assertEquals(8, arr.length());

    }

    @Test
    public void testCopyConstructor(){
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addLast(1);
        arr.addLast(2);
        arr.addFirst(3);
        arr.printDeque();
        ArrayDeque<Integer> newArr = new ArrayDeque<>(arr);
        assertEquals(3, newArr.size());
        assertEquals(Integer.valueOf(3), newArr.get(0));
        assertEquals(Integer.valueOf(1), newArr.get(1));
        assertEquals(Integer.valueOf(2), newArr.get(2));
        newArr.printDeque();
    }
}
