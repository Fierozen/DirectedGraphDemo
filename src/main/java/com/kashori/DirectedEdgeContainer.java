package com.kashori;

/**
 * Created by johnblack on 5/6/18.
 */

import java.io.*;
import java.util.*;

/**
 * A container for vertex edges.
 *
 * <p>
 * In this edge container we use array lists to minimize memory toll. However, for high-degree
 * vertices we replace the entire edge container with a direct access subclass (to be implemented).
 *
 * @param <V> the graph vertex type
 * @param <E> the graph edge type
 *
 * @author Barak Naveh
 */
public class DirectedEdgeContainer<V, E>
        implements Serializable
{
    private static final long serialVersionUID = 7494242245729767106L;
    Set<E> incoming;
    Set<E> outgoing;
    private transient Set<E> unmodifiableIncoming = null;
    private transient Set<E> unmodifiableOutgoing = null;

    DirectedEdgeContainer(EdgeSetFactory<V, E> edgeSetFactory, V vertex)
    {
        incoming = edgeSetFactory.createEdgeSet(vertex);
        outgoing = edgeSetFactory.createEdgeSet(vertex);
    }

    /**
     * A lazy build of unmodifiable incoming edge set.
     *
     * @return an unmodifiable version of the incoming edge set
     */
    public Set<E> getUnmodifiableIncomingEdges()
    {
        if (unmodifiableIncoming == null) {
            unmodifiableIncoming = Collections.unmodifiableSet(incoming);
        }

        return unmodifiableIncoming;
    }

    /**
     * A lazy build of unmodifiable outgoing edge set.
     *
     * @return an unmodifiable version of the outgoing edge set
     */
    public Set<E> getUnmodifiableOutgoingEdges()
    {
        if (unmodifiableOutgoing == null) {
            unmodifiableOutgoing = Collections.unmodifiableSet(outgoing);
        }

        return unmodifiableOutgoing;
    }

    /**
     * Add an incoming edge.
     *
     * @param e the edge to add
     */
    public void addIncomingEdge(E e)
    {
        incoming.add(e);
    }

    /**
     * Add an outgoing edge.
     *
     * @param e the edge to add
     */
    public void addOutgoingEdge(E e)
    {
        outgoing.add(e);
    }

    /**
     * Remove an incoming edge.
     *
     * @param e the edge to remove
     */
    public void removeIncomingEdge(E e)
    {
        incoming.remove(e);
    }

    /**
     * Remove an outgoing edge.
     *
     * @param e the edge to remove
     */
    public void removeOutgoingEdge(E e)
    {
        outgoing.remove(e);
    }
}