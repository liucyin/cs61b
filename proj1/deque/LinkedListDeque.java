package deque;

import jh61b.junit.In;

public class LinkedListDeque<T> {

    private class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }

    }

    private Node sentinel;

    private int size;

    /* Creates a new LinkedListDeque with one item x.*/
    public LinkedListDeque(T x) {
        sentinel = new Node(null, null, null);
        Node newNode = new Node(sentinel, x, sentinel);
        sentinel.next = newNode;
        sentinel.prev = newNode;
        size = 1;
    }

    /* Creates an empty LinkedListDeque. */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     * Adds an item to the front of the LinkedListDeque.
     * @param item Sothing you want to add.
     */
    public void addFirst(T item) {
        sentinel.next.prev = new Node(sentinel, item, sentinel.next);
        sentinel.next = sentinel.next.prev;
        size += 1;
    }

    /**
     * Adds an item to the end of the LinkedListDeque.
     * @param item Something you want to add.
     */
    public void addLast(T item) {
        sentinel.prev.next = new Node(sentinel.prev, item, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    /**
     * Returns ture if LinkedListDeque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items in the LinkedListDeque.
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the LinkedListDeque from first to last,
     * seperated by a space.
     * Once all items have been printed,
     * print out a new line
     */
    public void printDeque() {
        Node pointer = new Node(null, null, sentinel.next);
        for (int i = 0; i < size; i++) {
            pointer = pointer.next;
            System.out.print(pointer.item + " ");
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T x = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return x;
    }

    /**
     * Removes and returns the item at the end of the deque.
     * If no such item exists, returns null.
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = null;
        size -= 1;
        return sentinel.prev.item;
    }

    /**
     * Gets the item at the given index, where 0 is the front,
     * 1 is the next item, and so forth.
     * If no such item exists, returns null.
     * Must not alter the deque!
     */
    public T get(int index) {
        Node pointer = new Node(null, null, sentinel.next);
        if (pointer.next == null || index >= size) {
            return null;
        }
        for (int i = 0; i <= index; i++) {
            pointer = pointer.next;
        }
        return pointer.item;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> deque = new LinkedListDeque<Integer>(5);

        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        System.out.println(deque.removeFirst());
        deque.printDeque();
    }

}
