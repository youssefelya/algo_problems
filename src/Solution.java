

import java.util.*;

public class Solution {


    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 3, 2, 9, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        return subarraySumHelper(nums, 0, 0, k, new HashMap<String, Integer>());
    }

    private static int subarraySumHelper(int[] nums, int i, int val, int k, Map<String, Integer> visited) {
        if (i >= nums.length) return val == k ? 1 : 0;
        if (val == k) return i == 0 ? 0 : 1;
        if (visited.containsKey(i + "#" + val)) return visited.get(i + "#" + val);
        visited.put(i + "#" + val, subarraySumHelper(nums, i + 1, val, k, visited)
                + subarraySumHelper(nums, i + 1, val + nums[i], k, visited));
        return visited.get(i + "#" + val);
    }


}
