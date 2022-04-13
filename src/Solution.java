
import java.util.*;

public class Solution extends Singleton {


    public static void main(String[] args) {
        int n = 6;
        for(int[] arr : generateMatrix(n))
            System.out.println(Arrays.toString(arr));
    }

    public static int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int val = 1;
        int toLeft = 0, topRight = n - 1, bottomLeft = 0, bottomRight = n - 1;
        int i, j = 0;
        while (toLeft <= topRight) {
            i = toLeft;
            toLeft++;
            while (j <= topRight) mat[i][j++] = val++;
            topRight--;
            j--;
            i++;
            while (i <= bottomRight) mat[i++][j] = val++;
            bottomRight--;
            i--;
            j--;
            while (j >= bottomLeft) mat[i][j--] = val++;
            bottomLeft++;
            j++;
            i--;
            while (i >= toLeft) mat[i--][j] = val++;
            j++;
        }
        return mat;
    }

}






