package com.joseluisestevez.msa.products.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.joseluisestevez.msa.products.models.entity.Product;

public interface ProductDao extends CrudRepository<Product, Long> {

}
