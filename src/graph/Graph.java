package graph;

import java.util.*;

public class Graph {
    private class Edge {
        int dest, cost;

        Edge(int d, int c) {
            this.dest = d;
            this.cost = c;
        }

        @Override
        public String toString() {
            return dest + " " + cost + ", ";
        }
    }

    private Map<Integer, Set<Edge>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public Graph(int[][] mat) {
        graph = new HashMap<>();
        generateGraph(mat);
    }

    public Graph generateGraph(int[][] mat) {
        boolean withCost = mat[0].length >= 3;
        for (int[] array : mat) {
            connect(array[0], array[1], withCost ? array[2] : 0);
        }
        return this;
    }

    public void connect(int src, int dest, int cost) {
      //  graph.computeIfAbsent(src, x -> new HashSet<>());
        graph.get(src).add(new Edge(dest, cost));
    }

    public List<Integer> getNeighbors(int src) {
        if (!graph.containsKey(src) || graph.get(src).size() < 1) return new ArrayList<>();
        return null;// graph.get(src).stream().map(edge -> edge.dest).collect(Collectors.toList());
    }

    public Set<Edge> getEdgeNeighbors(int src) {
        if (!graph.containsKey(src) || graph.get(src).size() < 1) return new HashSet<>();
        return graph.get(src);
    }


    public Boolean bfs(int src, int dest) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            int toExplore = queue.poll();
            if (toExplore == dest) return true;
            for (int neighbor : getNeighbors(toExplore)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }

    public void printGraph() {
        System.out.println(graph);
    }

    public Boolean dijkstra(int src, int dest) {
        Set<Edge> visited = new HashSet<>();
        PriorityQueue<Edge> heap = null;//new PriorityQueue<>((a, b) -> a.cost - b.cost);
        int dist = 0;
        heap.addAll(graph.get(src));
        while (!heap.isEmpty()) {
            Edge toExplore = heap.poll();
            int currentDis = toExplore.cost;
            System.out.println(toExplore.dest + " _ " + toExplore.cost);
            if (toExplore.dest == dest) return true;
            for (Edge neighbor : getEdgeNeighbors(toExplore.dest)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    heap.add(new Edge(neighbor.dest, currentDis + neighbor.cost));
                }
            }
        }
        return false;
    }


}
