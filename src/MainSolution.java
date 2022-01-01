
import data_struct.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class MainSolution {

    static List<Integer> list = new ArrayList<>();
    static int index = 0;

    static class Threading extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                list.add(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Threading thread = new Threading();
        Threading thread2 = new Threading();
        thread.start();
        thread2.start();
        Thread.sleep(5000);
        System.out.println(index);
        System.out.println(list);
    }


    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && nums[mid] != nums[mid - 1] && mid + 1 < n && nums[mid + 1] != nums[mid]) return mid;
            if (mid > 0 && nums[mid] == nums[mid - 1]) {
                if ((mid - 1 - low) % 2 == 1)
                    high = mid - 1;
                else low = mid + 1;
            } else if (mid + 1 < n && nums[mid] == nums[mid + 1]) {
                if ((high - mid + 1) % 2 == 1)
                    low = mid - 1;
                else high = mid + 1;
            } else return mid;
        }
        return 1;
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        bfs(root, 0);
        return map.keySet().stream().map(x -> map.get(x)).collect(Collectors.toList());
    }

    Map<Integer, List<Integer>> map = new HashMap<>();

    private void bfs(TreeNode root, int level) {
        if (root == null) return;
        map.computeIfAbsent(level, x -> new ArrayList<>());
        map.get(level).add(root.val);
        bfs(root.left, level + 1);
        bfs(root.right, level + 1);
    }


}
