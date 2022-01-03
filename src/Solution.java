


import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    /*
    Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
     */

    public static void main(String[] args) {
        int[] time = {30, 20, 150, 100, 40};
        for (int i = 0; i < time.length; i++)
            time[i] = time[i] % 60;
        System.out.println(Arrays.toString(time));
    }

    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0, cnt[] = new int[60];
        for (int i = 0; i < time.length; i++) cnt[time[i] % 60] += 1;
        for (int i = 1; i < 30; i++) ans += cnt[i] * cnt[60 - i];
        return ans + cnt[0] * (cnt[0] - 1) / 2 + cnt[30] * (cnt[30] - 1) / 2;
    }

    public int findJudge(int n, int[][] trust) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> possibleSolution = new ArrayList<>();
        for (int[] arr : trust) {
            graph.computeIfAbsent(arr[1], x -> new ArrayList<>());
            map.computeIfAbsent(arr[0], x -> new ArrayList<>());
            graph.get(arr[1]).add(arr[0]);
            map.get(arr[0]).add(arr[1]);
            if (graph.get(arr[1]).size() == n - 1)
                possibleSolution.add(arr[1]);

        }
        for (int key : possibleSolution)
            if (!map.containsKey(key)) return key;
        return -1;
    }

}
