package com.example.testNequi.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Data
@RedisHash("Sucursal")
public class Sucursal {

    private String id;
    private String nombre;
    private List<Producto> productos = new ArrayList<>();

    
    public Sucursal(String id, String nombre, List<Producto> productos) {
        this.id = id;
        this.nombre = nombre;
        this.productos = productos;
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
    public List<Producto> getProductos() {
        return productos;
    }
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    
}
