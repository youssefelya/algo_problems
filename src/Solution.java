import data_struct.TreeNode;

import java.util.*;


public class Solution {
    public static void main(String[] args) {
        int[][] mat = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
    }


    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (String s : strs) {
            int count0 = s.replace("1", "").length();
            int count1 = s.length() - count0;
            for (int i = m; i >= count0; i--)
                for (int j = n; j >= count1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
                }
        }
        return dp[m][n];
    }

}








