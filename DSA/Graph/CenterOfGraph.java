// https://leetcode.com/problems/find-center-of-star-graph/description/?envType=problem-list-v2&envId=graph

package DSA.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CenterOfGraph {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public int findCenter(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        for (var o : graph.entrySet()) {
            if (o.getValue().size() == 2) {
                return o.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CenterOfGraph c = new CenterOfGraph();

        // c.findCenter({{1,2},{5,1},{1,3},{1,4}});
        System.out.println(c.findCenter(new int[][]{{1,2},{5,1},{1,3},{1,4}}));
    }
}
