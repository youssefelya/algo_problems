
import java.util.*;

public class Solution extends Singleton {


    public static void main(String[] args) {
        int[] books = {1, 2, 3, 4};
        int[] books2 = {0, 1, 1, 2, 3, 4};
        System.out.println(8 + (8 * 5 * 0.75));
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxGlobal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max + nums[i]);
            if (max > maxGlobal) {
                maxGlobal = max;
            }
        }
        return maxGlobal;
    }

}






