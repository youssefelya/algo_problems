import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws IOException {
        char[][] arr = {
                {'f', 'a', 'a', 'c', 'b'},
                {'e', 'a', 'a', 'e', 'c'},
                {'c', 'f', 'b', 'b', 'b'},
                {'c', 'e', 'a', 'b', 'e'},
                {'f', 'e', 'f', 'b', 'f'}};
        //  System.out.println(containsCycle(arr));
    }


    private boolean[][] visited;
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, i, j, i, j)) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] grid, int x, int y, int lastX, int lastY) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            if (inArea(grid, xx, yy) && grid[xx][yy] == grid[x][y]) {
                if (!visited[xx][yy]) {
                    if (dfs(grid, xx, yy, x, y))
                        return true;
                } else if (xx != lastX || yy != lastY) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean inArea(char[][] grid, int x, int y) {
        return !(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length);
    }


}






