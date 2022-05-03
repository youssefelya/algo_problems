
import data_struct.ListNode;

import java.io.IOException;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws IOException {
        int[] array = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(array));
    }
    public static int findUnsortedSubarray(int[] nums) {
        int lo = -1, hi = nums.length - 1;
        int mn = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            mn = Math.min(mn, nums[i]);
            if (nums[i] > mn)
                lo = i;
        }
        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            mx = Math.max(mx, nums[i]);
            if (nums[i] < mx)
                hi = i;
        }
        return lo == -1 ? 0 : hi - lo + 1;
    }


}






