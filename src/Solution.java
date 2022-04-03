import multiThread.SearchArray;
import test.CharacterThread;
import test.DigitThread;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;

public class Solution {


    public static void main(String[] args) {
        new Thread(new CharacterThread()).start();
        new Thread(new DigitThread()).start();
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int last = nums.length - 1;
            while (last >= 0 && nums[i] >= nums[last]) {
                last--;
            }
            swap(nums, last, i);
        }
        reverse(nums, i + 1);

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }


}






