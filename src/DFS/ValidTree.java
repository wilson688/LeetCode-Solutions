package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ValidTree {



    static int WHITE = 1;
    static int GREEN = 2;
    static int RED = 3;

    private HashMap<Integer, Integer> colors;
    private HashMap<Integer, List<Integer>> graph;
    private boolean isValid;
    List<Integer> sortedList;


    private void init(int n) {
        this.isValid = true;
        this.colors = new HashMap<>();
        this.graph = new HashMap<>();
        this.sortedList = new ArrayList<Integer>();

        for(int i = 0; i < n; i++) {
            this.colors.put(i, WHITE);
        }
    }


    private void dfs(int node) {
        if(!this.isValid) return;

        this.colors.put(node, GREEN);

        for(Integer list: this.graph.getOrDefault(node, new ArrayList<Integer>())) {
            if(this.colors.get(list) == WHITE) {
                dfs(list);
            } else if(this.colors.get(list) == GREEN) {
                this.isValid = false;
                return;
            }
        }

        this.colors.put(node, RED);
        this.sortedList.add(node);
    }




    public boolean isValidTree(int n, int[][] edges) {

        //initialze
        init(n);

        //fill graph
        for(int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];

            List<Integer> cL = this.graph.getOrDefault(parent, new ArrayList<Integer>());
            cL.add(child);
            this.graph.put(parent, cL);
        }


        //iterate through the colors array to iterate via WHITE color
        for(int i = 0; i < n; i++) {
            if(this.colors.get(i) == WHITE) {
                dfs(i);
            }
        }

        return sortedList.size() == n;

    }

    public static void main(String[] args) {
        ValidTree cs = new ValidTree();
    //    System.out.println(cs.isValidTree(2, new int[][] {{1, 0}}));
        System.out.println(cs.isValidTree(4, new int[][] {{0,1},{2,3}}));
    }
}
