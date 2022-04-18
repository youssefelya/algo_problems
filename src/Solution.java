
import data_struct.ListNode;
import data_struct.TreeNode;

import java.util.*;

public class Solution extends Singleton {


    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {2, 3, 1},
                {1, 6, 3}};
        NumMatrix matrix = new NumMatrix(mat);

    }

    static class NumMatrix {
        int[][] matrix;

        public NumMatrix(int[][] matrix) {

            int row = matrix.length, col = matrix[0].length;
            this.matrix = new int[row][col];
            for (int i = 0; i < row; i++) {
                int sum = matrix[i][0];
                this.matrix[i][0] = matrix[i][0];
                for (int j = 1; j < col; j++) {
                    sum = (matrix[i][j] + sum);
                    this.matrix[i][j] = sum;
                }
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int answer = 0;
            for (int i = row1; i <= row2; i++) {
                if (col1 - 1 >= 0)
                    answer += (matrix[i][col2] - matrix[i][col1 - 1]);
                else answer += matrix[i][col2];
            }
            return answer;
        }
    }


}






