package task_1;

import java.util.Iterator;

public class UserLinkedList<T> implements Iterable <T> {
    private UserNode<T> head; // Reference to the first node in the linked list
    private UserNode<T> tail; // Reference to the last node in the linked list
    private int count;       // Number of elements in the linked list


    /**
     * Add a new node with data to the beginning of the linked list
     * @param data
     */

    public void addFirst(T data){
        UserNode <T> p = new UserNode<>(data,head, null);
        if (head != null ){
            head.setPrevious(p);
        }
        head = p;
        if ( tail==null){
            tail = p;
        }
        count ++;
    }

    /**
     * Add a new node with data to the end of the linked list
     * @param data
     */

    public void addLast(T data){
        UserNode <T> p = new UserNode<>(data, null,tail);
        if (tail != null ){
            tail.setNext(p);
        }
        tail = p;
        if ( head==null){
            head = p;
        }
        count ++;
    }

    /**
     * Get the number of elements in the linked list
     * @return count
     */
    public int size(){
        return count;
    }

    /**
     *  Check if the linked list is empty
     * @return
     */

    public boolean isEmpty(){
        return count ==0;

    }

    /**
     * Remove the first element from the linked list
     */
    public void removeFirst(){
        if (isEmpty()){
            throw new RuntimeException("The linked list is empty");
        }
        else{
            head= head.getNext();
            if (head!=null){
                head.setPrevious(null);

            }
            else {
                tail = null;
            }
        }
        count --;
    }

    /**
     * Remove the last element from the linked list
     */
    public void removeLast(){
        if (isEmpty()){
            throw new RuntimeException("The linked list is empty");
        }
        else{
            tail= tail.getPrevious();
            if (tail!=null){
                tail.setNext(null);

            }
            else {
                head = null;
            }
        }
        count --;
    }


    /**
     * Create and return an iterator for the linked list
     * @return
     */

    @Override
    public Iterator<T> iterator() {
        return new UserIterator<>(head);
    }
}
