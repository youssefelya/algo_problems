
import java.io.IOException;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws IOException {
        String s = "abcedfgh";
        System.out.println("abc".contains(s));
    }

    public int minCostConnectPoints(int[][] points) {
        return KruskalAlgorithm(points);
    }

    private int KruskalAlgorithm(int[][] points) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        int n = points.length; // node count
        for (int i = 0; i < n; i++) {
            int[] point2 = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] point1 = points[j];
                int dist = Math.abs(point2[0] - point1[0]) + Math.abs(point2[1] - point1[1]);
                int[] edge1 = new int[]{i, j, dist};
                int[] edge2 = new int[]{j, i, dist};
                graph.computeIfAbsent(i, k -> new ArrayList<>()).add(edge1);
                graph.computeIfAbsent(j, k -> new ArrayList<>()).add(edge2);
            }
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]); // pg for edges sorted by cost minHeap
        Set<Integer> visited = new HashSet<>(); // Set to record nodes pushed in mst
        int cost = 0;
        if (graph.isEmpty()) return cost;
        visited.add(0);
        // add all edges for node 0
        heap.addAll(graph.get(0));
        while (!heap.isEmpty()) {
            // get current min weight
            int[] curMinEdgeToExplore = heap.poll();
            int nextNode = curMinEdgeToExplore[1];
            if (!visited.contains(nextNode)) {
                visited.add(nextNode);
                cost += curMinEdgeToExplore[2];
                // add all edges for next node
                for (int[] edge : graph.get(nextNode)) {
                    // we need to check if node already in tree here as well to avoid adding duplicate edges to save time
                    if (!visited.contains(edge[1])) {
                        heap.add(edge);
                    }
                }
            }
        }
        return visited.size() == n ? cost : -1;
    }

}






