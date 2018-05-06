package com.kashori;

/**
 * Created by johnblack on 5/6/18.
 */

/**
 * IntrusiveEdge extension for weighted edges. IntrusiveWeightedEdge encapsulates the internals for
 * the default weighted edge implementation. It is not intended to be referenced directly (which is
 * why it's not public); use DefaultWeightedEdge for that.
 *
 * @author Dimitrios Michail
 */
class IntrusiveWeightedEdge
        extends IntrusiveEdge
{
    private static final long serialVersionUID = 2890534758523920741L;

    double weight = Graph.DEFAULT_EDGE_WEIGHT;

}