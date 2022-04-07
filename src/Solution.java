
import java.util.*;
import java.util.stream.Collectors;

public class Solution {


    public static void main(String[] args) {
        int[] array = {1,2,3,1};
        System.out.println(rob(array));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) dp[i] = nums[i];
            else {
                int v = i - 2 >= 0 ? dp[i - 2] : 0;
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
        }
        return dp[n-1];
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int a : stones) maxHeap.add(a);
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            int diff = Math.abs(stone1 - stone2);
            if (diff != 0) maxHeap.add(diff);
        }
        return maxHeap.size() > 0 ? maxHeap.peek() : 0;
    }

}






