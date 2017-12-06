package com.example.demo.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.impl.ProductServiceImpl;


@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	protected Logger logger = Logger.getLogger(ProductServiceImpl.class
			.getName());
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("/product/{id}")
	public Product get(@PathVariable Long id) {
		logger.info("ACCESSED");;
		return productService.get(id);
	}
	
	@RequestMapping("/product/{price}")
	public List<Product> getProductsForPrice(@PathVariable Double price) {
		return productService.getProductsForPrice(price);
	}
	
}