package com.kashori;

import java.util.Set;

/**
 * Created by johnblack on 5/10/18.
 */

public class EdgeIO<E> {
    Set<E> incoming;
    Set<E> outgoing;

    EdgeIO() {
        incoming = createEdgeSet();
        outgoing = createEdgeSet();
    }

    private Set<E> createEdgeSet() {
        return new ArrayListSet<>();
    }
}
