
import java.util.*;

public class Solution extends Singleton {


    public static void main(String[] args) {

    }


    public void gameOfLife(int[][] board) {
        Map<int[], Integer> map = new HashMap<>();
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = 0;
                for (int[] x : dir) {
                    int rr = x[0] + i;
                    int cc = x[1] + j;
                    if (inRange(rr, cc, rows, cols) && board[rr][cc] == 1) {
                        liveNeighbors++;
                    }
                }
                map.put(new int[]{i, j}, liveNeighbors);
            }
        }
        for (int[] each : map.keySet()) {
            int curI = each[0];
            int curJ = each[0];
            int liveNeighbors = map.get(each);
            if (board[curI][curJ] == 1) {
                if (liveNeighbors < 2 || liveNeighbors > 3) board[curI][curJ] = 0;
            } else {
                if (liveNeighbors == 3) {
                    board[curI][curJ] = 1;
                }
            }
        }
    }
    boolean inRange(int i, int j, int rows, int cols) {
        return i >= 0 && j >= 0 && i < rows && j < cols;
    }


}






