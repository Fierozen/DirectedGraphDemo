package com.kashori;

import java.util.*;

/**
 * Created by johnblack on 5/7/18.
 */


/**
 *
 */
public class DirectedGraphImpl<V, E> {

    Map<V, EdgeIO<E>> vertexEdgeMap;

    Map<E, E> edgeMap;

    EdgeClassFactory<V, E> edgeFactory;

    DirectedGraphImpl(Class<E> edgeClass)
    {
        //this.edgeClass = edgeClass;
        this.edgeFactory = new EdgeClassFactory<V, E>(edgeClass);
        this.vertexEdgeMap = new LinkedHashMap<>();
        this.edgeMap = new LinkedHashMap<>();
    }

    public Set<V> getVertexSet()
    {
        return vertexEdgeMap.keySet();
    }

    public Set<E> getEdgeSet() {
        return edgeMap.keySet();
    }

    void addVertex(V vertex) {
        if (containsVertex(vertex)) {
            return;
        }
        EdgeIO edgeio = new EdgeIO<>();
        this.vertexEdgeMap.put(vertex, edgeio);

    }

    public E addEdge(V sourceVertex, V targetVertex)
    {
        assertVertexExist(sourceVertex);
        assertVertexExist(targetVertex);

        E e = edgeFactory.createEdge(sourceVertex, targetVertex);

        if (containsEdge(e)) {
            return null;
        }

        getEdgeContainer(sourceVertex).outgoing.add(e);
        getEdgeContainer(targetVertex).incoming.add(e);

        this.edgeMap.put(e, e);

        return e;
    }

    protected EdgeIO<E> getEdgeContainer(V vertex)
    {
        EdgeIO<E> ec = vertexEdgeMap.get(vertex);

        if (ec == null) {
            ec = new EdgeIO<>();
            vertexEdgeMap.put(vertex, ec);
        }

        return ec;
    }

    public boolean containsVertex(V v)
    {
        return getVertexSet().contains(v);
    }

    protected boolean containsEdge(E e) {
        return edgeMap.containsKey(e);
    }

    protected boolean assertVertexExist(V v)
    {
        if (containsVertex(v)) {
            return true;
        } else if (v == null) {
            throw new NullPointerException();
        } else {
            throw new IllegalArgumentException("no such vertex in graph: " + v.toString());
        }
    }

    public String toString()
    {
        return toStringFromSets(getVertexSet(), getEdgeSet());
    }

    /**
     * Helper for subclass implementations of toString( ).
     *
     * @param vertexSet the vertex set V to be printed
     * @param edgeSet the edge set E to be printed
     *        braces (representing undirected)
     *
     * @return a string representation of (V,E)
     */
    protected String toStringFromSets(
            Collection<? extends V> vertexSet, Set<E> edgeSet)
    {
        List<String> renderedEdges = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (E e : edgeSet) {
            sb.append("("); //symbol for directed graph
            sb.append(((Edge)e).getSource());
            sb.append(",");
            sb.append(((Edge)e).getTarget());
            sb.append(")"); //symbol for directed graph

            renderedEdges.add(sb.toString());
            sb.setLength(0);
        }

        return "(" + vertexSet + ", " + renderedEdges + ")";
    }

}
