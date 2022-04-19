package data_struct;

public class TreeNode {
    public TreeNode left, right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {}

    @Override
    public String toString() {
        return val + " l=" + left +
                ", r=" + right;
    }
}
