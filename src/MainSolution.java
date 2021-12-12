import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainSolution {

    public static void main(String[] args) {
//[1,2,5]
        int[] arr = {1, 2, 5};

    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        return (sum % 2 == 0) && subsetSum(nums, 0, new HashMap<>(), sum / 2);
    }

    private boolean subsetSum(int[] nums, int i, Map<String, Boolean> memo, int sum) {
        if (sum == 0)
            return true;
        if (i >= nums.length || sum < 0)
            return false;
        String key = i + "," + sum;
        if (memo.containsKey(key))
            return memo.get(key);
        memo.put(key, subsetSum(nums, i + 1, memo, sum - nums[i]) || subsetSum(nums, i + 1, memo, sum));
        return memo.get(key);
    }
}
