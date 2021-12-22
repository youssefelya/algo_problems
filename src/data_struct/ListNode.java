package data_struct;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }

    @Override
    public String toString() {
        return val +
                ", " + next;
    }
}
