

import data_struct.TreeNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
    }


    public Node copyRandomList(Node head) {
        if (head == null) return null;
        map = new HashMap<>();
        Node temp = copyNode(head);
        Node t = temp;
        while (head != null) {
            if (map.containsKey(t.val))
                t.random = map.get(t.val);
            t = t.next;
            head = head.next;
        }
        return temp;
    }

    Map<Integer, Node> map;

    private Node copyNode(Node head) {
        if (head == null) ;
        Node t = new Node(head.val);
        t.next = copyNode(head.next);
        map.put(head.val, t);
        return t;
    }


    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(root.val)) return true;
        set.add(k - root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    static class Node {
        Node next;
        Node random;
        int val;

        public Node(int val) {
        }
    }


}








