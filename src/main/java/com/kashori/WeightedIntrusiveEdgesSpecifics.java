package com.kashori;

/**
 * Created by johnblack on 5/6/18.
 */

/**
 * A weighted variant of the intrusive edges specifics.
 *
 * <p>
 * The implementation optimizes the use of {@ link DefaultWeightedEdge} and subclasses. For other
 * custom user edge types, a map is used to store vertex source, target and weight.
 *
 * @author Barak Naveh
 * @author Dimitrios Michail
 *
 * @param <V> the graph vertex type
 * @param <E> the graph edge type
 */
public class WeightedIntrusiveEdgesSpecifics<V, E>
        extends
        BaseIntrusiveEdgesSpecifics<V, E, IntrusiveWeightedEdge>
        implements
        IntrusiveEdgesSpecifics<V, E>
{
    private static final long serialVersionUID = 5327226615635500554L;

    /**
     * Constructor
     */
    public WeightedIntrusiveEdgesSpecifics()
    {
        super();
    }

    @Override
    public boolean add(E e, V sourceVertex, V targetVertex)
    {
        IntrusiveWeightedEdge intrusiveEdge;

        if (e instanceof IntrusiveWeightedEdge) {
            intrusiveEdge = (IntrusiveWeightedEdge) e;
        } else {
            intrusiveEdge = new IntrusiveWeightedEdge();
        }

        intrusiveEdge.source = sourceVertex;
        intrusiveEdge.target = targetVertex;

        return edgeMap.putIfAbsent(e, intrusiveEdge) == null;
    }

    @Override
    public double getEdgeWeight(E e)
    {
        IntrusiveWeightedEdge ie = getIntrusiveEdge(e);
        if (ie == null) {
            throw new IllegalArgumentException("no such edge in graph: " + e.toString());
        }
        return ie.weight;
    }

    @Override
    public void setEdgeWeight(E e, double weight)
    {
        IntrusiveWeightedEdge ie = getIntrusiveEdge(e);
        if (ie == null) {
            throw new IllegalArgumentException("no such edge in graph: " + e.toString());
        }
        ie.weight = weight;
    }

    @Override
    protected IntrusiveWeightedEdge getIntrusiveEdge(E e)
    {
        if (e instanceof IntrusiveWeightedEdge) {
            return (IntrusiveWeightedEdge) e;
        }
        return edgeMap.get(e);
    }
}