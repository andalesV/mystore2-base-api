package com.mystore2.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mystore2.data.dto.CategoryDto;

public class CategoryMapper implements RowMapper<CategoryDto> {

	@Override
	public CategoryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(rs.getInt("id"));
		categoryDto.setCode(rs.getString("code"));
		categoryDto.setName(rs.getString("name"));
		return categoryDto;
	}
}