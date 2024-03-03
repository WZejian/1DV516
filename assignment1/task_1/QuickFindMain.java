package task_1;

public class QuickFindMain {
  public static void main(String[] args) {
    // Create an instance of QUnionFind with 8 elements
    QuickFind quf = new QuickFind(8);

    // Print the initial state
    System.out.println("Initial state: " + quf);

    // Perform one union operation
    quf.union(0,1);
    System.out.println("After union 0 and 1: " + quf);

    // Perform another union operation
    quf.union(1,2);
    System.out.println("After union 1 and 2: " + quf);

    // Perform another union operation
    quf.union(3,4);
    System.out.println("After union 3 and 4: " + quf);

    // Presents two elements connected or not
    System.out.println("0 and 2 is connected?: " + quf.connected(0, 2));
    System.out.println("0 and 4 is connected?: " + quf.connected(0, 4));

    // Finds the element
    System.out.println("The root of 0 is in index of : " + quf.find(0));

}
}
