package task_1;

import java.util.Iterator;

public class UserDoubleEndedQueue <T> implements Iterable  <T> {
    // A linked list to store the elements of the double-ended queue
    private UserLinkedList<T> list;

    // Constructor to initialize the double-ended queue
    public UserDoubleEndedQueue() {
        list = new UserLinkedList<>();
    }

    // Add an element to the front of the double-ended queue
    public void addFirst(T data) {
        list.addFirst(data);
    }

    // Add an element to the end of the double-ended queue
    public void addLast(T data) {
        list.addLast(data);
    }

    // Get the current size of the double-ended queue
    public int size() {
        return list.size();
    }

    // Check if the double-ended queue is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Remove the first element from the double-ended queue
    public void removeFirst() {
        list.removeFirst();
    }

    // Remove the last element from the double-ended queue
    public void removeLast() {
        list.removeLast();
    }

    // Override the iterator method to provide an iterator for the double-ended queue
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}