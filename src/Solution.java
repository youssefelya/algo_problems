
import data_struct.ListNode;

import java.util.*;

public class Solution extends Singleton {


    public static void main(String[] args) {
        int[][] course1 = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};

        int[][] course = {{1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}};
        System.out.println(Arrays.toString(findOrder(8, course)));
    }


    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = prerequisites.length;
        for (int i = 0; i < n; i++)
            graph.computeIfAbsent(prerequisites[i][0], x -> new ArrayList<>()).add(prerequisites[i][1]);
        Queue<Integer> course = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i))
                dfs(graph, i, course, visited);
        }
        if (course.size() != numCourses) return new int[]{};
        int[] arr = new int[numCourses];
        for (int i = 0; i < numCourses; i++) arr[i] = course.poll();
        return arr;
    }

    static void dfs(Map<Integer, List<Integer>> graph, int src, Queue<Integer> course, Set<Integer> visited) {

        if (!graph.containsKey(src) || course.containsAll(graph.get(src))) {
            course.add(src);
        } else {
            if (graph.containsKey(src))
                for (int neighbor : graph.get(src)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        dfs(graph, neighbor, course, visited);
                    }
                }
            if (!graph.containsKey(src) || course.containsAll(graph.get(src))) {
                course.add(src);
            }
        }
    }

}






