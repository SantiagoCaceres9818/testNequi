package com.example.testNequi.model;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Data
@RedisHash("Producto")
public class Producto {
    
    private String id;
    private String nombre;
    private int stock;

    public Producto(String id, String nombre, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    
}
