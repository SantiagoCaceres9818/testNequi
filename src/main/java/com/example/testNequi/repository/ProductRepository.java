package com.example.testNequi.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.testNequi.model.Producto;

public interface ProductRepository extends CrudRepository<Producto, String> {}
