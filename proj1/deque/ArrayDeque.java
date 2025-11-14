package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty array deque. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }
    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    private void growIfFull() {
        if (size == items.length) {
            resize(items.length * 2);
        }
    }

    private void shrinkIfSparse() {
        if (size < items.length / 4 && items.length >= 16) {
            resize(items.length / 2);
        }
    }

    private void resize(int newCap) {
        T[] a = (T[]) new Object[newCap];
        int first = plusOne(nextFirst);
        for (int k = 0; k < size; k++) {
            int oldIdx = (first + k) % items.length;
            a[k] = items[oldIdx];
        }
        items = a;
        nextFirst = newCap - 1;
        nextLast = size;
    }

    /**
     * Adds an item of type T to the front of the deque.
     * You can assume that item is never null.
     * @param item Something you want to add.
     */
    public void addFirst(T item) {
        growIfFull();
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    /**
     * Adds an item of type T to the back of the deque.
     * You can assume that item is never null.
     */
    public void addLast(T item) {
        growIfFull();
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        if (size == 0) return null;
        nextFirst = plusOne(nextFirst);
        T x = items[nextFirst];  
        items[nextFirst] = null;
        size--;
        shrinkIfSparse();
        return x;
    }

    /**
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        if (size == 0) return null;
        nextLast = minusOne(nextLast);
        T x = items[nextLast];
        items[nextLast] = null;
        size--;
        shrinkIfSparse();
        return x;
    }

    /**
     * Gets the item at the given index.
     * @param index The index of the item.
     * @return The item at the given index.
     */
    public T get(int index) {
        if (index < 0 || index >= size) return null;
        int first = plusOne(nextFirst);
        int phys = (first + index) % items.length;
        return items[phys];
    }

    /** 
     * Print the items of ArrayDeque. 
     */
    public void printDeque() {
        int first = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            int phys = (first + i) % items.length;
            System.out.print(items[phys] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque();
        deque.addFirst(1);
        System.out.println(deque.items.length);
    }
}
