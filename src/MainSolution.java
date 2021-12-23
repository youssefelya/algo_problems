import data_struct.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MainSolution {


    public static void main(String[] args) {
        String s1 = "abac";
        String s2 = "cab";
        System.out.println(shortestCommonSupersequence(s1, s2));
    }


    public static String shortestCommonSupersequence(String str1, String str2) {
        if (str1.equals(str2)) return str1;
        String s1 = shortestCommonSupersequenceHelper(str1, 0, str2, str2.length() - 1, new int[str1.length()][str2.length()]);
        String s2 = shortestCommonSupersequenceHelper(str2, 0, str1, str1.length() - 1, new int[str1.length()][str2.length()]);
        return s1.length() < s2.length() ? s2 : s1;
    }

    private static String shortestCommonSupersequenceHelper(String str1, int i, String str2, int j, int[][] dp) {
        if (i >= str1.length() && j < 0) return "";
        if (i >= str1.length()) return str2;
        if (j < 0) return str1;
        String t0 = null;
        String t1 = null;
        String t2 = null;
        String t3 = null;
        int n1 = 10, n2 = n1, n3 = n1, n0 = 0;
        if (str1.charAt(i) == str2.charAt(j)) {
            t0 = str2.charAt(j) + shortestCommonSupersequenceHelper(str1, i + 1, str2, j - 1, dp);
        } else {
            t1 = str2.charAt(j) + shortestCommonSupersequenceHelper(str1, i, str2, j - 1, dp);
            t2 = str1.charAt(i) + shortestCommonSupersequenceHelper(str1, i + 1, str2, j, dp);
            t3 = str1.charAt(i) + str2.charAt(j) + shortestCommonSupersequenceHelper(str1, i + 1, str2, j - 1, dp);
        }
        n0 = t0 != null ? t0.length() : 9999999;
        n1 = t1 != null ? t1.length() : 9999999;
        n2 = t2 != null ? t2.length() : 99999999;
        n3 = t3 != null ? t3.length() : 99999999;
        int min = Math.min(Math.min(n1, n0), Math.min(n2, n3));
        if (min == n1) return t1;
        return min == n2 ? t2 : min == n3 ? t3 : t0;
    }


    public static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && arr[mid] > arr[mid - 1] && mid + 1 < n && arr[mid] > arr[mid + 1]) return mid;
            if (mid > 0 && arr[mid] > arr[mid - 1]) {
                low = mid;
            } else {
                high = mid + 1;
            }
            if (mid == 0 || mid == n - 1) return mid;
        }
        return low;
    }

    interface MountainArray {
        int get(int index);
        int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int mid = findMount(mountainArr);
        int sol1 = binarSearch(target, mountainArr, 0, mid);
        int sol2 = binarSearch(target, mountainArr, mid, mountainArr.length());
        if (sol1 == -1 || sol2 == -1) return Math.max(sol2, sol1);
        return Math.min(sol1, sol2);
    }

    int binarSearch(int target, MountainArray mountainArr, int from, int to) {
        int low = from;
        int high = to;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = mountainArr.get(mid);
            if (value == target)
                return mid;
            else if (target > value)
                low = mid;
            else high = mid + 1;
            if (low == high)
                return mountainArr.get(low) == target ? low : -1;
        }
        return -1;
    }

    public int findMount(MountainArray mountainArr) {
        int n = mountainArr.length();
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
            int midVal = mountainArr.get(mid);
            if (mid > 0)
                left = mountainArr.get(mid - 1);
            if (mid + 1 < n)
                right = mountainArr.get(mid + 1);
            if (midVal > left && midVal > right) return mid;
            if (midVal > left) {
                low = mid;
            } else {
                high = mid + 1;
            }
            if (left == Integer.MAX_VALUE || right == Integer.MAX_VALUE) return mid;
        }
        return low;
    }

}
