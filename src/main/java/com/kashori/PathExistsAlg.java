package com.kashori;

import java.util.*;


/**
 * Created by johnblack on 5/8/18.
 */

class VisitedNodePath {
    String vertex;
    String from;
    public VisitedNodePath(String vertex, String from) {
        this.vertex = vertex;
        this.from = from;
    }
}

public class PathExistsAlg {

    DirectedGraphImpl<String, Edge> directedGraph;



    public PathExistsAlg(DirectedGraphImpl<String, Edge> directedGraph) {
        this.directedGraph = directedGraph;
    }

    //prints BFS traversal from a given source s
    LinkedList<String> isReachablePath(String source, String target)
    {
        int numVertices = this.directedGraph.vertexEdgeMap.size();

        // visited is empty to start
        HashMap<String,String> visited = new HashMap<>();

        //ArrayList<String> pathFound = new ArrayList<String>();

        LinkedList<String> queue = new LinkedList<String>();

        LinkedList<String> pathFound = new LinkedList<>();

        visited.put(source, null);
        queue.add(source);
        Boolean found = false;
        while (queue.size() != 0) {
            String currentVertex = queue.poll();
            Iterator<Edge> adjacentEdges = this.directedGraph.vertexEdgeMap.get(currentVertex).outgoing.iterator();
            while (adjacentEdges.hasNext()) {
                Edge edge = adjacentEdges.next();
                String nextTarget = (String) edge.getTarget();
                if (nextTarget.equals(target)) {
                    found = true;
                    visited.put(nextTarget, currentVertex);
                    break;
                }
                if (!visited.containsKey(nextTarget)) {
                    visited.put(nextTarget, currentVertex);
                    queue.add(nextTarget);
                }
            }
            if (found) break;
        }
        if (found) {
            pathFound.add(target);
            String previous = visited.get(target);
            pathFound.add(0, previous);
            do {
                previous = visited.get(previous);
                pathFound.add(0, previous);
            } while (previous != source);
        }
        return pathFound;
        /*

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        // 'i' will be used to get all adjacent vertices of a vertex
        Iterator<Integer> i;
        while (queue.size()!=0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();

            int n;
            i = adj[s].listIterator();

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            while (i.hasNext())
            {
                n = i.next();

                // If this adjacent node is the destination node,
                // then return true
                if (n==d)
                    return true;

                // Else, continue to do BFS
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        // If BFS is complete without visited d
        return false;
        */
    }

}
