package task_2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomQueue implements Iterable<Integer>  {
    private int [] array; // Array to store queue elements
    private int count;    // Current number of elements in the queue
    private Random random = new Random();

    public RandomQueue(int maxCount) {
        // Initialize the array with a maximum capacity
        array =  new int [maxCount];
    }

    /**
     * Enqueue: Add an element
      */

    public void enqueue(Integer item) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        } else {
            array[count] = item;
            count++; // Increment the count of elements
        }
    }

    /**
     * Dequeue: Remove and return an element from the front of the queue
     * @return dequeuedItem
     */

    public Integer dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int index = random.nextInt(count);
        int t = array[index];
        for (int i =index; i<count-1; i++){
            array[i]= array[i+1];
        }
        count --;
        return t;

    }

    /**
     * Check if the queue is empty
      */

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Check if the queue is full
      */

    public boolean isFull() {
        return count == array.length;
    }

    /**
     * Get the current size of the queue
      */

    public int size() {
        return count;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new UserIterator(this);
    }


    /**
     * Iterator class for iterating over elements in random order
      */

    private class UserIterator implements Iterator<Integer> {
        private int currentIndex = 0; // Index to keep track of the current element
        private int[] shuffledArray; // Array to store shuffled elements

        public UserIterator(RandomQueue randomQueue) {
            shuffledArray  = Arrays.copyOfRange(randomQueue.array,0, randomQueue.count);
            shuffle(shuffledArray);
        }

        /**
         * Checks if there are more elements in the iteration.
         * @return true if there are more elements to iterate, false if not.
         */

        @Override
        public boolean hasNext() {
            return currentIndex < shuffledArray.length;
        }


        /**
         * method helps to retrieve the next element in the iteration.
         * @return the next item
         */

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements"); // Throws exception if no more elements to iterate.
            }
            Integer nextItem = shuffledArray[currentIndex]; // Get the next item
            currentIndex++; // Move to the next element
            return nextItem; // Return the next item
        }

        /**
         * method to shuffle elements in the array
         */
        private void shuffle(int[] arr) {
            Random random = new Random();
            for (int i = arr.length - 1; i > 0; i--) {
                int j = random.nextInt(i + 1);// Generate a random index
                int temp = arr[i];
                arr[i] = arr[j]; // Swap elements at random indices
                arr[j] = temp;
            }
        }
    }
}

