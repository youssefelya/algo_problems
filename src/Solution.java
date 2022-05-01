
import data_struct.ListNode;

import java.io.IOException;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws IOException {
        String s = "abcedfgh";
        System.out.println("abc".contains(s));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode temp2 = head;
        while (n > 0) {
            temp2 = temp2.next;
            n--;
        }
        if (temp2 == null) {
            return head.next;
        }
        while (temp2.next != null) {
            temp = temp.next;
            temp2 = temp2.next;
        }
        ListNode a = temp.next;
        ListNode b = a.next;
        temp.next = b;
        return head;

    }
}






