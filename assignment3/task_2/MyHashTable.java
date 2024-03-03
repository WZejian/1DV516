package task_2;



public class MyHashTable<K, V> {

    private int conflicts;
    private int offset;
    private Entry<K, V>[] table;
    private int size;



    public MyHashTable(int INITIAL_CAPACITY) {
        if (INITIAL_CAPACITY <= 0) {
           throw new IllegalArgumentException("Initial capacity must be a positive integer.");
        }
       table = new Entry[INITIAL_CAPACITY];
       size = 0;
    }

    // Insert a key-value pair into the hash table
    public void insert(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
        int pos = findIndexOften(key);
        if ( pos != -1) {
            table[pos].value = value;
        }else {
            int index = findIndex(key);
            if (table[index] != null) {
                conflicts++;
                int i = 1;
                while (table[index] != null && table[index].isDeleteElement() == false) {
                    index = (index + i * i) % table.length;
                    i++;
                    offset++;
                }
            }
            table[index] = new Entry<>(key, value);
            size++;
        }
    }


    // function to calculate load factor
    public  double loadFactor ( ){
        double lf =(double)size / table.length;
        return lf;
    }
    // Find the index of a key
    private int findIndexOften(K key){
        int index = findIndex(key);
        if (table[index] != null) {
            int i = 1;
            while (table[index] != null) {
                if(table[index].getKey().equals(key) && !table[index].isDeleteElement())
                    return index;
                index = (index + i * i) % table.length;
                i++;
            }
        }
        return -1;
    }

    // Check if the hash table contains a key
    public boolean contains (K key){
        int index = findIndexOften(key);
        if ( index == -1) {
            return false;

        }
        return true;
    }

    // Get the value associated with a key
    public V get(K key) {
        int index = findIndexOften(key);
        if ( index != -1 ){
            return table[index].getValue();
        }
        throw new RuntimeException("Such index does not exist");
    }

    // Remove a key-value pair from the hash table
    public void remove(K key) {
        int index = findIndexOften(key);
        if (index ==-1){
            throw new RuntimeException("Such index does not exist");
        } else{
            table[index].setDeleteElement(true);
            size --;
        }
    }

    // Get the current size of the hash table
    public int size() {
        return size;
    }

    // Find the index in the hash table for a given key
    private int findIndex(K key) {
        int hash = hashFunction(key);
        int index = hash % table.length;
        return index;
    }

    // Display the elements in the hash table
    public void showElements (){
        for (int i = 0; i<table.length; i++){
            if (table[i]== null){
                System.out.println("null, it is empty");
            }else if (table[i].isDeleteElement()){
                System.out.println("it was deleted");
            }else {
                System.out.println(table[i].getKey()+" , " + table[i].getValue());
            }
        }
    }

    // Get the number of conflicts in the hash table
    public int getConflicts() {
        return conflicts;
    }

    // Get the offset value for the hash table
    public int getOffset() {
        return offset;
    }

    // Calculate the hash code for a key
    private int hashFunction(K key) {
        return Math.abs(key.hashCode());
    }

    // Entry class to represent key-value pairs
    private static class Entry<K, V> {
        private final K key;
        private  V value;
        private boolean deleteElement;

        // Check if the entry is marked
        public boolean isDeleteElement() {
            return deleteElement;
        }

        // Mark the entry as a deleteElement
        public void setDeleteElement(boolean deleteElement) {
            this.deleteElement = deleteElement;
        }

        // Constructor to initialize an entry
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        // Get the key of the entry
        public K getKey() {
            return key;
        }

        // Get the value of the entry
        public V getValue() {
            return value;
        }
    }


    // Get the key at the specified index
    public K getElementAtIndex(int index) {
        if (index < 0 || index >= table.length || table[index] == null || table[index].isDeleteElement()) {
            throw new RuntimeException("Element not found at the specified index.");
        }
        return table[index].getKey();
    }
}
