
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MainSolution {

    public static void main(String[] args) {
    }



    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder result = new StringBuilder();
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            result.append(reveseWord(strs[i].toCharArray()));
            if (i < n - 1) result.append(" ");
        }
        return result.toString();
    }

    private char[] reveseWord(char[] toCharArray) {
        int n = toCharArray.length;
        int i = 0, j = n - 1;
        while (i < j) {
            char t = toCharArray[i];
            toCharArray[i] = toCharArray[j];
            toCharArray[j] = t;
            i++;
            j--;
        }
        return toCharArray;
    }


    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0, j = n - 1;
        while (i < j) {
            int v1 = numbers[i];
            int v2 = numbers[j];
            int sum = v1 + v2;
            if (sum == target) return new int[]{i, j};
            if (sum > target) j--;
            else i++;
        }
        return new int[]{0, 0};
    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] array = new int[n];
        int i = 0, j = n - 1, index = n - 1;
        while (i < j) {
            int leftVal = nums[i] * nums[i];
            int rightVal = nums[j] * nums[j];
            if (leftVal > rightVal) {
                i++;
                array[index] = leftVal;
            } else {
                j--;
                array[index] = rightVal;
            }
            index--;
        }
        return array;
    }


    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int midVal = nums[mid];
            if (midVal == target) return mid;
            if (mid > target) {
                high = mid;
            } else
                low = mid + 1;
        }
        return low;
    }

}



