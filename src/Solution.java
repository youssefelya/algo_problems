
import data_struct.ListNode;
import data_struct.TreeNode;

import javax.swing.*;
import java.util.*;

public class Solution extends Singleton {


    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {2, 3, 1},
                {1, 6, 3}};


    }

    public long[] sumOfThree(long num) {
        double result = ((double) num - 3) / 3;
        long ans = (long) result;
        if (isLong(result)) return new long[]{ans, ans + 1, ans + 2};
        return new long[]{};
    }

    private boolean isLong(double result) {
        return (long) result == result;
    }


}






