package BasicDSA.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    Map<String, List<String>> graph = new HashMap<>();

    void addEdge(String from, String to) {
        graph.putIfAbsent(from, new ArrayList<>());
/*         graph.putIfAbsent(to, new ArrayList<>()); */

        graph.get(from).add(to);
    }

    void removeEdge(String from, String to) {
        if (graph.containsKey(from)) {
            graph.get(from).remove(to);
        }
    }

    void printGraph() {
        for (var obj : graph.entrySet()) {
            System.out.println(obj.getKey() + " -> " + obj.getValue());
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();

        g.addEdge("1", "3");
        g.addEdge("2", "3");
        g.addEdge("2", "6");
        g.addEdge("2", "10");
        g.addEdge("2", "9");
        g.printGraph();

        g.removeEdge("2", "10");
        g.printGraph();
    }
}