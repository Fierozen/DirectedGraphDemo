package com.kashori;

/**
 * Created by johnblack on 5/6/18.
 */

import java.io.*;
import java.util.*;

/**
 * An edge set factory which creates {@link ArrayUnenforcedSet} of size 1, suitable for small degree
 * vertices.
 *
 * @param <V> the graph vertex type
 * @param <E> the graph edge type
 *
 * @author Barak Naveh
 */
public class ArrayUnenforcedSetEdgeSetFactory<V, E>
        implements EdgeSetFactory<V, E>, Serializable
{
    private static final long serialVersionUID = 5936902837403445985L;

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<E> createEdgeSet(V vertex)
    {
        // NOTE: use size 1 to keep memory usage under control
        // for the common case of vertices with low degree
        return new ArrayUnenforcedSet<>(1);
    }

}
