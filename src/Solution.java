import java.util.List;
public class Solution {


    public static void main(String[] args) {
        int n = 3;
        int[][] mat = {{0, 0, 1}, {4, 3, 7}, {1, 0, 3}};

    }


    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        List<Integer> li = triangle.get(n - 1);

        for (int i = 0; i < n; i++) {
            dp[i] = li.get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            li = triangle.get(i);
            for (int j = 0; j < i + 1; j++) {
                dp[j] = li.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}









