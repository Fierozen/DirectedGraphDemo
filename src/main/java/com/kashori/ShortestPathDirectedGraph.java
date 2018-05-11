package com.kashori;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A Java application that finds and prints, if it exists, a path between two vertices in a directed graph.
 *
 * Takes as parameters a single file name, and two node ID strings.
 * {@literal (<filename> <node1> <node2>)}. The file will consist graph edge data, one edge per line.
 * If a line that contains "AA DD" describes an edge that connects node AA to node DD,
 * in that direction only. Create the necessary data structures to store an arbitrarily sized graph,
 * then determine whether it is possible reach reach node1 from node2. If it is possible to complete
 * that traversal, then print out the path as a series of node IDs, otherwise print out a notification
 * that the two nodes are not connected.
 *
 *
 *  * run as "java com.kashori.ShortestPathDirectedGraph filename node1 node2"
 *
 */
public class ShortestPathDirectedGraph {

    /*
     * If TRUE, then print extra information about the progress of the application
     */
    private Boolean verbose = Boolean.FALSE;

    /**
     * Print usage information and then exit
     */
    private void printUsageExit() {
        System.err.println("Usage: 3 arguments: 1) Filename with graph edges. 2) Source node. 3) Target node.");
        System.exit(1);
    }

    /**
     * Takes a file name and verifies that is is readable, constructs a graph, and then checks for a path.
     *
     * It reads in that file line by line. Each line should contain two strings that represent two nodes
     * in the graph and a direction between them, from the first node to the second node. Any string is allowed.
     * Checks are made to verify if there are two nodes, and only the first two strings are counted as nodes.
     *
     *
     * @param filename - the file with graph edges, represented two strings
     * @param node1 - the first string representing the first or source node
     * @param node2 - the second string represents the second or target node
     */
    private void runCheckFindShortestPath(String filename, String node1, String node2) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            File file = new File(filename);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            bufferedReader.mark(32768);
            bufferedReader.readLine(); // make sure there is at least one text line
            bufferedReader.reset();
        } catch (Exception e) {
            System.err.printf("Error: %s\n", e.getMessage());
            printUsageExit();
        }
        if (verbose) {
            System.out.println("Reading file and building graph...");
        }
        try {
            // use to store text file of graph vertices
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            // constructs a directed graph with the specified vertices and edges
            DirectedGraphImpl<String, Edge> directedGraph1 =
                    new DirectedGraphImpl<>(Edge.class);

            while ((line = bufferedReader.readLine()) != null) {
                String[] edge = line.split(" +");
                if ((edge.length == 2)) {
                    String source = edge[0].trim();
                    String target = edge[1].trim();
                    if (verbose) {
                        System.out.println("edge ok: " + source + ":" + target);
                    }
                    directedGraph1.addVertex(source);
                    directedGraph1.addVertex(target);
                    directedGraph1.addEdge(source, target);
                } else {
                    System.err.printf("Not a valid edge -> %s\n", line);
                }
                if (verbose) {
                    stringBuilder.append(line);
                    stringBuilder.append("\n");
                }
            }
            // Check to see if the source node1 exists in the current graph
            if (!directedGraph1.containsVertex(node1)) {
                System.err.printf("Error: %s is not a valid source node in the graph.\n", node1);
                printUsageExit();
            }
            // Check to see if the target node2 exists in the current graph
            if (!directedGraph1.containsVertex(node2)) {
                System.err.printf("Error: %s is not a valid target node in the graph.\n", node2);
                printUsageExit();
            }
            if (node1.equals(node2)) {
                System.out.printf("Source %s and Target %s are the same.\n",node1, node2);
                System.out.printf("Path is [%s]\n", node1);
                System.exit(0);
            }
            fileReader.close();

            PathExistsAlg pathExistsAlg = new PathExistsAlg(directedGraph1);
            LinkedList<String> pathFound = pathExistsAlg.isReachablePath(node1, node2);
            if (pathFound.isEmpty()) {
                System.out.printf("There is no path from %s to %s\n", node1, node2);
            } else {
                System.out.printf("At least one path exists from %s to %s!\n", node1, node2);
                System.out.printf("The path found is: %s\n", pathFound.toString());
            }

            if (verbose) {
                System.out.println("Computed using the following file:");
                System.out.println(stringBuilder.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * A Java application that finds the shortest path in a directed graph.
     *
     * Takes as parameters a single file name, and two node ID strings.
     * {@literal (<filename> <node1> <node2>)}. The file will consist graph edge data, one edge per line.
     * If a line that contains "AA DD" describes an edge that connects node AA to node DD,
     * in that direction only. Create the necessary data structures to store an arbitrarily sized graph,
     * then determine whether it is possible reach reach node1 from node2. If it is possible to complete
     * that traversal, then print out the path as a series of node IDs, otherwise print out a notification
     * that the two nodes are not connected.
     *
     * @param args  filename, node1, and node2 are allowed as inputs on the command line
     *
     */
    public static void main(String[] args) {
        ShortestPathDirectedGraph runCheckFind = new ShortestPathDirectedGraph();
        if (args.length < 3 || args.length > 3) {
            runCheckFind.printUsageExit();
        }
        String filename = args[0];
        String node1 = args[1];
        String node2 = args[2];
        runCheckFind.runCheckFindShortestPath(filename, node1, node2);
    }
}
