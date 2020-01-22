package com.joseluisestevez.msa.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseluisestevez.msa.products.models.entity.Product;
import com.joseluisestevez.msa.products.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public List<Product> list() {
		return productService.findAll();
	}
	
	@GetMapping("/view/{id}")
	public Product view(Long id) {
		return productService.findById(id);
	}
}
