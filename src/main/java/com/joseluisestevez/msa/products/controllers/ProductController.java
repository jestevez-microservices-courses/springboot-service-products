package com.joseluisestevez.msa.products.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.joseluisestevez.msa.commons.products.dto.ProductDto;
import com.joseluisestevez.msa.products.models.entity.Product;
import com.joseluisestevez.msa.products.service.ProductService;
import com.joseluisestevez.msa.utils.dto.DtoUtils;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	private final DtoUtils<ProductDto, Product> dtoUtils = new DtoUtils<>(
			ProductDto.class, Product.class);

	@Value("${server.port}")
	private Integer port;

	@GetMapping("/list")
	public List<ProductDto> list() {
		return productService.findAll().stream().map(product -> {
			product.setPort(port);
			return dtoUtils.convertToDto(product);
		}).collect(Collectors.toList());
	}

	@GetMapping("/view/{id}")
	public ProductDto view(@PathVariable Long id) {
		Product product = productService.findById(id);
		product.setPort(port);
		return dtoUtils.convertToDto(product);
	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDto create(@RequestBody ProductDto productDto) {
		return dtoUtils.convertToDto(
				productService.save(dtoUtils.convertToEntity(productDto)));
	}

	@PutMapping("/edit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDto edit(@RequestBody ProductDto productDto,
			@PathVariable Long id) {
		Product productDb = productService.findById(id);
		productDb.setName(productDto.getName());
		productDb.setPrice(productDto.getPrice());
		return dtoUtils.convertToDto(productService.save(productDb));
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		productService.deleteById(id);
	}

}
