package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//this is by DFS
public class CourseSchedule2 {

    static int WHITE = 1;
    static int GREEN = 2;
    static int RED = 3;

    private HashMap<Integer, Integer> colors;
    private HashMap<Integer, List<Integer>> graph;
    private List<Integer> sortedList;
    private int numCourses;
    private boolean isCyclic;

    private void init(int numCourses) {

        this.isCyclic = false;
        this.colors = new HashMap<>();
        this.graph = new HashMap<>();
        this.sortedList = new ArrayList<Integer>();
        this.numCourses = numCourses;

        //All nodes first are white
        for(int i = 0; i < numCourses; i++) {
            this.colors.put(i, WHITE);
        }
    }

    private void dfs(int node) {
        //visited the node
        this.colors.put(node, GREEN);

        List<Integer> currList;

        if(this.graph.get(node) != null) {
            currList = this.graph.get(node);
            for(Integer cL: currList) {
                if(this.colors.get(cL) == WHITE) {
                    dfs(cL);
                }
            }
        }

        //traversed all the connecting nodes so turn it red
        this.colors.put(node, RED);
        this.sortedList.add(node);

    }




    public int[] findOrder(int numCourses, int[][] preq) {

        //init required data structures
        init(numCourses);


        //fill the graph
        for(int i = 0; i < preq.length; i++) {
            int parent = preq[i][0];
            int child = preq[i][1];
            List<Integer> currList = new ArrayList<>();
            currList.add(child);
            this.graph.put(parent, currList);
        }

        //iterate through all WHITES
        for(int i = 0; i < numCourses; i++) {
            if(colors.get(i) == WHITE) {
                dfs(i);
            }
        }

        int[] order;

        if(!this.isCyclic) {
            order = new int[numCourses];
            for(int i = 0; i < numCourses; i++) {
                order[i] = this.sortedList.get(numCourses - i - 1);
            }
        } else order = new int[0];

        return order;
    }


    public static void main(String[] args) {
        CourseSchedule2 cs = new CourseSchedule2();
        System.out.println(cs.findOrder(2, new int[][] {{1, 0}}));
    }
}
