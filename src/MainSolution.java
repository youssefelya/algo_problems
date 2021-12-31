
import data_struct.TreeNode;

import java.util.*;

public class MainSolution {

    public static void main(String[] args) {

    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        int v1 = bfs(root.left, root.val, root.val);
        int v2 = bfs(root.right, root.val, root.val);
        return Math.max(v1, v2);
    }

    private int bfs(TreeNode root, int min, int max) {
        if (root == null) return max - min;
        return Math.max(bfs(root.left, Math.min(min, root.val), Math.max(max, root.val)),
                bfs(root.right, Math.min(min, root.val), Math.max(max, root.val)));
    }


}
