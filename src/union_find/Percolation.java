package union_find;

import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation extends QuickFindUF {

    private int n;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        super(n);
        if (n <= 0)
            throw new IllegalArgumentException();
        this.n = n;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkIndex(row, col);
        union(row, col);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkIndex(row, col);
        return connected(row, col);
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        checkIndex(row, col);
        return count() == n;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return count();
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    private void checkIndex(int row, int col) {
        if (row <= 0 || row > n || col < 0 || col > n)
            throw new IllegalArgumentException();
    }

    public static void main(String[] args) {

    }


}
