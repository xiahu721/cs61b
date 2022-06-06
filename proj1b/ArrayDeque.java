public class ArrayDeque<T> implements Deque<T> {
    private static final int INITIAL_ARRAY_SIZE = 10;

    private T[] items;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_ARRAY_SIZE];
        size = 0;
    }
    public ArrayDeque(ArrayDeque queue) {
        items = (T[]) new Object[queue.size()];
        size = queue.size();
        System.arraycopy(queue.items, 0, items, 0, size);
    }

    public static int getInitialArraySize() {
        return INITIAL_ARRAY_SIZE;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void addFirst(T e) {
        size += 1;
        // expand array when array is full
        if (size > items.length) {
            T[] ptr = (T[]) new Object[2 * items.length];
            System.arraycopy(items, 0, ptr, 0, items.length);
            items = ptr;
        }

        for (int i = size - 1; i >= 1; i -= 1) {
            items[i] = items[i-1];
        }
        items[0] = e;
    }

    @Override
    public void addLast(T e) {
        size += 1;
        // expand array when array is full
        if (size > items.length) {
            T[] ptr = (T[]) new Object[2 * items.length];
            System.arraycopy(items, 0, ptr, 0, items.length);
            items = ptr;
        }
        items[size - 1] = e;
    }

/*    public boolean isEmpty() {
        return size == 0;
    }*/

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T e = items[0];
        for (int i = 0; i < size - 1; i += 1) {
            items[i] = items[i + 1];
        }
        items[size - 1] = null;

        size -= 1;
        /* shrink array when size is a quarter of the array length */
        if (size < items.length / 4) {
            T[] ptr = (T[]) new Object[items.length / 2];
            System.arraycopy(items, 0, ptr, 0, size);
            items = ptr;
        }
        return e;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T e = items[size - 1];
        items[size - 1] = null;
        size -= 1;
        /* shrink array when size is a quarter of the array length */
        if (size < items.length / 4) {
            T[] ptr = (T[]) new Object[items.length / 2];
            System.arraycopy(items, 0, ptr, 0, size);
            items = ptr;
        }
        return e;
    }

    @Override
    public T get(int index) {
        // 0 <= index <= size - 1
        if (index < 0 || index >= size) {
            return null;
        }

        return items[index];
    }

    @Override
    public int size() {
        return size;
    }

    public int length() {
        return items.length;
    }

    @Override
    public void printDeque() {
        String res = "[";
        for (int i = 0; i < size - 1; i += 1) {
            res += items[i] + ", ";
        }
        if (size > 0) {
            res += items[size - 1];
        }
        res += "]";
        System.out.println(res);
    }
}

