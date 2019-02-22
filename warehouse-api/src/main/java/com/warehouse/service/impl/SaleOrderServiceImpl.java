package com.warehouse.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.api.validation.SaleOrderUpdateRequestValidator;
import com.mystore2.data.dao.SaleOrderDao;
import com.mystore2.data.dto.ProductDetailValidatorDto;
import com.mystore2.data.dto.SaleOrderDto;
import com.warehouse.service.SaleOrderService;

@Service
public class SaleOrderServiceImpl implements SaleOrderService {

	final static Logger logger = Logger.getLogger(SaleOrderServiceImpl.class);

	@Autowired
	private SaleOrderDao saleOrderDao;

	@Autowired
	private SaleOrderUpdateRequestValidator saleOrderUpdateRequestValidator;

	@Override
	public void orderProduct(SaleOrderDto saleOrderDto) {

		// create sale order record
		int saleOrderId = saleOrderDao.insertSaleOrder(saleOrderDto.getCustomer_name());

		// create sale order line record
		List<Integer> saleOrderLineIds = saleOrderDao.batchInsertSaleOrderLine(saleOrderDto, saleOrderId);

		// create product sale order
		saleOrderDao.orderProduct(saleOrderId, saleOrderLineIds);
	}

	@Override
	public void cancelOrder(int orderId) {

	}

	@Override
	public SaleOrderDto getCurrentOrder(int id) {
		return saleOrderDao.getCurrentOrder(id);
	}

	@Override
	public List<SaleOrderDto> viewAllSales() {

		return null;
	}

	@Override
	public void batchUpdateSaleOrderLine(SaleOrderDto saleOrderDto, int saleOrderId) {

		// TODO: Need to create function that fetch product detail result set
		List<ProductDetailValidatorDto> productDetailDto = null;

		saleOrderUpdateRequestValidator.validate(productDetailDto, saleOrderDto);

		int[] rowAffected = saleOrderDao.batchUpdateSaleOrderLine(saleOrderDto, saleOrderId);

		if (rowAffected.length > 0)
			logger.info("Batch update success!");

	}

}
