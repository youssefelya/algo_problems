package multiThread;

import java.util.Arrays;

public class SearchArray extends Thread {
    private int[] array;
    private int target;
    static boolean containTarget;
    static int numThread = 0;
    SearchArray(int[] A, int t) {
        this.array = A;
        this.target = t;
    }
    @Override
    public void run() {
        System.out.println(Arrays.toString(array));
        for (int a : array) {
            if (target == a) {
                containTarget = true;
            }
        }
        numThread++;
    }



    //search method

    static boolean contains(int[][] matrix, int target) {
        int n = matrix.length;
        SearchArray[] searchArrays = new SearchArray[n];
        for (int i = 0; i < n; i++) {
            searchArrays[i] = new SearchArray(matrix[i], target);
            new Thread(searchArrays[i]).start();
        }
        // wait for every one to finish! or someone already found target
        while (SearchArray.numThread < n && !SearchArray.containTarget) ;
        return SearchArray.containTarget;
    }

}
