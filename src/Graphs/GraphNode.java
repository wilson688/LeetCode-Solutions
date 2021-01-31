package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Node {
    int n;
    String name;

    public Node(int n, String name) {
        this.n = n;
        this.name = name;
    }
}

public class GraphNode {

    //Adjacent List
    private HashMap<Node, LinkedList<Node>> adjacentMap;
    private boolean isDirected;

    public GraphNode(boolean isDirected) {
        this.isDirected = isDirected;
        adjacentMap = new HashMap<>();
    }

    public void addEdge(Node source, Node destination) {
        if(!adjacentMap.containsKey(source)) {
            adjacentMap.put(source, null);
        }

        if(!adjacentMap.containsKey(destination)) {
            adjacentMap.put(destination, null);
        }

        addEdgeHelper(source, destination);
        if(isDirected) {
            addEdgeHelper(destination, source);
        }
    }

    public void addEdgeHelper(Node source, Node destination) {
       LinkedList<Node> temp = adjacentMap.get(source);

       if(temp == null) {
           temp = new LinkedList<Node>();
       } else if(temp != null && !temp.contains(destination)){
           temp.add(destination);
       }

       adjacentMap.put(source, temp);
    }

    public void printEdge() {
        for(Node node: adjacentMap.keySet()) {
            System.out.print(node.name + " edge nodes are ");
            if(adjacentMap.get(node) != null) {
                for(Node edgeNodes: adjacentMap.get(node)) {
                    System.out.print(edgeNodes.name + " ");
                }
                System.out.println();
            } else System.out.print("NONE");
        }
    }

    public boolean hasEdges(Node source, Node destination) {
        LinkedList<Node> temp = adjacentMap.get(source);
        if(temp != null) {
            return temp.contains(destination);
        } else return false;
    }

    public static void main(String[] args) {

        GraphNode graph = new GraphNode(true);
        Node a = new Node(0, "A");
        Node b = new Node(1, "B");
        Node c = new Node(2, "C");
        Node d = new Node(3, "D");
        Node e = new Node(4, "E");

        graph.addEdge(a,b);
        graph.addEdge(b,c);
        graph.addEdge(b,d);
        graph.addEdge(c,e);
        graph.addEdge(b,a);

        graph.printEdge();

        System.out.println(graph.hasEdges(a,b));
        System.out.println(graph.hasEdges(d,a));
    }

}
