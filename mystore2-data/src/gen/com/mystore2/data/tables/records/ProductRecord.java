/*
 * This file is generated by jOOQ.
*/
package com.mystore2.data.tables.records;


import com.mystore2.data.tables.Product;

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
public class ProductRecord extends UpdatableRecordImpl<ProductRecord> implements Record5<Integer, String, String, String, String> {

    private static final long serialVersionUID = -1931001711;

    /**
     * Setter for <code>public.product.id</code>.
     */
    public ProductRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.product.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.product.product_code</code>.
     */
    public ProductRecord setProductCode(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.product.product_code</code>.
     */
    public String getProductCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.product.product_name</code>.
     */
    public ProductRecord setProductName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.product.product_name</code>.
     */
    public String getProductName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.product.description</code>.
     */
    public ProductRecord setDescription(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.product.description</code>.
     */
    public String getDescription() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.product.image_url</code>.
     */
    public ProductRecord setImageUrl(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.product.image_url</code>.
     */
    public String getImageUrl() {
        return (String) get(4);
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
    public Row5<Integer, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Product.PRODUCT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Product.PRODUCT.PRODUCT_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Product.PRODUCT.PRODUCT_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Product.PRODUCT.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Product.PRODUCT.IMAGE_URL;
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
    public String value2() {
        return getProductCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getProductName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getImageUrl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord value2(String value) {
        setProductCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord value3(String value) {
        setProductName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord value4(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord value5(String value) {
        setImageUrl(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductRecord values(Integer value1, String value2, String value3, String value4, String value5) {
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
     * Create a detached ProductRecord
     */
    public ProductRecord() {
        super(Product.PRODUCT);
    }

    /**
     * Create a detached, initialised ProductRecord
     */
    public ProductRecord(Integer id, String productCode, String productName, String description, String imageUrl) {
        super(Product.PRODUCT);

        set(0, id);
        set(1, productCode);
        set(2, productName);
        set(3, description);
        set(4, imageUrl);
    }
}
