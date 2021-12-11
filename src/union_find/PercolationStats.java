package union_find;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PercolationStats {

    int[][] grid;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException();
        grid = new int[n][n];
    }

    // sample mean of percolation threshold
    public double mean() {
        return -1;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return -1;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return -1;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bf.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int T = Integer.parseInt(arr[1]);

    }


}
