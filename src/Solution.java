import data_struct.TreeNode;

import java.util.*;

public class Solution {


    public static void main(String[] args) {
        int n = 3;
        int[][] mat = {{0, 0, 1}, {4, 3, 7}, {1, 0, 3}};

    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        list = new ArrayList<>();
        kthSmallestHelper(root, k);
        return list.get(k - 1);
    }

    List<Integer> list;

    private void kthSmallestHelper(TreeNode root, int k) {
        if (k == list.size()) return;
        if (root == null) return;
        if (root.left != null) kthSmallestHelper(root.left, k);
        list.add(root.val);
        kthSmallestHelper(root.right, k);
    }


}









