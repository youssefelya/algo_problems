
import java.util.*;

public class Solution extends Singleton {


    public static void main(String[] args) {
        int[] books = {1, 2, 3, 4};
        int[] books2 = {0, 1, 1, 2, 3, 4};
        System.out.println(8 + (8 * 5 * 0.75));
    }

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int[] answer = new int[k];
        Map<Integer, Integer> mapNumFreq = new HashMap<>();
        for (int num : nums) mapNumFreq.put(num, mapNumFreq.getOrDefault(num, 0) + 1);
        for (int key : mapNumFreq.keySet())
            heap.add(new int[]{key, mapNumFreq.get(key)});
        int i = 0;
        while (k > 0 && heap.size() > 0) {
            answer[i] = heap.poll()[0];
            i++;
            k--;
        }
        return answer;
    }

}






