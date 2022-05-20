import data_struct.TreeNode;

import java.util.*;


public class Solution {
    public static void main(String[] args) {
        int[][] mat = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        //  System.out.println(longestIncreasingPath(mat));
    }


    public static int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < values.length; i++)
            maxHeap.add(new int[]{labels[i], values[i]});
        Map<Integer, Integer> mapFreqLabel = new HashMap<>();
        int answer = 0;
        int sizeSoFar = 0;
        while (maxHeap.size() > 0) {
            int[] toExplore = maxHeap.poll();
            int val1 = toExplore[1];
            int label1 = toExplore[0];
            mapFreqLabel.put(label1, mapFreqLabel.getOrDefault(label1, 0) + 1);
            if (mapFreqLabel.get(label1) > useLimit)
                continue;
            answer += val1;
            sizeSoFar++;
            if (sizeSoFar >= numWanted) break;
        }
        return answer;
    }

    public static boolean queryString(String s, int n) {
        for (int i = 0; i <= n / 2; i++) {
            if (s.contains(Integer.toBinaryString(i))) return false;
            if (s.contains(Integer.toBinaryString(n - i))) return false;
        }
        return true;
    }

    public String[] findOcurrences(String text, String first, String second) {
        String[] textArry = text.split(" ");
        int n = textArry.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (first.equals(textArry[i]) && i + 1 < n && second.equals(textArry[i + 1])) {
                if (i + 2 < n) list.add(textArry[i + 2]);
            }
        }
        String[] answer = new String[list.size()];
        return list.toArray(answer);
    }


}








