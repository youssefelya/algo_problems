import data_struct.ListNode;
import data_struct.TreeNode;
import edu.princeton.cs.algs4.In;

import java.util.*;

public class MainSolution {

    public static void main(String[] args) {
        int n = 4;
        int[][] mat = {{1, 0}, {1, 2}, {1, 3}};
        System.out.println(findMinHeightTrees(n, mat));

    }


    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int size = edges.length;
        for (int i = 0; i < size; i++) {
            graph.computeIfAbsent(edges[i][0], x -> new ArrayList<>());
            graph.computeIfAbsent(edges[i][1], x -> new ArrayList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        Map<Integer, List<Integer>> dist_root = new HashMap<>();
        int minDist = Integer.MAX_VALUE;
        Map<Integer, Integer> mapper = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int dist = bfs(graph, i, new boolean[n]);
            mapper.put(i, dist);
            if (dist < minDist) {
                minDist = dist;
                dist_root.computeIfAbsent(minDist, x -> new ArrayList<>());
                dist_root.get(minDist).add(i);
            }
        }
        return dist_root.get(minDist);
    }

    private static int bfs(Map<Integer, List<Integer>> graph, int src, boolean[] visited ) {
        if (!graph.containsKey(src)) return 0;
        int max = 0;
        visited[src] = true;
        for (int neighbor : graph.get(src)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                max = Math.max(max, 1 + bfs(graph, neighbor, visited));
            }
        }
        return max;
    }

}
