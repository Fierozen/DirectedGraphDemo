package com.kashori;

/**
 * Created by johnblack on 5/6/18.
 */
/**
 * An edge factory used by graphs for creating new edges.
 *
 * <p>
 * A graph uses the edge factory to create new edge objects whenever a user calls method
 * {@link Graph#addEdge(Object, Object)}. Users can also create the edge in user code and then use
 * method {@link Graph#addEdge(Object, Object, Object)} to add the edge.
 *
 * <p>
 * Note that when used inside a {@link Graph} the edge factory must return unique objects on each
 * call.
 *
 * @param <V> the graph vertex type
 * @param <E> the graph edge type
 *
 * @author Barak Naveh
 * @since Jul 14, 2003
 */
public interface EdgeFactory<V, E>
{
    /**
     * Creates a new edge whose endpoints are the specified source and target vertices.
     *
     * @param sourceVertex the source vertex.
     * @param targetVertex the target vertex.
     *
     * @return a new edge whose endpoints are the specified source and target vertices.
     */
    E createEdge(V sourceVertex, V targetVertex);
}

// End EdgeFactory.java
