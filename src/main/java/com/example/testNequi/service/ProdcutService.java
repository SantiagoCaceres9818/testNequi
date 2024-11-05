package com.example.testNequi.service;

import java.util.NoSuchElementException;
import java.util.UUID;

import com.example.testNequi.model.Producto;
import com.example.testNequi.model.Sucursal;
import com.example.testNequi.repository.ProductRepository;
import com.example.testNequi.repository.SucursalRepository;

public class ProdcutService {
    
    private ProductRepository productRepository;
    private SucursalRepository sucursalRepository;

    public Producto addProductToBranch (String branchId, Producto producto){
        producto.setId(UUID.randomUUID().toString());
        Sucursal sucursal = sucursalRepository.findById(branchId).orElseThrow(
            () -> new NoSuchElementException("Franquicia no encontrada con ID: " + branchId));
        if(sucursal != null){
            sucursal.getProductos().add(producto);
            productRepository.save(producto);
            sucursalRepository.save(sucursal);
        }
        return producto;
    }

    public Producto updateProductoStock(String productId, int stock){
        Producto producto = productRepository.findById(productId).orElseThrow(
            () -> new NoSuchElementException("Franquicia no encontrada con ID: " + productId));
        if (producto != null) {
            producto.setStock(stock);
            productRepository.save(producto);
            return producto;
        }
        return null;
    }
}
