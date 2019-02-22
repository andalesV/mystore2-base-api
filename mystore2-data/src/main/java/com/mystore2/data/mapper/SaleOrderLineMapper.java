package com.mystore2.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.mystore2.data.dto.SaleOrderLineDto;

public class SaleOrderLineMapper implements RowMapper<SaleOrderLineDto> {

	@Override
	public SaleOrderLineDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		SaleOrderLineDto saleOrderLineDto = new SaleOrderLineDto();
		saleOrderLineDto.setId(rs.getInt("id"));
		saleOrderLineDto.setProduct_id(rs.getInt("product_id"));
		saleOrderLineDto.setProduct_name(rs.getString("product_name"));
		saleOrderLineDto.setDescription(rs.getString("description"));
		saleOrderLineDto.setQuantity(rs.getInt("quantity"));
		saleOrderLineDto.setAmount(rs.getBigDecimal("amount"));

		return saleOrderLineDto;
	}

}
