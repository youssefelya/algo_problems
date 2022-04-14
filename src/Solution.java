
import data_struct.ListNode;

import java.util.*;

public class Solution extends Singleton {


    public static void main(String[] args) {
        int[][] course1 = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};

        int[][] course = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}};
     //   System.out.println(canFinish(5, course1));
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = prerequisites.length;
        for (int i = 0; i < n; i++)
            graph.computeIfAbsent(prerequisites[i][0], x -> new ArrayList<>()).add(prerequisites[i][1]);
        Set<Integer> course = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++)
            if (!visited.contains(i))
                dfs(graph, i, course, visited);
        return course.size() == numCourses;
    }

    static void dfs(Map<Integer, List<Integer>> graph, int src, Set<Integer> course, Set<Integer> visited) {
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






