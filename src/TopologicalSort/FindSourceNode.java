package TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSourceNode {


    public static List<Integer> findSource(int V, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>(); //count num of incoming nodes to a source node

        //adding all the vertices to the inDegree with 0's as num of incoming nodes
        for(int i = 0; i < V; i++) {
            inDegree.put(i, 0);
        }

        //updating the inDegree with all the num of incoming nodes for each node
        for(int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            inDegree.put(child, inDegree.get(child) + 1);
        }

        for(Integer node: inDegree.keySet()) {
            if(inDegree.get(node) == 0) {
                res.add(node);
            }
        }


        return res;
    }

    public static void main(String[] args) {
        List<Integer> result = FindSourceNode.findSource(4,
                new int[][] {{3, 2}, { 3, 0 }, { 2, 0 }, {2, 1}});
        System.out.println(result);

    }
}
