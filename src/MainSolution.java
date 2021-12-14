import data_struct.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainSolution {

    public static void main(String[] args) {


    }

    /*
    Given the root node of a binary search tree and two integers low and high,
     return the sum of values of all nodes with a value in the inclusive range [low, high].
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int v = 0;
        if (root.val >= low && root.val <= high) v = root.val;
        return v + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }


}
