package com.warehouse.service;

import java.util.List;

import com.mystore2.data.dto.SaleOrderDto;

public interface SaleOrderService {
	public void orderProduct(SaleOrderDto saleOrderDto);

	public void cancelOrder(int orderId);

	public SaleOrderDto getCurrentOrder(int id);

	public List<SaleOrderDto> viewAllSales();

	public void batchUpdateSaleOrderLine(SaleOrderDto saleOrderDto, int saleOrderId);

}
