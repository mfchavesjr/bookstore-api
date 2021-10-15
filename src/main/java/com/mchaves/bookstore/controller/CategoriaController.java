package com.mchaves.bookstore.controller;

import com.mchaves.bookstore.domain.Categoria;
import com.mchaves.bookstore.dto.CategoriaDTO;
import com.mchaves.bookstore.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria categoria){
        Categoria categoriaSaved = categoriaService.save(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(categoriaSaved.getId()).toUri();
        return ResponseEntity.created(uri).body(categoriaSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@Valid @RequestBody CategoriaDTO categoriaDTO, @PathVariable Integer id){
        Categoria categoria = categoriaService.update(categoriaDTO, id);
        CategoriaDTO categoriaDTOCreated = new CategoriaDTO(categoria);
        return ResponseEntity.ok().body(categoriaDTOCreated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
            categoriaService.delete(id);
    }
}
