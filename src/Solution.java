


import data_struct.TreeNode;

import java.util.List;

public class Solution {


    public static void main(String[] args) {


    }

    class BSTIterator {

        List<Integer> list;
        int i = 0;

        public BSTIterator(TreeNode root) {
            bfs(root);
        }

        public int next() {
            return list.get(i++);
        }

        public boolean hasNext() {
            return i < list.size();
        }

        void bfs(TreeNode root) {
            if (root == null) return;
            bfs(root.left);
            list.add(root.val);
            bfs(root.right);
        }
    }

}






