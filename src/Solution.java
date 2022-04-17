public class Solution extends Singleton {


    public static void main(String[] args) {
        int n = 3;
        int[][] mat = {{0, 0, 1}, {4, 3, 7}, {1, 0, 3}};

    }


    public int minFallingPathSum(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int ans = 10000000;
        dp = new int[row + 1][col + 1];
        for (int j = 0; j < col; j++) {
            int sum = minFallingPathSumHelper(A, 0, j, row, col);
            ans = Math.min(ans, sum);
        }
        return ans;
    }

    int[][] dp;
    private int minFallingPathSumHelper(int[][] A, int i, int j, int row, int col) {
        if (i == row) return 0;
        if (j < 0 || j >= col) return Integer.MAX_VALUE;
        if (dp[i][j] != 0) return dp[i][j];
        int sum1 = minFallingPathSumHelper(A, i + 1, j, row, col);
        int sum2 = minFallingPathSumHelper(A, i + 1, j + 1, row, col);
        int sum3 = minFallingPathSumHelper(A, i + 1, j - 1, row, col);
        dp[i][j] = A[i][j] + Math.min(sum1, Math.min(sum2, sum3));
        return dp[i][j];
    }
}









