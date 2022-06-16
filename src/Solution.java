
import data_struct.ListNode;
import data_struct.TreeNode;

import java.io.IOException;
import java.util.*;

public class Solution extends Singleton {

    public static void main(String[] args) {
        String s = "a";
        System.out.println(longestPalindrome(s));
    }

    public  static String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end = 0, length = 0;
        for (int i = 0; i < n; i++) {
            int[] sol1 = palindrome(s, i, i + 1);
            int[] sol2 = palindrome(s, i, i);
            if (sol1[1] - sol1[0] > length) {
                length = sol1[1] - sol1[0];
                start = sol1[0];
                end = sol1[1];
            }
            if (sol2[1] - sol2[0] > length) {
                length = sol2[1] - sol2[0];
                start = sol2[0];
                end = sol2[1];
            }

        }
        return s.substring(start, end);
    }

    private static int[] palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right};
    }

}







