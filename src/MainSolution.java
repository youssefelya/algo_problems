
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MainSolution {


    public static void main(String[] args) throws Exception {
        int[][] mat = {{1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {2, 2, 2, 2}};
        int[][] mat2 = {{3, 4, 3}, {2, 2, 2}, {2, 1, 1}, {4, 3, 2}, {2, 1, 4}, {2, 4, 1}, {3, 3, 3}, {1, 4, 2}, {2, 2, 1}, {2, 1, 1}, {3, 3, 1}, {4, 1, 4}, {2, 1, 4}, {3, 2, 2}, {3, 3, 1}, {4, 4, 1}, {1, 2, 2}, {1, 1, 1}, {1, 3, 4}, {1, 2, 1}, {2, 2, 4}, {2, 1, 3}, {1, 2, 1}, {4, 3, 2}, {3, 3, 4}, {2, 2, 1}, {3, 4, 3}, {4, 2, 3}, {4, 4, 4}};
        System.out.println(minCost(mat2));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
    }

    public static int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return minCostHelper(grid, 0, 0, dp);
    }

    private static int minCostHelper(int[][] grid, int i, int j, int[][] dp) {
        if (i >= grid.length || i < 0 || j >= grid[i].length || j < 0) return 9999999;
        if (i == grid.length - 1 && j == grid[i].length - 1) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (grid[i][j] != -1) {
            int direction = grid[i][j];
            grid[i][j] = -1;
            int path1 = minCostHelper(grid, i, j + 1, dp) + (direction == 1 ? 0 : 1);
            int path2 = minCostHelper(grid, i, j - 1, dp) + (direction == 2 ? 0 : 1);
            int path3 = minCostHelper(grid, i + 1, j, dp) + (direction == 3 ? 0 : 1);
            int path4 = minCostHelper(grid, i - 1, j, dp) + (direction == 4 ? 0 : 1);
            grid[i][j] = direction;
            dp[i][j] = Math.min(Math.min(path1, path2), Math.min(path3, path4));
            return dp[i][j];
        }
        return 9999999;
    }

    public static int maxPoints(int[][] points) {
        int n = points.length;
        if (n < 3) return n;
        int possibleSolutionX = 0, possibleSolutionY = 0;
        for (int[] point : points) {
            if (point[0] == points[0][0]) {
                point[0] = points[0][0];
                possibleSolutionX++;
            }
            if (point[1] == points[0][1]) {
                point[1] = points[0][1];
                possibleSolutionY++;
            }
        }
        if (possibleSolutionX == n || possibleSolutionY == n) return n;
        int answer = Math.max(possibleSolutionX, possibleSolutionY);
        Map<List<Double>, Integer> visited = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                double a = getCoefficient(points[i], points[j]);
                double b = points[i][1] - a * points[i][0];
                int max = 0;
                if (!visited.containsKey(Arrays.asList(a, b))) {
                    for (int x = 0; x < n; x++)
                        if (x != i && j != x && isIn(points[x], a, b))
                            max++;
                    answer = Math.max(answer, max);
                    visited.put(Arrays.asList(a, b), max);
                }
            }
        }
        return answer;
    }

    private static boolean isIn(int[] point, double a, double b) {
        return a * point[0] + b == point[1];
    }

    private static double getCoefficient(int[] point, int[] point1) {
        if (point[0] == point1[0]) return 0;
        return ((double) (point[1] - point1[1])) / ((double) point[0] - point1[0]);
    }


}
