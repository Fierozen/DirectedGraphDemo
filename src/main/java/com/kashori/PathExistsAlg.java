package com.kashori;

import java.util.*;


/**
 * Created by johnblack on 5/8/18.
 */

public class PathExistsAlg {

    DirectedGraphImpl<String, Edge> directedGraph;

    public PathExistsAlg(DirectedGraphImpl<String, Edge> directedGraph) {
        this.directedGraph = directedGraph;
    }

    /*
     * Determine if the target is reachable from the source, if so, collect the path
     */
    LinkedList<String> isReachablePath(String source, String target)
    {
        // visited is empty to start
        HashMap<String,String> visited = new HashMap<>();

        // The queue of nodes to visit next in BFS
        LinkedList<String> queue = new LinkedList<String>();

        // The path that was discovered between the
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
            } while (!previous.equals(source));
        }
        return pathFound;
    }

}
