package com.joseluisestevez.msa.products.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.joseluisestevez.msa.products.models.entity.Product;
import com.joseluisestevez.msa.products.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private Environment env;

	@GetMapping("/list")
	public List<Product> list() {
		return productService.findAll().stream().map(product -> {
			product.setPort(
					Integer.parseInt(env.getProperty("local.server.port")));
			return product;
		}).collect(Collectors.toList());
	}

	@GetMapping("/view/{id}")
	public Product view(@PathVariable Long id) {
		Product product = productService.findById(id);
		product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return product;
	}
}
