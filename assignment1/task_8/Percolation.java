package task_8;

import task_2.QuickUnion;

/**
 * Here uses the UnionFind algorithm to check a grid is percolated or not using
 * its connected method by QuickUnion class.
 * There are virtual top site and virtual bottom site to check if they are
 * connected, so that to determine the grid is percolated.
 * The value of the row and column in the grid are start from 1 to the grid's
 * size.
 */
public class Percolation {
  private QuickUnion uf;
  private boolean[][] grid; // false means site is closed, true means site is open.
  private int numOfOpenSites;
  private int size;
  private int virtualTopSite;
  private int virtualBottomSite;

  public Percolation(int size) {
    this.size = size;
    this.uf = new QuickUnion(size * size + 2); // 2 means one virtual top site and one virtul bottom site
    this.grid = new boolean[size][size]; // Illitally all sites are closed.
    this.numOfOpenSites = 0;
    this.virtualTopSite = 0;
    this.virtualBottomSite = size * size + 1;
  }

  /**
   * Converts to grid index according to the value of row and column.
   */
  private int convertToIndex(int row, int col) {

    return (row - 1) * size + col;
  }

  /**
   * Count the number of open sites in the grid.
   */
  public int numOfOpenSites() {

    return this.numOfOpenSites;
  }

  /**
   * Checks the virtual top site is connected to the virtual bottom site to
   * determine if the grid is percolated or not.
   */
  public boolean percolates() {

    return uf.connected(virtualTopSite, virtualBottomSite);
  }

  /**
   * Checks the site is open or not.
   */
  public boolean isOpen(int row, int col) {

    if (row <= 0 || row > this.size || col <= 0 || col > this.size) {
      throw new IllegalArgumentException("Not valid number");
    }

    return grid[row - 1][col - 1];
  }

  /**
   * Make the site open if it's closed and connect the site to its neighbours if
   * they are open.
   */
  public void open(int row, int col) {

    if (isOpen(row, col)) {
      return;
    }

    grid[row - 1][col - 1] = true;
    numOfOpenSites++;

    // Union the current site to the neighbour sites if it's open.
    int currSite = convertToIndex(row, col);

    // If the current site is in the first row, connect it to the virtual top site.
    if (row == 1) {
      uf.union(currSite, virtualTopSite);
    }

    // If the current site is in the bottom row, connect it to the virtual bottom
    // site.
    if (row == size) {
      uf.union(currSite, virtualBottomSite);
    }

    // Connects the current site to its leftside site if it's open.
    if (col > 1) {
      if (isOpen(row, col - 1)) {
        int leftSite = convertToIndex(row, col - 1);
        uf.union(currSite, leftSite);
      }
    }

    // Connects the current site to its rightside site if it's open.
    if (col < size) {
      if (isOpen(row, col + 1)) {
        int rightSite = convertToIndex(row, col + 1);
        uf.union(currSite, rightSite);
      }
    }

    // Connects the current site to its upside site if it's open.
    if (row > 1) {
      if (isOpen(row - 1, col)) {
        int upSite = convertToIndex(row - 1, col);
        uf.union(currSite, upSite);
      }
    }

    // Connects the current site to its downside site if it's open.
    if (row < size) {
      if (isOpen(row + 1, col)) {
        int downSite = convertToIndex(row + 1, col);
        uf.union(currSite, downSite);
      }
    }
  }

}
