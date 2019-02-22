/*
 * This file is generated by jOOQ.
*/
package com.mystore2.data.tables.records;


import com.mystore2.data.tables.ProductDetail;

import java.math.BigDecimal;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class ProductDetailRecord extends UpdatableRecordImpl<ProductDetailRecord> implements Record5<Integer, Boolean, Integer, BigDecimal, Integer> {

    private static final long serialVersionUID = 1778921659;

    /**
     * Setter for <code>public.product_detail.id</code>.
     */
    public ProductDetailRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.product_detail.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.product_detail.isavailable</code>.
     */
    public ProductDetailRecord setIsavailable(Boolean value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.product_detail.isavailable</code>.
     */
    public Boolean getIsavailable() {
        return (Boolean) get(1);
    }

    /**
     * Setter for <code>public.product_detail.quantity</code>.
     */
    public ProductDetailRecord setQuantity(Integer value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.product_detail.quantity</code>.
     */
    public Integer getQuantity() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.product_detail.price</code>.
     */
    public ProductDetailRecord setPrice(BigDecimal value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.product_detail.price</code>.
     */
    public BigDecimal getPrice() {
        return (BigDecimal) get(3);
    }

    /**
     * Setter for <code>public.product_detail.product_id</code>.
     */
    public ProductDetailRecord setProductId(Integer value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.product_detail.product_id</code>.
     */
    public Integer getProductId() {
        return (Integer) get(4);
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
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, Boolean, Integer, BigDecimal, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, Boolean, Integer, BigDecimal, Integer> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return ProductDetail.PRODUCT_DETAIL.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field2() {
        return ProductDetail.PRODUCT_DETAIL.ISAVAILABLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return ProductDetail.PRODUCT_DETAIL.QUANTITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field4() {
        return ProductDetail.PRODUCT_DETAIL.PRICE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return ProductDetail.PRODUCT_DETAIL.PRODUCT_ID;
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
    public Boolean value2() {
        return getIsavailable();
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
        return getPrice();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getProductId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductDetailRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductDetailRecord value2(Boolean value) {
        setIsavailable(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductDetailRecord value3(Integer value) {
        setQuantity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductDetailRecord value4(BigDecimal value) {
        setPrice(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductDetailRecord value5(Integer value) {
        setProductId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductDetailRecord values(Integer value1, Boolean value2, Integer value3, BigDecimal value4, Integer value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ProductDetailRecord
     */
    public ProductDetailRecord() {
        super(ProductDetail.PRODUCT_DETAIL);
    }

    /**
     * Create a detached, initialised ProductDetailRecord
     */
    public ProductDetailRecord(Integer id, Boolean isavailable, Integer quantity, BigDecimal price, Integer productId) {
        super(ProductDetail.PRODUCT_DETAIL);

        set(0, id);
        set(1, isavailable);
        set(2, quantity);
        set(3, price);
        set(4, productId);
    }
}