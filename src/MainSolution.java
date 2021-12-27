
import data_struct.ListNode;
import data_struct.TreeNode;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainSolution {


    public static void main(String[] args) throws InterruptedException {
        System.out.println(letterCombinations("23"));
    }

    public int findComplement(int num) {
        int complement = 0;
        int length = Integer.toBinaryString(num).length();
        int n = num;
        while (n > 0) {
            complement += (Math.pow(2, length) * (1 - n % 2));
            n = n / 2;
            length--;
        }
        return complement;
    }

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode toExplore = queue.poll();
            if (set.contains(toExplore.val))
                return true;
            set.add(k - toExplore.val);
            if (toExplore.left != null)
                queue.add(toExplore.left);
            if (toExplore.right != null)
                queue.add(toExplore.right);
        }
        return false;
    }

    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int max1 = -1, max2 = -1;
        for (int i = 0; i < n; i++) {
            max1 = Math.max(max1, height[i]);
            max2 = Math.max(max2, height[n - 1 - i]);
            prefix[i] = max1;
            suffix[n - 1 - i] = max2;
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += (Math.min(prefix[i], suffix[i]) - height[i]);
        }
        return answer;
    }


    public static List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> answer = new ArrayList<>();
        String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        bfs(digits, 0, strs, answer, new StringBuilder(), 0);
        return answer;
    }

    private static void bfs(String digits, int i, String[] strs, List<String> answer, StringBuilder str, int count) {
        if (count > 3) return;
        if (i >= digits.length()) {
            if (str.length() > 0) answer.add(str.toString());
            bfs(digits, 0, strs, answer, new StringBuilder(), count + 1);
        } else {
            String s = strs[Character.getNumericValue(digits.charAt(i)) - 2];
            if (count < s.length())
                bfs(digits, i + 1, strs, answer, str.append(s.charAt(count)), count);
            else
                bfs(digits, i + 1, strs, answer, str, count);
        }
    }



}
