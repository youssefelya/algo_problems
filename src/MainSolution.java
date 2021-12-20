import data_struct.ListNode;
import data_struct.TreeNode;
import edu.princeton.cs.algs4.In;

import java.util.*;

public class MainSolution {
    void g() {
        isFifty(10);
    }

    public static void main(String[] args) {
        String s = "100[leetcode]";


    }

    class SnapshotArray {
        Map<Integer, List<Integer>> map;
        int snap;

        public SnapshotArray(int length) {
            map = new HashMap<>();
            snap = 0;
        }

        public void set(int index, int val) {
            map.computeIfAbsent(index, x -> new ArrayList<>());
            map.get(index).add(val);
        }

        public int snap() {
            return snap++;
        }

        public int get(int index, int snap_id) {
            if (snap_id >= map.get(index).size())
                return map.get(index).get(map.get(index).size() - 1);
            else return map.get(index).get(snap_id);
        }
    }


    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        if (n == 2) return new ArrayList(Arrays.asList(Math.min(arr[0], arr[1]), Math.max(arr[0], arr[1])));
        Arrays.sort(arr);
        Map<Integer, Set<List<Integer>>> map = new HashMap<>();
        int min = 999999;
        for (int i = 1; i < n - 1; i++) {
            int abs1 = Math.abs(arr[i] - arr[i - 1]);
            int abs2 = Math.abs(arr[i] - arr[i + 1]);
            if (min >= abs1) {
                map.computeIfAbsent(abs1, x -> new HashSet<>());
                map.get(abs1).add(Arrays.asList(Math.min(arr[i], arr[i - 1]), Math.max(arr[i], arr[i - 1])));
            }
            if (min >= abs2) {
                map.computeIfAbsent(abs2, x -> new HashSet<>());
                map.get(abs2).add(Arrays.asList(Math.min(arr[i], arr[i + 1]), Math.max(arr[i], arr[i + 1])));
            }
            min = Math.min(min, Math.min(abs1, abs2));
        }
        // re order the result
        return new ArrayList<>(map.get(min));
    }

    int isFifty(int n) {
        // just to make sure that we have positive probebility to find our answer;
        int bound = n + 51;
        Random random = new Random();
        int answer = random.nextInt(bound);
        while (answer != 50) answer = random.nextInt(bound);
        return answer;
    }


}
