package com.kashori;

/**
 * Created by johnblack on 5/6/18.
 */

/**
 * A default implementation for edges in a weighted graph. All access to the weight of an edge must
 * go through the graph interface, which is why this class doesn't expose any public methods.
 *
 * @author John V. Sichi
 */
public class DefaultWeightedEdge
        extends IntrusiveWeightedEdge
{
    private static final long serialVersionUID = -3259071493169286685L;

    /**
     * Retrieves the source of this edge. This is protected, for use by subclasses only (e.g. for
     * implementing toString).
     *
     * @return source of this edge
     */
    protected Object getSource()
    {
        return source;
    }

    /**
     * Retrieves the target of this edge. This is protected, for use by subclasses only (e.g. for
     * implementing toString).
     *
     * @return target of this edge
     */
    protected Object getTarget()
    {
        return target;
    }

    /**
     * Retrieves the weight of this edge. This is protected, for use by subclasses only (e.g. for
     * implementing toString).
     *
     * @return weight of this edge
     */
    protected double getWeight()
    {
        return weight;
    }

    @Override
    public String toString()
    {
        return "(" + source + " : " + target + ")";
    }

}

// End DefaultWeightedEdge.java