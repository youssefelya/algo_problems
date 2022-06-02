package data_struct;

import java.util.ArrayList;
import java.util.List;




public class Skiplist {
    private Node head;
    public Skiplist() {
        head = new Node(Integer.MIN_VALUE);
    }
    public Node search(int val) {
        Node curr = head;
        while (curr != null) {
            while (curr.right != null && curr.right.val <= val) {
                curr = curr.right;
            }
            if (curr.val == val) {
                break;
            }
            curr = curr.down;
        }
        return curr;
    }
    public boolean insert(int data) {
        List<Node> pointersToUpdate = new ArrayList<>();
        Node current = head;
        while (current != null) {
            while (current.right != null && current.right.val < data) {
                current = current.right;
            }
            pointersToUpdate.add(current);
            current = current.down;
        }
        int level = 0;
        Node newNode = null;
        while (level == 0 || pureRandomChoice()) {
            if (newNode == null) {
                newNode = new Node(data);
            } else {
                newNode = new Node(newNode);
            }
            Node nodeToUpdate;
            if (pointersToUpdate.size() <= level) {
                createNewLayer();
                nodeToUpdate = this.head;
            } else {
                nodeToUpdate = pointersToUpdate.get(pointersToUpdate.size() - level - 1);
            }
            // insert
            newNode.right = nodeToUpdate.right;
            newNode.left = nodeToUpdate;

            newNode.right.left = newNode;
            nodeToUpdate.right = newNode;
            level++;
        }
        return true;
    }
    public boolean delete(int data) {
        List<Node> pointersToUpdate = new ArrayList<>();
        Node curr = this.head;
        while (curr != null) {
            while (curr.right != null && curr.right.val < data) {
                curr = curr.right;
            }
            if (curr.right != null && curr.right.val == data) {
                pointersToUpdate.add(curr);
            }
            curr = curr.down;
        }
        for (int i = 0; i < pointersToUpdate.size(); i++) {
            Node nodeToUpdate = pointersToUpdate.get(i);
            Node nodeToDelete = nodeToUpdate.right;

            nodeToUpdate.right = nodeToDelete.right;
            nodeToDelete.right.left = nodeToUpdate;

            nodeToDelete.up = null;
            nodeToDelete.down = null;
        }

        return true;
    }
    private void createNewLayer() {
        Node newHead = new Node(Integer.MIN_VALUE);
        Node newTail = new Node(Integer.MAX_VALUE);
        newHead.right = newTail;
        newTail.left = newHead;
        head.up = newHead;
        newHead.down = head;
        head = newHead;
    }
    private boolean pureRandomChoice() {
        return Math.random() >= 0.5;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node up;
    public Node down;

    public Node(int val) {
        this.val = val;
    }

    public Node(Node lowerLevelNode) {
        this.val = lowerLevelNode.val;
        this.down = lowerLevelNode;
    }
}

