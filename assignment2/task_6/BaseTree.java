package task_6;

import java.util.Random;

public interface BaseTree {
    void insert(int value);
    boolean delete(int key);

    int getHeight();
    int getCount();
    boolean contains(int data);

}
