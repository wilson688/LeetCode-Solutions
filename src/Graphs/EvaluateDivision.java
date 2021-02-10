package Graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair {
    private String neighbor;
    private double distance;

    public Pair(String neighbor, double distance) {
        this.neighbor = neighbor;
        this.distance = distance;
    }


    public String getNeighbor() {
        return this.neighbor;
    }

    public double getDistance() {
        return this.distance;
    }
}

class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        Map<String, List<Pair>> graph = new HashMap<>();

        //initialize graph & it's a bidirectional graph
        for(int i = 0; i < equations.size(); i++) {
            List<String> currList = equations.get(i);
            String source = currList.get(0);
            String destination = currList.get(1);
            double distance = values[i];

            Pair sourceToDest = new Pair(destination, distance);
            Pair destToSource = new Pair(source, 1/distance);

            if(!graph.containsKey(source)) {
                graph.put(source, new ArrayList<Pair>());
            }

            graph.get(source).add(sourceToDest);

            if(!graph.containsKey(destination)) {
                graph.put(destination, new ArrayList<Pair>());
            }
            graph.get(destination).add(destToSource);
        }


        for(int i = 0; i < queries.size(); i++) {
            List<String> currList = queries.get(i);
            String source = currList.get(0);
            String dest = currList.get(1);

            if(source.equals(dest)) {
                res[i] = 1.0;
            } else {
                if(graph.containsKey(source)) {
                    List<Pair> currPair = graph.get(source);
                    if(currPair.contains(dest)) {
                          int cpIndex = currPair.indexOf(dest);
                          Pair cp = currPair.get(cpIndex);
                            if(cp.getNeighbor().equals(dest)) {
                                res[i] = cp.getDistance();
                        }
                    }
                } else {
                    res[i] = -1.0;
                }
            }
        }
        printQueriesOutput(res);
        return res;
    }

    private void printQueriesOutput(double[] res) {
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static void main(String[] args) {
        List<String> equation = new ArrayList<>();
        List<String> equation2 = new ArrayList<>();
        List<List<String>> equations = new ArrayList<>();
       //[["a","b"],["b","c"]]
        equation.add("a");
        equation.add("b");
        equation2.add("b");
        equation2.add("c");
        equations.add(equation);
        equations.add(equation2);

        double[] values = new double[] {2.0,3.0};

        List<String> q1 = new ArrayList<>();
        List<String> q2 = new ArrayList<>();
        List<String> q3 = new ArrayList<>();
        List<String> q4 = new ArrayList<>();
        List<String> q5 = new ArrayList<>();
        List<List<String>> queries = new ArrayList<>();
        //[["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
        q1.add("a");
        q1.add("c");
        q2.add("b");
        q2.add("a");
        q3.add("a");
        q3.add("e");
        q4.add("a");
        q4.add("a");
        q5.add("x");
        q5.add("x");

        queries.add(q1);
        queries.add(q2);
        queries.add(q3);
        queries.add(q4);
        queries.add(q5);


        EvaluateDivision ed = new EvaluateDivision();
        ed.calcEquation(equations, values, queries);


    }
}