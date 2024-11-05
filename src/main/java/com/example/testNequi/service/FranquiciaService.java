package com.example.testNequi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testNequi.model.Franquicia;
import com.example.testNequi.repository.FranquiciaRepository;

@Service
public class FranquiciaService {

    private Map<String, Franquicia> franquicias = new HashMap<>();

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    public Franquicia createFranquicia (Franquicia franquicia){
        return franquiciaRepository.save(franquicia);
    }

    public Franquicia updateFranquiciaName (String id, String newName){
        Franquicia franquicia = franquicias.get(id);
        if (franquicia != null) {
            franquicia.setNombre(newName);
        }
        return franquicia;
    }
    
    
}
