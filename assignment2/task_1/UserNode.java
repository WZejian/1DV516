package task_1;

public class UserNode <T>  {
    private T data; // Data stored in the node
    private UserNode<T> next; // Reference to the next node
    private UserNode<T> previous;// Reference to the previous node


    // Constructor with data, next, and previous references
    public UserNode(T data, UserNode<T> next, UserNode<T> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    // Constructor with data only
    public UserNode(T data) {
        this.data = data;
    }

    // Getter for data
    public T getData() {
        return data;
    }

    // Setter for data
    public void setData(T data) {
        this.data = data;
    }

    // Getter for the next node reference
    public UserNode<T> getNext() {
        return next;
    }

    // Setter for the next node reference
    public void setNext(UserNode<T> next) {
        this.next = next;
    }

    // Getter for the previous node reference
    public UserNode<T> getPrevious() {
        return previous;
    }

    // Setter for the previous node reference
    public void setPrevious(UserNode<T> previous) {
        this.previous = previous;
    }
}
