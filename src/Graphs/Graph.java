package Graphs;

public class Graph {

    //to take the num of nodes as input
    private int numOfNodes;
    //a validation to check if the graph is weighted or not
    private boolean isWeighted;
    // a validation to check ig given graph is directional or not
    private boolean isDirectional;
    //a adjacency matrix to take the node values and recreate the matrix/graph
    private float[][] matrix;
    //a boolean matrix to store the information if edges exist between two nodes
    private boolean[][] isSetMatrix;

    public Graph(int numOfNodes, boolean isWeighted, boolean isDirectional) {
        this.numOfNodes = numOfNodes;
        this.isWeighted = isWeighted;
        this.isDirectional = isDirectional;

        //initalize matrix with all the node values
        matrix = new float[numOfNodes][numOfNodes];
        isSetMatrix = new boolean[numOfNodes][numOfNodes];
    }

    //add edges with a given weight (weighted edges)
    public void addEge(int source, int destination, float weight) {
        float valueOfNoes = weight;

        if(!isWeighted) {
            valueOfNoes = 1;
        }

        matrix[source][destination] = valueOfNoes;
        isSetMatrix[source][destination] = true;

        if(isDirectional) {
            matrix[destination][source] = valueOfNoes;
            isSetMatrix[destination][source] = true;
        }
    }

    //if weighted give the weight else give the value 1 as default
    //not a weighted graph
    //if the graph is non directional we need to set the edge in both values
    public void addEdge(int source, int destination, float v) {
      int valueOfNode = 1;

      if(isWeighted) valueOfNode = 0;

      matrix[source][destination] = valueOfNode;
      isSetMatrix[source][destination] = true;

      if(isDirectional) {
          matrix[destination][source] = valueOfNode;
          isSetMatrix[destination][source] = true;
      }

    }

    //method to print all the values of adjacent matrix

    public void printMatrix() {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void printEdges() {
        for(int i = 0; i < matrix.length; i++) {
            System.out.print(i+" Node is connected to ");
            for(int j = 0; j < matrix[0].length; j++) {
                if(isSetMatrix[i][j]) {
                    System.out.print(j);
                }
                System.out.println();
            }
        }
    }

    public boolean hasEdge(int source, int destination) {
        return isSetMatrix[source][destination];
    }

    public Float getEdgeValue(int source, int destination) {
        if(!isSetMatrix[source][destination] && !isWeighted) {
            return null;
        }
        return matrix[source][destination];
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5, false, true);

        graph.addEdge(1, 3, 19.00f); // The default weight is 0 if weighted == true
        graph.addEdge(1, 4, 19.00f);
        graph.addEdge(2, 3, 19.00f);
        graph.addEdge(3, 4, 19.00f);

        Graph graph2 = new Graph(5, true, true);
        graph2.addEdge(0, 2, 19.00f);
        graph2.addEdge(0, 3, -2.00f);
        graph2.addEdge(1, 2, 3.00f);

        graph.printMatrix();

        System.out.println();
        System.out.println();

        graph.printEdges();

        System.out.println("Does an edge from 1 to 0 exist?");
        if (graph.hasEdge(0,1)) {
            System.out.println("Yes");
        }
        else System.out.println("No");

    }
}
