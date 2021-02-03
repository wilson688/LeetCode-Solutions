package TopologicalSort;

import java.util.*;

class TaskScheduling {
    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
        // TODO: Write your code here
        List<Integer> sortedOrder = new ArrayList<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        //initialize the inDegree & graph
        for(int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList());
        }

        //now build it baby
        for(int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];

            inDegree.put(child, inDegree.get(child) + 1);
            graph.get(parent).add(child);
        }

        Queue<Integer> queue = new LinkedList<>();

        //now check for the source node
        for(Integer node: inDegree.keySet()) {
            if(inDegree.get(node) == 0) {
              queue.offer(node);
            }
        }

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            sortedOrder.add(curr);
            List<Integer> children = graph.get(curr);
            for(int currNodes: children) {
                inDegree.put(currNodes, inDegree.get(currNodes) -1);
                if(inDegree.get(currNodes) == 0) queue.offer(currNodes);
            }
        }

        return sortedOrder.size() == tasks;
    }

    public static void main(String[] args) {

        boolean result = TaskScheduling.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] {2, 1} });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
                new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println("Tasks execution possible: " + result);
    }
}