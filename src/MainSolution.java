
import data_struct.ListNode;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainSolution {


    public static void main(String[] args) throws InterruptedException {
        int[][] mat = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        printMat(merge(mat));


    }

    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> answer = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int i = 0;
        while (i < n) {
            int a = intervals[i][0];
            int b = intervals[i][1];
            int index = i + 1;
            while (index < n && b >= intervals[index][0]) {
                b = Math.max(intervals[index][1], b);
                index++;
            }
            i = index;
            answer.add(new int[]{a, b});
        }
        int[][] result = new int[answer.size()][2];
        int x = 0;
        for (int[] arr : answer) {
            result[x] = arr;
            x++;
        }
        return result;
    }

    private static void printMat(int[][] merge) {
        for (int[] arr : merge) {
            System.out.println();
            for (int a : arr)
                System.out.print(" " + a);
        }
        System.out.println();
    }

}
