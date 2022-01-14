


import java.util.*;

public class Solution {


    public static void main(String[] args) throws InterruptedException {
        int[][] mat = {{2, 1, 5}, {3, 5, 7}};
        int capacity = 3;
        System.out.println(carPooling(mat, capacity));
    }

    public static boolean carPooling(int[][] trips, int capacity) {
        int i = 0, n = trips.length;
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int currentCapacity = 0;
        while (i < n) {
            int numPassage = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            while (heap.size() > 0 && heap.peek()[2] <= from) {
                currentCapacity -= heap.peek()[0];
                heap.poll();
            }

            currentCapacity += numPassage;
            heap.add(trips[i]);
            if (currentCapacity > capacity) return false;
            i++;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<String> res = new ArrayList<String>();
        return dfs(s, res);
    }

    public static List<List<String>> dfs(String s, List<String> prevString) {
        List<List<String>> res = new ArrayList<List<String>>();
        for (int i = 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(0, i))) {
                List<String> set = new ArrayList<String>(prevString);
                set.add(s.substring(0, i));
                if (i == s.length())
                    res.add(set);
                else
                    res.addAll(dfs(s.substring(i), set));
            }
        }
        return res;
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 1)
            return true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(s.length() - 1 - i) != s.charAt(i))
                return false;
        }
        return true;
    }


}
