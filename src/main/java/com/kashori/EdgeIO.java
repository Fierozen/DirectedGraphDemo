package com.kashori;

import java.util.Set;

/**
 * Created by johnblack on 5/10/18.
 */
// DirectedEdgeContainer
public class EdgeIO<E> {
    Set<E> incoming;
    Set<E> outgoing;

    EdgeIO() {
        incoming = createEdgeSet();
        outgoing = createEdgeSet();
    }
    Set<E> createEdgeSet() {
        ArrayListSet<E> edgeSet = new ArrayListSet<>();
        return edgeSet;
    }
}
