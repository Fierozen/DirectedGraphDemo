package com.kashori;

/**
 * Created by johnblack on 5/6/18.
 */

import java.io.*;

/**
 * An {@link EdgeFactory} for producing edges by using a class as a factory.
 *
 * <p>
 * Note that when used inside a {@link Graph} the factory must always return a unique object on each
 * call. This implementation calls the no-arguments constructor of the provided class. It is the
 * user's responsibility to make sure that the no-arguments constructor creates unique objects.
 *
 * @param <V> the graph vertex type
 * @param <E> the graph edge type
 *
 * @author Barak Naveh
 * @since Jul 14, 2003
 */
public class ClassBasedEdgeFactory<V, E>
        implements EdgeFactory<V, E>, Serializable
{
    private static final long serialVersionUID = 3618135658586388792L;

    private final Class<? extends E> edgeClass;

    /**
     * Create a new class based edge factory.
     *
     * @param edgeClass the edge class
     */
    public ClassBasedEdgeFactory(Class<? extends E> edgeClass)
    {
        this.edgeClass = edgeClass;
    }

    @Override
    public E createEdge(V source, V target)
    {
        try {
            return edgeClass.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Edge factory failed", ex);
        }
    }
}

// End ClassBasedEdgeFactory.java