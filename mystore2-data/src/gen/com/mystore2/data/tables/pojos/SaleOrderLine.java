/*
 * This file is generated by jOOQ.
*/
package com.mystore2.data.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.Generated;


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
public class SaleOrderLine implements Serializable {

    private static final long serialVersionUID = -1094653472;

    private final Integer    id;
    private final Integer    productId;
    private final Integer    quantity;
    private final BigDecimal amount;

    public SaleOrderLine(SaleOrderLine value) {
        this.id = value.id;
        this.productId = value.productId;
        this.quantity = value.quantity;
        this.amount = value.amount;
    }

    public SaleOrderLine(
        Integer    id,
        Integer    productId,
        Integer    quantity,
        BigDecimal amount
    ) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SaleOrderLine (");

        sb.append(id);
        sb.append(", ").append(productId);
        sb.append(", ").append(quantity);
        sb.append(", ").append(amount);

        sb.append(")");
        return sb.toString();
    }
}
