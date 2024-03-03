package task_1;

import java.util.Iterator;

public class UserIterator <T> implements Iterator <T>  {

    private UserNode <T> current;// Current node in the iteration

    public UserIterator(UserNode<T> current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {

        return current !=null;// Check if there's a next element in the iteration
    }

    @Override
    public T next() {
       T data = current.getData(); // Get the data of the current node
       current = current.getNext(); // Move to the next node in the iteration
       return data;// Return the data of the current node
    }
}
