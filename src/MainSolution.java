
import data_struct.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class MainSolution {

    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/longest-palindromic-substring/
    public String longestPalindrome(String s) {
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

    private int[] palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right};
    }


    //https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int i = 0, toDelete = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                while (set.contains(c)) {
                    set.remove(s.charAt(toDelete));
                    toDelete++;
                }
            }
            set.add(c);
            ans = Math.max(ans, set.size());
            i++;
        }
        return ans;
    }

    //https://leetcode.com/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]), i};
            map.put(target - nums[i], i);
        }
        return new int[]{};
    }


}
