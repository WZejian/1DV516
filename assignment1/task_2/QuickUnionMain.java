package task_2;

public class QuickUnionMain {
  public static void main(String[] args) {
    // Creates an instance of QUnionFind with 8 elements
    QuickUnion list = new QuickUnion(8);


    // Prints the initial state
    System.out.println("Initial state:\n\t" + list);

    // Performs one union operation
    list.union(0,1);
    System.out.println("After union 0 and 1:\n\t" + list);

    // Performs another union operation
    list.union(1,2);
    System.out.println("After union 1 and 2:\n\t" + list);

    // Performs another union operation
    list.union(3,4);
    System.out.println("After union 3 and 4:\n\t" + list);

    // Presents two elements connected or not
    System.out.println("0 and 2 is connected?: " + list.connected(0, 2));
    System.out.println("0 and 4 is connected?: " + list.connected(0, 4));

    // Finds the element
    System.out.println("The root of 2 is in index of : " + list.find(2));

}
}
