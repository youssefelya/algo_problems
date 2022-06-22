

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        String startWord = "hit";
        String endWord = "cog";
        List<String> list = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(ladderLength(startWord, endWord, list));
        System.out.println(path);
    }


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        Map<String, Set<String>> graph = constructGraph(wordList, n, beginWord);
        visited = new HashSet<>();
        visited.add(beginWord);
        int val = bfs(beginWord, endWord, graph);
        visited = new HashSet<>();
        return val != 99 * 99 ? val : 0;
    }

    static Set<String> visited;
    static List<String> path = new ArrayList<>();

    private static int bfs(String src, String target, Map<String, Set<String>> graph) {
        if (target.equals(src)) return 0;
        int val = 99 * 99;
        if (graph.containsKey(src))
            for (String neighbor : graph.get(src)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    path.add(neighbor);
                    int count = bfs(neighbor, target, graph);
                    if (count == val) {
                        path.remove(path.size() - 1);
                    }
                    val = Math.min(val, 1 + count);
                }
            }
        return val;
    }

    private static Map<String, Set<String>> constructGraph(List<String> wordList, int n, String beginWord) {
        Map<String, Set<String>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] array = getIntArray(wordList.get(i));
            for (int j = i + 1; j < n; j++) {
                if (areNeighbor(array, getIntArray(wordList.get(j)))) {
                    graph.computeIfAbsent(wordList.get(i), x -> new HashSet<>()).add(wordList.get(j));
                    graph.computeIfAbsent(wordList.get(j), x -> new HashSet<>()).add(wordList.get(i));
                }
            }
        }
        if (!graph.containsKey(beginWord)) {
            int[] array = getIntArray(beginWord);
            for (int j = 0; j < n; j++) {
                if (areNeighbor(array, getIntArray(wordList.get(j)))) {
                    graph.computeIfAbsent(beginWord, x -> new HashSet<>()).add(wordList.get(j));
                }
            }
        }
        return graph;
    }

    private static boolean areNeighbor(int[] arr1, int[] arr2) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++)
            if (arr1[i] != arr2[i]) count++;
        return count <= 2;
    }

    private static int[] getIntArray(String s) {
        int[] array = new int[28];
        for (int i = 0; i < s.length(); i++)
            array[s.charAt(i) - 'a']++;
        return array;
    }


}









