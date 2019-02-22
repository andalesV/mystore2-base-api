package com.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mystore2.data.dto.SaleOrderDto;
import com.warehouse.service.SaleOrderService;

@RestController
@RequestMapping("/warehouse")
public class SaleOrderController {

	@Autowired
	private SaleOrderService saleOrderService;
	
	@PostMapping("/sale-order")
	public void orderProduct(@RequestBody SaleOrderDto saleOrderDto) {
		saleOrderService.orderProduct(saleOrderDto);
	}
	
	@GetMapping("/view-sale-order/{id}")
	public SaleOrderDto viewCurrentOrder(@PathVariable int id) {
		return saleOrderService.getCurrentOrder(id);
	}
	
	@PutMapping("/update-sale-order")
	public void updateSaleOrder(@RequestParam int saleOrderId, @RequestBody SaleOrderDto saleOrderDto) {
		saleOrderService.batchUpdateSaleOrderLine(saleOrderDto, saleOrderId);
	}
}
