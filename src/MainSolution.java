
import data_struct.TreeNode;

import java.util.*;

public class MainSolution {


    public static void main(String[] args) throws Exception {
        String s = "1,2,3,4,55,3,null,33,4";
        System.out.println(s);

    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<String> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t == null) {
                list.add("#");
            } else {
                list.add("" + t.val);
                stack.push(t.right);
                stack.push(t.left);
            }
        }
        return String.join(",", list);
    }

    static int t;
    public static TreeNode deserialize(String data) {
        if (data == null)
            return null;
        t = 0;
        String[] arr = data.split(",");
        return deserializeHelper(arr);
    }

    public static TreeNode deserializeHelper(String[] arr) {
        if (arr[t].equals("#"))
            return null;
        // create node with this item and recur for children
        TreeNode root
                = new TreeNode(Integer.parseInt(arr[t]));
        t++;
        root.left = deserializeHelper(arr);
        t++;
        root.right = deserializeHelper(arr);
        return root;
    }


}
