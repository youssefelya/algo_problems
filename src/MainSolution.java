
import data_struct.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class MainSolution {

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
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
