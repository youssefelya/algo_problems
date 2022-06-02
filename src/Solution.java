

import java.util.*;


public class Solution {
    public static void main(String[] args) {
        String s = "dnncbwoneinoplypwgbwktmvkoimcooyiwirgbxlcttgteqthcvyoueyftiwgwwxvxvg";
        int n = s.length();
        System.out.println(s.substring(0, n / 2));
        System.out.println(s.substring(n / 2, n));
        System.out.println("##############################################");
        boolean isOddLength = n % 2 == 1;
        System.out.println(s.substring(n / 2 + (isOddLength ? 1 : 0), n));
    }


    public String shortestCommonSupersequence(String str1, String str2) {
        map = new HashMap<>();
        return shortestCommonSupersequence(str1.length() >= str2.length() ? str1 : str2,
                str1.length() < str2.length() ? str1 : str2,
                0, 0);
    }

    Map<String, String> map;

    String shortestCommonSupersequence(String str1, String str2, int i, int j) {
        if (i >= str1.length() && j >= str2.length()) return "";
        if (i >= str1.length()) return str2.substring(j);
        if (j >= str2.length()) return str1.substring(i);
        String key = i + "#" + j;
        String value = map.get(key);
        if (value != null) return value;
        if (str1.charAt(i) == str2.charAt(j)) {
            map.put(key, str2.charAt(j) + shortestCommonSupersequence(str1, str2, i + 1, j + 1));
        } else {
            String t1 = str2.charAt(j) + shortestCommonSupersequence(str1, str2, i, j + 1);
            String t2 = str1.charAt(i) + shortestCommonSupersequence(str1, str2, i + 1, j);
            map.put(key, t1.length() >= t2.length() ? t2 : t1);
        }
        return map.get(key);
    }


    public int countSubstrings(String s) {
        int answer = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                if (isPalindrome(s.substring(i, j))) answer++;
            }
        }
        return answer;
    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        if (n == 1) return true;
        if (n == 2) return s.charAt(0) == s.charAt(1);
        if (n == 3) return s.charAt(0) == s.charAt(2);
        boolean isOddLength = n % 2 == 1;
        return s.substring(0, n / 2).equals(s.substring(n / 2 + (isOddLength ? 1 : 0), n));
    }


    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int n = arr1.length;
        // |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
        PriorityQueue<int[]> maxHeap1 = new PriorityQueue<int[]>((a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return b[0] - a[0];
        });
        PriorityQueue<int[]> maxHeap2 = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return b[0] - a[0];
        });

        for (int i = 0; i < n; i++) maxHeap1.add(new int[]{arr1[i], i});
        for (int i = 0; i < n; i++) maxHeap2.add(new int[]{arr2[i], i});

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j]) + Math.abs(i - j);
                max = Math.max(max, val);
            }
        }
        return max;
    }


    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minDiff) {
                answer = new ArrayList<>();
                answer.add(Arrays.asList(arr[i - 1], arr[i]));
                minDiff = diff;
            } else if (diff == minDiff) {
                answer.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return answer;
    }

}








