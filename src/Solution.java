
import data_struct.ListNode;
import data_struct.TreeNode;

import java.util.*;

public class Solution extends Singleton {


    public static void main(String[] args) {
    }


    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return minHeightShelves(books, shelfWidth, memo, 0);
    }
    private int minHeightShelves(int[][] books, int shelfWidth, int[] memo, int index) {
        int n = books.length;
        if (index == n)
            return 0;
        if (memo[index] != -1)
            return memo[index];
        int minTotalHeight = Integer.MAX_VALUE;
        int shelfHeight = 0;
        int booksWidth = 0;
        for (int i = index; i < n; i++) {
            booksWidth += books[i][0];
            if (booksWidth > shelfWidth)
                break;
            shelfHeight = Math.max(books[i][1], shelfHeight);
            int remainingHeight = minHeightShelves(books, shelfWidth, memo, i + 1);
            minTotalHeight = Math.min(shelfHeight + remainingHeight, minTotalHeight);
        }
        memo[index] = minTotalHeight;
        return minTotalHeight;
    }

    public int largestValsFromLabels(int[] values,
                                     int[] labels,
                                     int numWanted,
                                     int useLimit) {
        Map<Integer, Integer> labeMapToFrenquence = new HashMap<>();
        int n = values.length;
        int answer = 0;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]
        );
        for (int i = 0; i < n; i++) {
            maxHeap.add(new int[]{values[i], labels[i]});
        }
        while (maxHeap.size() > 0) {
            int[] arr = maxHeap.poll();
            int value = arr[0];
            int label = arr[1];
            labeMapToFrenquence.put(label, labeMapToFrenquence.getOrDefault(label, 0) + 1);
            if (labeMapToFrenquence.get(label) > useLimit) continue;
            numWanted--;
            answer += value;
            if (numWanted <= 0) break;

        }
        return answer;
    }


    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        int n = words.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (first.equals(words[i]) && i + 1 < n && second.equals(words[i + 1]) && i + 2 < n)
                list.add(words[i + 2]);
        }
        return list.toArray(new String[list.size()]);
    }

    public boolean queryString(String s, int n) {
        for (int i = 0; i < n; i++) {
            if (!s.contains(Integer.toBinaryString(i))) return false;
        }
        return true;
    }

}







