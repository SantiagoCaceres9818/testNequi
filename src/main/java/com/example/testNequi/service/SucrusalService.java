package com.example.testNequi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.testNequi.model.Franquicia;
import com.example.testNequi.model.Producto;
import com.example.testNequi.model.Sucursal;
import com.example.testNequi.repository.FranquiciaRepository;

@Service
public class SucrusalService {
    
    private Map<String, Sucursal> sucursales = new HashMap<>();
    private FranquiciaRepository franquiciaRepository;
    // private SucursalRepository sucursalRepository;

    public SucrusalService(FranquiciaRepository franquiciaRepository) {
        this.franquiciaRepository = franquiciaRepository;
    }

    public Sucursal addBranchToFranchise(String franchiseId, Sucursal sucursal) {
        sucursal.setId(UUID.randomUUID().toString());
        sucursales.put(sucursal.getId(), sucursal);
        sucursal.setId(UUID.randomUUID().toString());
        Franquicia franquicia = franquiciaRepository.findById(franchiseId)
        .orElseThrow(() -> new NoSuchElementException("Franquicia no encontrada con ID: " + franchiseId));
        if (franquicia == null) {
            throw new RuntimeException("Franquicia no encontrada");
        }
        franquicia.addSucursal(sucursal);
        franquiciaRepository.save(franquicia);
        return sucursal;
        
    }

    public List<Producto> getHighestStockProductsByFranchise(String franchiseId) {
        Franquicia franquicia = franquiciaRepository.findById(franchiseId).orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));
        List<Producto> highestStockProducts = new ArrayList<>();

        for (Sucursal sucursal : franquicia.getSucursales()) {
            Producto highestStockProduct = sucursal.getProductos().stream()
                .max((p1, p2) -> Integer.compare(p1.getStock(), p2.getStock()))
                .orElse(null);

            if (highestStockProduct != null) {
                highestStockProducts.add(highestStockProduct);
            }
        }
        return highestStockProducts;
    }
}
