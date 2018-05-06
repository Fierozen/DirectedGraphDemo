package com.kashori;

/**
 * Created by johnblack on 5/6/18.
 */

/**
 * A default implementation for edges in a {@link Graph}.
 *
 * @author Barak Naveh
 * @since Jul 14, 2003
 */
public class DefaultEdge
        extends IntrusiveEdge
{
    private static final long serialVersionUID = 3258408452177932855L;

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

    @Override
    public String toString()
    {
        return "(" + source + " : " + target + ")";
    }
}

// End DefaultEdge.java