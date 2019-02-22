package com.mystore2.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mystore2.data.dto.SaleOrderDto;

public class SaleOrderMapper implements RowMapper<SaleOrderDto> {

	@Override
	public SaleOrderDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		SaleOrderDto saleOrderDto = new SaleOrderDto();
		saleOrderDto.setId(rs.getInt("id"));
		saleOrderDto.setCustomer_name(rs.getString("customer_name"));
		saleOrderDto.setStatus(rs.getString("status"));
		saleOrderDto.setCreated_date(rs.getTimestamp("created_date").toString());
		saleOrderDto.setLast_modified_date(rs.getTimestamp("last_modified_date").toString());
		saleOrderDto.setSale_order_line(null);
		return saleOrderDto;
	}

}
