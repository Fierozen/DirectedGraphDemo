package com.kashori;

/**
 * Created by johnblack on 5/6/18.
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * A collection of utilities to test for various graph properties.
 *
 * @author Barak Naveh
 * @author Dimitrios Michail
 * @author Joris Kinable
 */
public class GraphTests
{
    private static final String GRAPH_CANNOT_BE_NULL = "Graph cannot be null";
    private static final String GRAPH_MUST_BE_DIRECTED = "Graph must be directed";

    /**
     * Checks that the specified graph is directed and throws a customized
     * {@link IllegalArgumentException} if it is not. Also checks that the graph reference is not
     * {@code null} and throws a {@link NullPointerException} if it is.
     *
     * @param graph the graph reference to check for beeing directed and not null
     * @param message detail message to be used in the event that an exception is thrown
     * @param <V> the graph vertex type
     * @param <E> the graph edge type
     * @return {@code graph} if directed and not {@code null}
     * @throws NullPointerException if {@code graph} is {@code null}
     * @throws IllegalArgumentException if {@code graph} is not directed
     */
    public static <V, E> Graph<V, E> requireDirected(Graph<V, E> graph, String message)
    {
        if (graph == null)
            throw new NullPointerException(GRAPH_CANNOT_BE_NULL);
        if (!graph.getType().isDirected()) {
            throw new IllegalArgumentException(message);
        }
        return graph;
    }

    /**
     * Checks that the specified graph is directed and throws an {@link IllegalArgumentException} if
     * it is not. Also checks that the graph reference is not {@code null} and throws a
     * {@link NullPointerException} if it is.
     *
     * @param graph the graph reference to check for beeing directed and not null
     * @param <V> the graph vertex type
     * @param <E> the graph edge type
     * @return {@code graph} if directed and not {@code null}
     * @throws NullPointerException if {@code graph} is {@code null}
     * @throws IllegalArgumentException if {@code graph} is not directed
     */
    public static <V, E> Graph<V, E> requireDirected(Graph<V, E> graph)
    {
        return requireDirected(graph, GRAPH_MUST_BE_DIRECTED);
    }

}

// End GraphTests.java