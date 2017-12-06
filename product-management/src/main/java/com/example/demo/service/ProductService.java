package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
	public Product get(Long id);
	public List<Product> getProductsForPrice(Double id);
	
}
