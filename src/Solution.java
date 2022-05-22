import data_struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    public static void main(String[] args) {

    }

    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (isPalandrom(s, i, j)) count++;
            }
        }
        return count;
    }

    private boolean isPalandrom(String s, int i, int j) {
        if (j - i == 1) return true;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }


}
