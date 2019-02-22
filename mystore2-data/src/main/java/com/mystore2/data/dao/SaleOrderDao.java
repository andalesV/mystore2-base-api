package com.mystore2.data.dao;

import java.util.List;

import com.mystore2.data.dto.SaleOrderDto;

public interface SaleOrderDao {

public int insertSaleOrder(String customer_name);
	
	public List<Integer> batchInsertSaleOrderLine(SaleOrderDto saleOrderDto, int saleOrderId);
	
	public void orderProduct(int saleOrderId, List<Integer> saleOrderLineIds);
	
	public int[] batchUpdateSaleOrderLine(SaleOrderDto saleOrderDto, int saleOrderId);

	public SaleOrderDto getCurrentOrder(int id);

	public List<SaleOrderDto> viewAllSales();

	public void cancelOrder(int orderId);

}
