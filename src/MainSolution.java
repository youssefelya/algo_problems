

import java.util.*;

public class MainSolution {
    private List<Integer> list;

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"ab", "ec"};
        String[] targets = {"eee", "ffff"};

        System.out.println(letterCombinations("23"));
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> visited = new HashMap();
        Node node = head;
        // Iterate through and copy the current node mappings
        while (node != null) {
            visited.put(node, new Node(node.val));
            node = node.next;
        }
        node = head;
        while (node != null) {
            // Set the next node to the
            visited.get(node).next = visited.get(node.next);
            visited.get(node).random = visited.get(node.random);
            node = node.next;
        }
        return visited.get(head);
    }


    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = height[0];
        for (int i = 1; i < n; i++)
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        suffix[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--)
            suffix[i] = Math.max(suffix[i + 1], height[i]);
        int i = 0, answer = 0;
        while (i < n) {
            answer += (Math.abs(height[i] - Math.min(prefix[i], suffix[i])));
        }
        return answer;
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        String[] strs = {"", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz"};
        letterCombinationsHelper(digits, 0, strs, new StringBuilder(), list);
        return list;
    }

    private static void letterCombinationsHelper(String digits, int i, String[] array, StringBuilder str, List<String> list) {
        if (i > digits.length()) return;
        if (str.length() == digits.length()) {
            list.add(str.toString());
            return;
        }
        int val = Character.getNumericValue(digits.charAt(i));
        for (char c : array[val - 1].toCharArray()) {
            str.append(c);
            letterCombinationsHelper(digits, i + 1, array, str, list);
            str.deleteCharAt(str.length() - 1);
        }
    }


}
