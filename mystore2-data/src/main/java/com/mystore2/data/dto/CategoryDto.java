package com.mystore2.data.dto;

import javax.validation.constraints.NotNull;

public class CategoryDto {

	private String code;

	private int id;

	@NotNull
	private String name;

	public String getCode() {
		return code;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
