package com.mystore2.data.dto;

import java.util.List;

public class SaleOrderDto {

	private int id;

	private String customer_name;

	private String status;

	private String created_date;

	private String last_modified_date;

	private List<SaleOrderLineDto> sale_order_line;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<SaleOrderLineDto> getSale_order_line() {
		return sale_order_line;
	}

	public void setSale_order_line(List<SaleOrderLineDto> sale_order_line) {
		this.sale_order_line = sale_order_line;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getLast_modified_date() {
		return last_modified_date;
	}

	public void setLast_modified_date(String last_modified_date) {
		this.last_modified_date = last_modified_date;
	}

}