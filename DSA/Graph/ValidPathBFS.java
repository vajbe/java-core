// https://leetcode.com/problems/find-if-path-exists-in-graph/?envType=problem-list-v2&envId=graph
package DSA.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ValidPathBFS {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    void addEdges(int start, int end) {
        graph.putIfAbsent(start, new ArrayList<>());
        graph.putIfAbsent(end, new ArrayList<>());
        graph.get(start).add(end);
        graph.get(end).add(start);
    }

    public void generateGraph(int n, int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            addEdges(edges[i][0], edges[i][1]);
        }
    }
    
    public boolean validPath(int n, int[][] edges, int start, int end) {
        generateGraph(n, edges);
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        List<Integer> path = new ArrayList<>();
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int item = queue.poll();
            if (item == end) {
                return true;
            }
            path.add(item);
            List<Integer> neighbours = graph.get(item);
            for (int neighbour : neighbours) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ValidPathBFS bfs = new ValidPathBFS();
        int[][] edges = {
                { 0, 7 },
                { 0, 8 },
                { 6, 1 },
                { 2, 0 },
                { 0, 4 },
                { 5, 8 },
                { 4, 7 },
                { 1, 3 },
                { 3, 5 },
                { 6, 5 }
        };
        System.out.println(bfs.validPath(10, edges, 7, 3));
    }
}