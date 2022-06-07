

import data_struct.TreeNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int index = nums1.length - 1;
        while (index >= 0) {
            if (j < 0) {
                nums1[index] = nums1[i];
                i--;
            } else if (i < 0) {
                nums1[index] = nums2[j];
                j--;
            } else if (nums1[i] > nums2[j]) {
                nums1[index] = nums1[i];
                i--;
            } else {
                nums1[index] = nums2[j];
                j--;
            }
            index--;
        }
    }


}








