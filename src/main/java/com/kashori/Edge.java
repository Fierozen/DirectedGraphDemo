package com.kashori;

import java.io.Serializable;

/**
 * Created by johnblack on 5/7/18.
 */

public class Edge implements Cloneable, Serializable
{
    private static final long serialVersionUID = 3239260523808782799L;

    private Object source = null;

    private Object target = null;

    protected void setVertices(Object source, Object target) {
        this.source = source;
        this.target = target;
    }

    protected Object getSource() {
        return source;
    }

    public Object getTarget() {
        return target;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Edge) {
            Edge e = (Edge) obj;

            if (this.source.equals(e.source) && this.target.equals(e.target)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return source.hashCode() + target.hashCode();
    }

    public Object clone()
    {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // shouldn't happen as we are Cloneable
            throw new InternalError();
        }
    }

    public String toString()
    {
        return "(" + source + " : " + target + ")";
    }

}
