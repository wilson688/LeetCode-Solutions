###TOPOLOGICAL SORT
##Key Terminology 
Source - a node with no incoming nodes and only outgoing nodes 

Drain - a node with multiple incoming nodes and no outgoing nodes

Edges - a connection/path between a source and a destination/drain 

##What is Topological Sort?
It is a way to traverse through the entire graph and list all it's vertices using given edge list

## How to do Topological Sort?
1. A Map containing how many incoming edges a node contains 
  ``` HashMap<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex```
2. Another Map to store all the source node and it's destinations/drain nodes
```HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph```
3. Iterate through the edge list and add it to graph Map and increment the num of incoming nodes inside inDegree Map for that particular Node
```       
         for (int i = 0; i < edges.length; i++) {
               int parent = edges[i][0];
               int child = edges[i][1];
               graph.get(parent).add(child); // put the child into it's parent's list
               inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
         }
```
4. Find all the sources (nodes with no incoming edges) and add it to the Queue
```        
       Queue<Integer> sources = new LinkedList<>();
           for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
               if (entry.getValue() == 0)
                   sources.add(entry.getKey());
           }
```
5. Use the queue to iterate over the connecting nodes using the edges (basicaly BFS)
```markdown
        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex); // get the node's children to decrement their in-degrees
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0)
                    sources.add(child);
            }
        }
```

###Things to Remember 
- Edges would be a 2D array list basically a Nx2 matrix where 1 is the all the sources node and 2nd is the destination node 
 & N is the number of Vertices  
