//https://leetcode.com/problems/clone-graph/?envType=study-plan-v2&envId=top-interview-150
package DSA.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Map<Integer, Node> visited = new HashMap<>();
        return cloneHelper(node, visited);
    }

    private Node cloneHelper(Node node, Map<Integer, Node> visited) {
        ArrayList<Node> cloned = new ArrayList<>();
        Node clonedNode = new Node(node.val);

        visited.put(clonedNode.val, clonedNode);

        for (Node neighbor : node.neighbors) {
            if (!visited.containsKey(neighbor.val)) {
                cloned.add(cloneHelper(neighbor, visited));
            } else {
                cloned.add(visited.get(neighbor.val));
            }
        }
        clonedNode.neighbors = cloned;
        return clonedNode;
    }
}
