/*
 * This file is generated by jOOQ.
*/
package com.mystore2.data;


import com.mystore2.data.routines.GenCategoryCode;
import com.mystore2.data.routines.GenProductCode;
import com.mystore2.data.routines.ModifyDate;
import com.mystore2.data.routines.UpdateQuantity;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.Field;


/**
 * Convenience access to all stored procedures and functions in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Routines {

    /**
     * Call <code>public.gen_category_code</code>
     */
    public static String genCategoryCode(Configuration configuration) {
        GenCategoryCode f = new GenCategoryCode();

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.gen_category_code</code> as a field.
     */
    public static Field<String> genCategoryCode() {
        GenCategoryCode f = new GenCategoryCode();

        return f.asField();
    }

    /**
     * Call <code>public.gen_product_code</code>
     */
    public static String genProductCode(Configuration configuration) {
        GenProductCode f = new GenProductCode();

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.gen_product_code</code> as a field.
     */
    public static Field<String> genProductCode() {
        GenProductCode f = new GenProductCode();

        return f.asField();
    }

    /**
     * Call <code>public.modify_date</code>
     */
    public static Object modifyDate(Configuration configuration) {
        ModifyDate f = new ModifyDate();

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.modify_date</code> as a field.
     */
    public static Field<Object> modifyDate() {
        ModifyDate f = new ModifyDate();

        return f.asField();
    }

    /**
     * Call <code>public.update_quantity</code>
     */
    public static Object updateQuantity(Configuration configuration) {
        UpdateQuantity f = new UpdateQuantity();

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.update_quantity</code> as a field.
     */
    public static Field<Object> updateQuantity() {
        UpdateQuantity f = new UpdateQuantity();

        return f.asField();
    }
}
