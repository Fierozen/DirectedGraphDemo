package com.kashori;

/**
 * Created by johnblack on 5/6/18.
 */

import java.io.*;

/**
 * IntrusiveEdge encapsulates the internals for the default edge implementation. It is not intended
 * to be referenced directly (which is why it's not public); use DefaultEdge for that.
 *
 * @author John V. Sichi
 */
class IntrusiveEdge
        implements Cloneable, Serializable
{
    private static final long serialVersionUID = 3258408452177932855L;

    Object source;

    Object target;

    /**
     * @see Object#clone()
     */
    @Override
    public Object clone()
    {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // shouldn't happen as we are Cloneable
            throw new InternalError();
        }
    }
}

// End IntrusiveEdge.java
