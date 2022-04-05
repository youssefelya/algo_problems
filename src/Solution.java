import java.util.*;

public class Solution {


    public static void main(String[] args) {
    }

    static class FreqStack {
        PriorityQueue<int[]> maxHeap;
        Map<Integer, Integer> visited;
        int currentIndex = 0;
        public FreqStack() {
            currentIndex = 0;
            maxHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[2] - a[2] : b[1] - a[1]);
            visited = new HashMap<>();
        }
        public void push(int val) {
            int freq = visited.getOrDefault(val, 0);
            maxHeap.add(new int[]{val, freq + 1, currentIndex});
            visited.put(val, freq + 1);
            currentIndex++;
        }

        public int pop() {
            int[] toExplore = maxHeap.poll();
            visited.put(toExplore[0], toExplore[1] - 1);
            return toExplore[0];
        }
    }


}






