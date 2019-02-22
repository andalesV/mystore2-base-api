package com.product.management.api.service;

import java.util.List;

import com.mystore2.data.dto.CategoryDto;


public interface CategoryService {

	public CategoryDto fetch(String code);
	
	public List<CategoryDto> fetchAllCategory();
	
	public void create(CategoryDto categoryDto);
	
	public void update(CategoryDto categoryDto);
	
	public void delete(String code);
}
