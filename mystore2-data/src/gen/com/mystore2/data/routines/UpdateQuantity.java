/*
 * This file is generated by jOOQ.
*/
package com.mystore2.data.routines;


import com.mystore2.data.Public;

import javax.annotation.Generated;

import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UpdateQuantity extends AbstractRoutine<Object> {

    private static final long serialVersionUID = -987093923;

    /**
     * The parameter <code>public.update_quantity.RETURN_VALUE</code>.
     */
    public static final Parameter<Object> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.DefaultDataType.getDefaultDataType("trigger"), false, false);

    /**
     * Create a new routine call instance
     */
    public UpdateQuantity() {
        super("update_quantity", Public.PUBLIC, org.jooq.impl.DefaultDataType.getDefaultDataType("trigger"));

        setReturnParameter(RETURN_VALUE);
    }
}
