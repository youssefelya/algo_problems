import java.util.*;

class Child {
    {
        System.out.println("Child class init block 1");
    }

    static {
        System.out.println("Child class  static init 2");
    }
}

public class Solution {
    public static void main(String[] args) {

        int[][] A = {
                {0, 1, 1, 0, 0, 0},
                {0, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0}
        };
        System.out.println(shortestPathBinaryMatrix(A));
    }

    /*
                       i-1,j   i-1
                       i,j


     */
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) return -1;
        int row = grid.length, col = grid[0].length;
        int[][] direction = {{0, 1}, {1, 0}, {1, 1}, {0, -1}, {-1, 0}, {-1, -1},{-1,1},{1,-1}};
        Queue<int[]> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.add(new int[]{0, 0, 1});
        while (queue.size() > 0) {
            int[] toExplore = queue.poll();
            int currentI = toExplore[0];
            int currentJ = toExplore[1];
            int currentCost = toExplore[2];
            if (currentI == row - 1 && currentJ == col - 1) return currentCost;
            for (int[] dir : direction) {
                int nextI = dir[0] + currentI;
                int nextJ = dir[1] + currentJ;
                String key = nextI + "#" + nextJ;
                if (nextI >= 0 && nextI < row && nextJ >= 0 && nextJ < col && !visited.contains(key)
                        && grid[nextI][nextJ] == 0) {
                    visited.add(key);
                    queue.add(new int[]{nextI, nextJ, currentCost + 1});
                }
            }
        }
        return -1;
    }


}








