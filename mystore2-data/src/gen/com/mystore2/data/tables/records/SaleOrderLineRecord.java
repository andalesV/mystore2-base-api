/*
 * This file is generated by jOOQ.
*/
package com.mystore2.data.tables.records;


import com.mystore2.data.tables.SaleOrderLine;

import java.math.BigDecimal;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


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
public class SaleOrderLineRecord extends UpdatableRecordImpl<SaleOrderLineRecord> implements Record4<Integer, Integer, Integer, BigDecimal> {

    private static final long serialVersionUID = 1897409876;

    /**
     * Setter for <code>public.sale_order_line.id</code>.
     */
    public SaleOrderLineRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.sale_order_line.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.sale_order_line.product_id</code>.
     */
    public SaleOrderLineRecord setProductId(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.sale_order_line.product_id</code>.
     */
    public Integer getProductId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.sale_order_line.quantity</code>.
     */
    public SaleOrderLineRecord setQuantity(Integer value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.sale_order_line.quantity</code>.
     */
    public Integer getQuantity() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.sale_order_line.amount</code>.
     */
    public SaleOrderLineRecord setAmount(BigDecimal value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.sale_order_line.amount</code>.
     */
    public BigDecimal getAmount() {
        return (BigDecimal) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, Integer, BigDecimal> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, Integer, BigDecimal> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return SaleOrderLine.SALE_ORDER_LINE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return SaleOrderLine.SALE_ORDER_LINE.PRODUCT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return SaleOrderLine.SALE_ORDER_LINE.QUANTITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field4() {
        return SaleOrderLine.SALE_ORDER_LINE.AMOUNT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getProductId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getQuantity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value4() {
        return getAmount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SaleOrderLineRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SaleOrderLineRecord value2(Integer value) {
        setProductId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SaleOrderLineRecord value3(Integer value) {
        setQuantity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SaleOrderLineRecord value4(BigDecimal value) {
        setAmount(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SaleOrderLineRecord values(Integer value1, Integer value2, Integer value3, BigDecimal value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SaleOrderLineRecord
     */
    public SaleOrderLineRecord() {
        super(SaleOrderLine.SALE_ORDER_LINE);
    }

    /**
     * Create a detached, initialised SaleOrderLineRecord
     */
    public SaleOrderLineRecord(Integer id, Integer productId, Integer quantity, BigDecimal amount) {
        super(SaleOrderLine.SALE_ORDER_LINE);

        set(0, id);
        set(1, productId);
        set(2, quantity);
        set(3, amount);
    }
}