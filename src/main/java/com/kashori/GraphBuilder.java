package com.kashori;

/**
 * Created by johnblack on 5/6/18.
 */

/**
 * A builder class for {@link Graph}. This is a helper class which helps adding vertices and edges
 * into an already constructed graph instance.
 *
 * <p>
 * Each graph implementation contains a static helper method for the construction of such a builder.
 * For example class {@ link DefaultDirectedGraph} contains method
 * {@ link DefaultDirectedGraph#createBuilder(EdgeFactory)}.
 *
 * <p>
 * See {@ link GraphTypeBuilder} for a builder of the actual graph instance.
 *
 * @param <V> the graph vertex type
 * @param <E> the graph edge type
 * @param <G> type of the resulting graph
 *
 * @author Andrew Chen
 * @see GraphTypeBuilder
 */
public class GraphBuilder<V, E, G extends Graph<V, E>>
        extends AbstractGraphBuilder<V, E, G, GraphBuilder<V, E, G>>
{
    /**
     * Creates a builder based on {@code baseGraph}. {@code baseGraph} must be mutable.
     *
     * <p>
     * The recommended way to use this constructor is: {@code new
     * GraphBuilderBase<...>(new YourGraph<...>(...))}.
     *
     * <p>
     * NOTE: {@code baseGraph} should not be an existing graph. If you want to add an existing graph
     * to the graph being built, you should use the {@link #addVertex(Object)} method.
     *
     * @param baseGraph the graph object to base building on
     */
    public GraphBuilder(G baseGraph)
    {
        super(baseGraph);
    }

    @Override
    protected GraphBuilder<V, E, G> self()
    {
        return this;
    }
}