
import data_struct.ListNode;
import data_struct.TreeNode;

import java.util.*;

public class Solution extends Singleton {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        System.out.println(convertBST(root));
    }

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        return convertBSTHelper(root);
    }

    static int sumSoFat = 0;

    private static TreeNode convertBSTHelper(TreeNode root) {
        if (root == null) return null;
        if (root.right != null)
            root.right = convertBSTHelper(root.right);
        sumSoFat += root.val;
        root.val = sumSoFat;
        root.left = convertBSTHelper(root.left);
        return root;
    }

}






