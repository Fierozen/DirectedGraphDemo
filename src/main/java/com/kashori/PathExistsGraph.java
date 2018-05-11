package com.kashori;

/**
 * Created by johnblack on 5/10/18.
 */

import java.util.LinkedList;
import java.util.Iterator;

public class PathExistsGraph
{
    private int numVertices;   // Number of vertices
    private LinkedList<Integer> adj[]; //Stored as an adjacency list

    //Constructor
    PathExistsGraph(int v)
    {
        numVertices = v;
        adj = new LinkedList[numVertices];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    //prints BFS traversal from a given source s
    Boolean isReachable(int s, int d)
    {
        LinkedList<Integer>temp;

        // Mark all the vertices as not visited(By default set
        // as false)
        boolean visited[] = new boolean[numVertices];

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
    }


}
// This code is contributed by Aakash Hasija
