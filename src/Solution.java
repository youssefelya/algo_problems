


import data_struct.TreeNode;

import java.util.*;

public class Solution {


    public static void main(String[] args) {
        int[][] mat = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(mat));
    }


    public int maximalSquare(char[][] matrix) {
        int R = matrix.length;
        if (R == 0) return 0;
        int C = matrix[0].length;
        int[][] dp = new int[R][C];
        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    if (i > 0 && j > 0)
                        dp[i][j] += Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]);
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        return answer * answer;
    }


    public static int minPathSum(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        Set<String> visited = new HashSet<>();
        minHeap.add(new int[]{0, 0, grid[0][0]});
        int globalCost = 0;
        while (minHeap.size() > 0) {
            int[] toExplore = minHeap.poll();
            int i = toExplore[0], j = toExplore[1], cost = toExplore[2];
            if (i == grid.length - 1 && j == grid[i].length - 1) {
                globalCost = cost;
                break;
            }
            List<int[]> neighbors = getValidNeighbors(grid, i, j, cost);
            for (int[] neighbor : neighbors) {
                int x = neighbor[0], y = neighbor[1];
                if (!visited.contains(x + "#" + y)) {
                    visited.add(x + "#" + y);
                    minHeap.add(neighbor);
                }
            }

        }
        return globalCost;
    }

    static List<int[]> getValidNeighbors(int[][] grid, int i, int j, int prevCost) {
        int[][] mat = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        List<int[]> neighbor = new ArrayList<>();
        for (int[] arr : mat) {
            int nextX = arr[0] + i;
            int nextY = arr[1] + j;
            if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[nextX].length)
                neighbor.add(new int[]{nextX, nextY, grid[nextX][nextY] + prevCost});
        }
        return neighbor;
    }


}






