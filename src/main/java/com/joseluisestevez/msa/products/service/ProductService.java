package com.joseluisestevez.msa.products.service;

import java.util.List;

import com.joseluisestevez.msa.products.models.entity.Product;

public interface ProductService {

	List<Product> findAll();
	
	Product findById(Long id);
}
