import data_struct.ListNode;
import data_struct.TreeNode;
import edu.princeton.cs.algs4.In;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainSolution {

    public static void main(String[] args) {


    }

    int[] times;
    Map<Integer, Integer> map;

    public void TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        map = new HashMap<>();
        for (int i = 0; i < times.length; i++)
            map.put(times[i], persons[i]);

    }

    public int q(int t) {
        int index = findIndex(times, t);
        return map.get(times[index]);
    }

    int findIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] <= target) left++;
            else if (nums[mid] >= target) right--;
        }
        return left > 0 ? left - 1 : 0;
    }


    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) head = removeElements(head.next, val);
        else head.next = removeElements(head.next, val);
        return head;
    }


    public ListNode insertionSortList(ListNode head) {
        return head;
    }

}
