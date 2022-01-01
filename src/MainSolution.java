
import data_struct.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class MainSolution {

    public static void main(String[] args) {

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
