
import data_struct.TreeNode;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {
        int m = 2;
        int n = 2;
        System.out.println(uniquePaths(m, n));

    }

    public static int uniquePaths(int m, int n) {
        if (n == 1 && m == 1) return 1;
        int dp[][] = new int[m][n];
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) dp[0][i] = 1;
        for (int i = 1; i < m; i++) dp[i][0] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : 1;
        for (int j = 0; j < n; j++)
            dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : 1;

        for (int i = 1; i < m; i++) {
            A:
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    continue A;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


}






