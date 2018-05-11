package com.kashori;

/**
 * Created by johnblack on 5/6/18.
 */

/**
 * The default implementation of a directed graph. A default directed graph is a non-simple directed
 * graph in which multiple (parallel) edges between any two vertices are <i>not</i> permitted, but
 * loops are.
 *
 * @param <V> the graph vertex type
 * @param <E> the graph edge type
 *
 */
public class DirectedGraph<V, E>
        extends AbstractBaseGraph<V, E>
{
    private static final long serialVersionUID = -952041424305070908L;

    /**
     * Creates a new directed graph.
     *
     * @param edgeClass class on which to base factory for edges
     */
    public DirectedGraph(Class<? extends E> edgeClass)
    {
        this(new ClassBasedEdgeFactory<>(edgeClass));
    }

    /**
     * Creates a new directed graph with the specified edge factory.
     *
     * @param ef the edge factory of the new graph.
     */
    public DirectedGraph(EdgeFactory<V, E> ef)
    {
        this(ef, false);
    }

    /**
     * Creates a new directed graph with the specified edge factory.
     *
     * @param weighted if true the graph supports edge weights
     * @param ef the edge factory of the new graph.
     */
    public DirectedGraph(EdgeFactory<V, E> ef, boolean weighted)
    {
        super(ef, true, false, true, weighted);
    }

 }

// End DirectedGraph.java