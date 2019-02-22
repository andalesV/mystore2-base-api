package com.product.management.api.controller;

import static com.common.api.constants.ErrorHandlerConstants.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.api.custom.exception.EntityNotFoundException;
import com.mystore2.data.dto.CategoryDto;
import com.product.management.api.service.CategoryService;

@RestController
@RequestMapping("/product-management/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/create")
	public void createCategory(@RequestBody CategoryDto categoryDto) throws HttpRequestMethodNotSupportedException {
		categoryService.create(categoryDto);
	}

	@DeleteMapping("/delete/{code}")
	public void delete(@PathVariable("code") String code) throws HttpRequestMethodNotSupportedException {
		categoryService.delete(code);
	}

	@GetMapping("/fetch/{code}")
	public CategoryDto fetch(@PathVariable("code") String code) throws HttpRequestMethodNotSupportedException {

		CategoryDto categoryDto = categoryService.fetch(code);

		if (null == categoryDto)
			throw new EntityNotFoundException(CategoryDto.class.getName() + ENTITY_NOT_FOUND_EXCEPTION_MESSAGE);

		return categoryDto;
	}

	@GetMapping("/fetchAll")
	public List<CategoryDto> fetchAll() throws HttpRequestMethodNotSupportedException {

		List<CategoryDto> resultList = categoryService.fetchAllCategory();

		if (resultList.isEmpty())
			throw new EntityNotFoundException(CategoryDto.class.getName() + ENTITY_NOT_FOUND_EXCEPTION_MESSAGE);

		return resultList;
	}

	@PutMapping("/update")
	public void update(@RequestBody CategoryDto categoryDto) throws HttpRequestMethodNotSupportedException {
		categoryService.update(categoryDto);
	}
}