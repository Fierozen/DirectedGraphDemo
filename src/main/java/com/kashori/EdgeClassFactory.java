package com.kashori;

/**
 * Created by johnblack on 5/10/18.
 */

public class EdgeClassFactory<V, E> {

    private final Class<? extends E> edgeClass;

    /**
     * Create a new instance of an edge class
     *
     * @param edgeClass the edge class
     */
    public EdgeClassFactory(Class<? extends E> edgeClass)
    {
        this.edgeClass = edgeClass;
    }


    public E createEdge(V source, V target)
    {
        try {
            E e = edgeClass.getDeclaredConstructor().newInstance();
            Edge edge = null;
            if (e instanceof Edge) {
                edge = (Edge)e;
            }
            edge.setVertices(source, target);
            return e;
        } catch (Exception ex) {
            throw new RuntimeException("Edge factory failed", ex);
        }
    }
}
