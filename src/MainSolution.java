import data_struct.ListNode;
import edu.princeton.cs.algs4.In;

import java.util.*;

public class MainSolution {


    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/snapshot-array/submissions/
    class SnapshotArray {
        Map<Integer, Map<Integer, Integer>> map;
        int snapId;
        public SnapshotArray(int length) {
            map = new HashMap<>();
            snapId = 0;
        }

        public void set(int index, int val) {
            map.computeIfAbsent(index, x -> new HashMap<>());
            map.get(index).put(snapId, val);

        }

        public int snap() {
            return snapId++;
        }

        public int get(int index, int snap_id) {
            if (map.containsKey(index)) {
                Map<Integer, Integer> H1 = map.get(index);
                for (int gg = snap_id; gg >= 0; gg--)
                    if (H1.containsKey(gg)) {
                        return H1.get(gg);
                    }
                return 0;
            }
            return 0;
        }
    }

}
