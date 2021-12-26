
import data_struct.ListNode;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainSolution {


    public static void main(String[] args) throws InterruptedException {
        int[] arrray = {1, 5, 11, 5};
    }

    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        if (n <= k) return points;
        int[][] kcloasest = new int[k][2];
        PriorityQueue<double[]> heap = new PriorityQueue<double[]>((a, b) -> {
            return a[1] > b[1] ? 1 : -1;
        });
        for (int i = 0; i < n; i++) {
            double dist = distanceFromOrigin(points[i]);
            heap.add(new double[]{i, dist});
        }
        int i = 0;
        while (i < k) {
            int index = (int) heap.poll()[0];
            kcloasest[i] = points[index];
            i++;
        }
        return kcloasest;
    }

    private double distanceFromOrigin(int[] point) {
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }

}
