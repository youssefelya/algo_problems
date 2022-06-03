

import data_struct.TreeNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        bfs(root, map, 0, true);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) ans.add(i, map.get(i));
        return ans;
    }

    public void bfs(TreeNode root, Map<Integer, List<Integer>> map, int l, boolean r) {
        if (root == null) return;
        map.computeIfAbsent(l, x -> new ArrayList<>()).add(root.val);
        if (r) {
            bfs(root.right, map, l + 1, false);
            bfs(root.left, map, l + 1, true);
        } else {
            bfs(root.left, map, l + 1, true);
            bfs(root.right, map, l + 1, false);
        }
    }


}








