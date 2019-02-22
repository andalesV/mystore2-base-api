package com.mystore2.data.dao;

import java.util.List;

import com.mystore2.data.dto.CategoryDto;

public interface CategoryDao {

	public void create(CategoryDto categoryDto);

	public void delete(String code);

	public CategoryDto fetch(String code);

	public List<CategoryDto> fetchAll();

	public void update(CategoryDto categoryDto);
}
