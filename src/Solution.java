

import data_struct.TreeNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
    }


    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0, j = n - 1;
        while (i < j) {
            int v = numbers[i] + numbers[j];
            if (v == target) return new int[]{i, j};
            if (v > target) j--;
            else i++;
        }
        return new int[]{};
    }

}








