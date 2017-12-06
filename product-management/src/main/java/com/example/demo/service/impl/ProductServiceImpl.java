package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepository;
import com.example.demo.service.ProductService;


@Service("ProductService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product get(Long id) {
		return productRepository.findOne(id);
	}

	@Override
	public List<Product> getProductsForPrice(Double price) {
		return productRepository.findAllProductsForPrice(price);
	}
	
}