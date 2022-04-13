
import java.util.*;

public class Solution extends Singleton {


    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));

    }

    public static int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0' || visited[i][j]) continue;
                answer++;
                traverseNode(grid, i, j, visited);
            }
        }
        return answer;
    }

    private static void traverseNode(char[][] grid, int i, int j, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        while (queue.size() > 0) {
            int[] nodeToExplore = queue.poll();
            int currentI = nodeToExplore[0];
            int currentJ = nodeToExplore[1];
            if (visited[currentI][currentJ] || grid[currentI][currentJ] == '0') continue;
            visited[currentI][currentJ] = true;
            queue.addAll(getNodeNeighbors(grid, currentI, currentJ, visited));
        }
    }

    private static Queue<int[]> getNodeNeighbors(char[][] grid, int currentI, int currentJ, boolean[][] visited) {
        int[][] mat = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] arr : mat) {
            int nextI = currentI + arr[0];
            int nextJ = currentJ + arr[1];

            if (nextI < grid.length && nextI >= 0 && !visited[nextI][currentJ])
                queue.add(new int[]{nextI, currentJ});
            if (nextJ < grid[0].length && nextJ >= 0 && !visited[currentI][nextJ])
                queue.add(new int[]{currentI, nextJ});
        }
        return queue;
    }

}






