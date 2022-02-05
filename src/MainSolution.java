import java.util.PriorityQueue;

public class MainSolution {


    public static void main(String[] args) {

    }


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode answer = null;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = lists.length;
        for (int i = 0; i < n; i++) {
            heap.add(new int[]{lists[i].val, i});
            lists[i] = lists[i].next;
        }
        while (heap.size() > 0) {
            int[] arr = heap.poll();
            ListNode tem = answer;
            answer = new ListNode(arr[0]);
            answer.next = tem;
            if (lists[arr[1]] != null) {
                heap.add(new int[]{lists[arr[1]].val, arr[1]});
                lists[arr[1]] = lists[arr[1]].next;
            }
        }
        return reverse(answer);
    }

    ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int g) {
        }
    }


}
