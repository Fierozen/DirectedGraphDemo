package com.kashori;

/**
 * Created by johnblack on 5/6/18.
 */

/**
 * TypeUtil isolates type-unsafety so that code which uses it for legitimate reasons can stay
 * warning-free.
 *
 * @author John V. Sichi
 */
public class TypeUtil
{
    /**
     * Casts an object to a type.
     *
     * @param o object to be cast
     * @param <T> the type of the result
     *
     * @return the result of the cast
     */
    @SuppressWarnings("unchecked")
    public static <T> T uncheckedCast(Object o)
    {
        return (T) o;
    }

    /**
     * @deprecated Use {@link #uncheckedCast(Object)} instead.
     * Casts an object to a type.
     *
     * @param o object to be cast
     * @param <T> the type of the result
     * @param typeDecl conveys the target type information; the actual value is unused and can be
     *        null since this is all just stupid compiler tricks
     *
     * @return the result of the cast
     */
    @Deprecated
    @SuppressWarnings("unchecked")
    public static <T> T uncheckedCast(Object o, Object typeDecl)
    {
        return (T) o;
    }
}

// End TypeUtil.java
