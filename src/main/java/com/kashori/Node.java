package com.kashori;

/**
 * Created by johnblack on 5/9/18.
 */

import java.util.ArrayList;

public class Node {

    private int distanceFromSource = Integer.MAX_VALUE;

    private boolean visited;

    private ArrayList<SimpleEdge> edges = new ArrayList<SimpleEdge>(); // now we must create edges

    public int getDistanceFromSource() {
        return distanceFromSource;
    }

    public void setDistanceFromSource(int distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public ArrayList<SimpleEdge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<SimpleEdge> edges) {
        this.edges = edges;
    }
}