
import data_struct.ListNode;

import java.io.IOException;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws IOException {

    }

    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] array = new int[n];
        int evenIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) array[evenIndex++] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) array[evenIndex++] = nums[i];
        }
        return array;
    }

}






