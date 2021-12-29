
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class MainSolution {


    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("")));
    }

    /*
            [5,4,3,2,1,9]
     */

    public long getDescentPeriods(int[] prices) {
        long answer = 0;
        int i = 0, n = prices.length;
        while (i < n) {
            int prev = prices[i];
            int index = i + 1;
            while (index < n && prev == prices[index] + 1) {
                prev = prices[index];
                index++;
            }
            if (index >= n) {
                index--;

            }
            i = index;
        }
        return answer;
    }


    public int kIncreasing(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return kIncreasingHelper(arr, 1, 0, k, dp);
    }

    private int kIncreasingHelper(int[] arr, int lastSeen, int first, int end, int[][] dp) {
        if (end >= arr.length) return 0;
        if (end == arr.length - 1 && arr[first] <= arr[end]) return 0;
        if (dp[first][end] != -1) return dp[first][end];
        int val = arr[first];
        arr[first] = 1;
        int sol1 = kIncreasingHelper(arr, 1, first + 1, end + 1, dp) + (val != 1 ? 1 : 0);
        arr[first] = val;
        int sol2 = kIncreasingHelper(arr, Math.max(arr[first], lastSeen), first + 1, end + 1, dp) + (arr[first] <= arr[end] ? 0 : 1);
        dp[first][end] = Math.max(sol1, sol2);
        return dp[first][end];
    }


    public String firstPalindrome(String[] words) {
        int n = words.length;
        for (String word : words)
            if (isPalindrome(word, word.length() - 1)) return word;
        return "";
    }

    private boolean isPalindrome(String word, int n) {
        int i = 0;
        while (i < n) {
            if (word.charAt(i) != word.charAt(n)) return false;
            n--;
            i++;
        }
        return true;
    }

    public String addSpaces(String s, int[] spaces) {
        int n = s.length();
        int j = 0;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (j < spaces.length && i == spaces[j]) {
                str.append(" ");
                j++;
            }
            str.append(s.charAt(i));

        }
        return str.toString();
    }


}
