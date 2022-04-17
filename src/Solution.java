
import data_struct.ListNode;
import data_struct.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution extends Singleton {


    public static void main(String[] args) {
        int n = 3;
        int[][] mat = {{0, 0, 1}, {4, 3, 7}, {1, 0, 3}};
        System.out.println(arrayStrength(n, mat));
    }

    static String equalSums(String s) {
        int n = s.length();
        int leftSum = s.charAt(0) - 'a', rightSum = 0, i = 1, j = n - 1;
        while (i < j) {
            if (leftSum > rightSum) {
                leftSum += s.charAt(i);
                i++;
            } else {
                leftSum += s.charAt(j);
                j--;
            }
        }
        return s.charAt(i) + "";
    }

    public static String arrayStrength(int n, int[][] A) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int numNonZero = 0;
            int sumRow = 0;
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] != 0) numNonZero++;
                sumRow += A[i][j];
            }
            list.add(sumRow % (1 + numNonZero));
        }

        return list.stream().map(x -> "" + x).collect(Collectors.joining(" "));
    }

}






