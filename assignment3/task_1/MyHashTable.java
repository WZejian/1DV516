package task_1;

public class MyHashTable<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private Entry<K, V>[] table;
    private int size;

    public MyHashTable() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }


    // Inserts a key-value pair into the hash table
    public void insert(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null.");
        }
        // Check if the key already exists in the table
        int pos = findIndexOften(key);
        if ( pos != -1) {
            // Update the value if the key already exists
            table[pos].value = value;
        }else {

            // Find an index for the new key and insert it
            int index = findIndex(key);
            if (table[index] != null) {
                int i = 1;
                // Quadratic probing to find the next available slot
                while (table[index] != null && table[index].isDeathElement() == false) {
                    index = (index + i * i) % table.length;
                    i++;
                }
            }
            table[index] = new Entry<>(key, value);
            size++;
        }
    }

    // Find the index of a key that may exist in the table
    private int findIndexOften(K key){
        int index = findIndex(key);
        if (table[index] != null) {
            int i = 1;
            // Quadratic probing to find the key
            while (table[index] != null) {
                if(table[index].getKey().equals(key) && !table[index].isDeathElement())
                    return index;
                index = (index + i * i) % table.length;
                i++;
            }
        }
        return -1;  // Key not found
    }


    // Retrieve the value associated with a key
    public V get(K key) {
        int index = findIndexOften(key);
        if ( index != -1 ){
            return table[index].getValue();
        }
        throw new RuntimeException("Such index does not exist");
    }

    // Mark the key as deleted
    public void remove(K key) {
        int index = findIndexOften(key);
        if (index ==-1){
            throw new RuntimeException("Such index does not exist");
        } else{
            table[index].setDeathElement(true);
            size --;
        }
    }

    // Get the size of the hash table (number of key-value pairs)
    public int size() {
        return size;
    }

    // Compute the index for a given key using a poor hash function
    private int findIndex(K key) {
        int hash = poorHashFunction(key);
        int index = hash % table.length;
        return index;
    }

    // Display the elements in the hash table
    public void showElements (){
        for (int i = 0; i<table.length; i++){
            if (table[i]== null){
                System.out.println("null, it is empty");
            }else if (table[i].isDeathElement()){
                System.out.println("it was deleted");
            }else {
                System.out.println(table[i].getKey()+" , " + table[i].getValue());
            }
        }
    }

    // hash function to compute a hash code for a key
    private int poorHashFunction(K key) {
        return Math.abs(key.hashCode());
    }

    // Entry class to store key-value pairs
    private static class Entry<K, V> {
        private final K key;
        private  V value;

        public boolean isDeathElement() {
            return deathElement;
        }

        public void setDeathElement(boolean deathElement) {
            this.deathElement = deathElement;
        }

        private boolean deathElement;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

}
