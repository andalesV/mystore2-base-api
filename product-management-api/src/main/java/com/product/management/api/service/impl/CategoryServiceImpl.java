package com.product.management.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystore2.data.dao.CategoryDao;
import com.mystore2.data.dto.CategoryDto;
import com.product.management.api.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public void create(CategoryDto categoryDto) {
		categoryDao.create(categoryDto);
	}

	@Override
	public void delete(String code) {
		categoryDao.delete(code);
	}

	@Override
	public CategoryDto fetch(String code) {
		return categoryDao.fetch(code);
	}

	@Override
	public List<CategoryDto> fetchAllCategory() {
		return categoryDao.fetchAll();
	}

	@Override
	public void update(CategoryDto categoryDto) {
		categoryDao.update(categoryDto);
	}

}
