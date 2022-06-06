public class LinkedListDeque<T> implements Deque<T> {
    private class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(Node prev, T item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    public LinkedListDeque(LinkedListDeque queue) {
        this();
        // need more code later
        int i = 0;
        Node ptr = queue.sentinel.next;
        while (i < queue.size()) {
            addLast(ptr.item);
            ptr = ptr.next;
            i += 1;
        }
    }

    @Override
    public void addFirst(T item) {
        Node ptr = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = ptr;
        sentinel.next = ptr;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        Node ptr = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = ptr;
        sentinel.prev = ptr;
        size += 1;
    }

/*    public boolean isEmpty() {
        return size == 0;
    }*/

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node ptr = sentinel.next;
        ptr.next.prev = sentinel;
        sentinel.next = ptr.next;
        size -= 1;
        return ptr.item;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node ptr = sentinel.prev;
        ptr.prev.next = sentinel;
        sentinel.prev = ptr.prev;
        size -= 1;
        return ptr.item;
    }

    @Override
    public T get(int index) {
        /* 0 <= index <= size - 1 */
        if (index < 0 || index > size() - 1) {
            return null;
        }
        int i;
        Node ptr;
        if (index < size() / 2) {
            i = 0;
            ptr = sentinel.next;
            while (i < index) {
                ptr = ptr.next;
                i += 1;
            }
        } else {
            i = size - 1;
            ptr = sentinel.prev;
            while(i > index) {
                ptr = ptr.prev;
                i -= 1;
            }
        }
        return ptr.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        String str = "";
        Node ptr = sentinel.next;
        int i = 0;
        while (i < size - 1) {
            str += ptr.item + " --> ";
            ptr = ptr.next;
            i += 1;
        }
        if (i < size) {
            str += ptr.item;
        }
        System.out.println(str);
    }
}
