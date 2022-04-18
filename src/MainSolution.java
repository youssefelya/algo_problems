import java.util.HashSet;
import java.util.Set;

public class MainSolution {

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }


    public static boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++)
            if (!isValidSudokuCol(board, i)) return false;

        for (int i = 0; i < board[0].length; i++)
            if (!isValidSudokuRow(board, i)) return false;


        for (int i = 0; i < board.length; i = i + 3)
            for (int j = 0; j < board[0].length; j = j + 3)
                if (!isValidThreeByThreeSudoku(board, i, j)) return false;
        return true;
    }
    static boolean isValidSudokuCol(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            if (Character.isAlphabetic(board[i][col]) && !set.add(board[i][col])) return false;
        }
        return true;
    }

    static boolean isValidSudokuRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < board[0].length; i++) {
            if (Character.isAlphabetic(board[row][i]) && !set.add(board[row][i])) return false;
        }
        return true;
    }

    static boolean isValidThreeByThreeSudoku(char[][] board, int i, int j) {
        if (i + 3 >= board.length || j + 3 >= board[0].length) return true;
        Set<Character> set = new HashSet<>();
        for (int x = i; x <= i + 3; x++) {
            for (int y = j; y <= j + 3; j++) {
                if (Character.isAlphabetic(board[x][y]) && !set.add(board[x][y])) return false;
            }
        }
        return true;
    }



}



