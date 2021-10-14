package com.mchaves.bookstore.controller;

import com.mchaves.bookstore.domain.Categoria;
import com.mchaves.bookstore.dto.CategoriaDTO;
import com.mchaves.bookstore.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listAll(){
        List<Categoria> categoriaList = categoriaService.listAll();
        List<CategoriaDTO> categoriaDTOList = categoriaList
                .stream()
                .map(CategoriaDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(categoriaDTOList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
        return ResponseEntity.ok(categoriaService.findById(id));
    }
}
