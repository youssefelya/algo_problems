
import data_struct.ListNode;
import data_struct.TreeNode;

import java.util.*;

public class Solution extends Singleton {


    public static void main(String[] args) {
        System.out.println();
    }

        public List<List<String>> solveNQueens ( int n){
            List<List<String>> al = new ArrayList<>();
            char chess[][] = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    chess[i][j] = '.';
                }
            }
            backtrack(al, chess, 0);
            return al;
        }
        public void backtrack (List < List < String >> al,char chess[][], int col){
            if (col == chess.length) {
                al.add(construct(chess));
                return;
            }
            for (int row = 0; row < chess.length; row++) {
                if (isValid(chess, row, col)) {
                    chess[row][col] = 'Q';
                    backtrack(al, chess, col + 1);
                    chess[row][col] = '.';
                }
            }
        }
        public boolean isValid ( char chess[][], int row, int col){

            //top-left-angle
            int r1 = row;
            int c1 = col;
            while (r1 >= 0 && c1 >= 0) {
                if (chess[r1][c1] == 'Q') {
                    return false;
                }
                c1--;
                r1--;
            }

            //left
            int r2 = row;
            int c2 = col;
            while (c2 >= 0) {
                if (chess[r2][c2] == 'Q') {
                    return false;
                }
                c2--;
            }

            //bottom-left-angle
            int r3 = row;
            int c3 = col;
            while (r3 < chess.length && c3 >= 0) {
                if (chess[r3][c3] == 'Q') {
                    return false;
                }
                r3++;
                c3--;
            }

            return true;

        }
        public List<String> construct ( char chess[][]){
            List<String> l = new ArrayList<>();
            for (int i = 0; i < chess.length; i++) {
                l.add(new String(chess[i]));
            }
            return l;
        }

}







