package com.example.testNequi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testNequi.model.Franquicia;
import com.example.testNequi.model.Producto;
import com.example.testNequi.model.Sucursal;
import com.example.testNequi.service.FranquiciaService;
import com.example.testNequi.service.ProdcutService;
import com.example.testNequi.service.SucrusalService;




@RestController
@RequestMapping("/api/franquicias")
public class FranquiciaController {
    
    private FranquiciaService franquiciaService;
    private SucrusalService sucrusalService;
    private ProdcutService prodcutService;

    public FranquiciaController(FranquiciaService franquiciaService) {
        this.franquiciaService = franquiciaService;
    }

    // create new franchise
    @PostMapping
    public Franquicia addFranquicia(@RequestBody Franquicia franquicia) {
        
        return franquiciaService.createFranquicia(franquicia);
    }

    // update franchise by id
    @PatchMapping("/{id}")
    public Franquicia updateFranquicia (@PathVariable String id, @RequestBody Map<String, String> request){
        return franquiciaService.updateFranquiciaName(id, request.get("Name"));
    }

    // Agree new sucursal for franchise
    @PostMapping("/{franchiseId}/branch")
    public Sucursal addSucursalToFranquicia( @PathVariable String franchiseId, @RequestBody Sucursal sucursal){
        return sucrusalService.addBranchToFranchise(franchiseId, sucursal);
    }

    //Agree new producto for sucursal
    @PostMapping("/branch/{branchId}/products")
    public Producto addProductToBrach(@RequestBody Producto producto, @PathVariable String branchId) {
        return prodcutService.addProductToBranch(branchId, producto);
    }

    //Modify stock product
    @PutMapping("products/{productId}")
    public Producto updateProductStock(@PathVariable String productId, @RequestBody int stoack) {    
        return prodcutService.updateProductoStock(productId, stoack);
    }

    // Get stock most cuantity
    @GetMapping("/{franchiseId}/highest-stock-products")
    public List<Producto> getHighestProduct(@PathVariable String franchiseId) {
        return sucrusalService.getHighestStockProductsByFranchise(franchiseId);
    }

    // Update name franchise
    @PutMapping("/{franchiseId}")
    public Franquicia updateFranchiseName(@PathVariable String id, @RequestBody String newName) {        
        return franquiciaService.updateFranquiciaName(id, newName);
    }
    
    


    
}
