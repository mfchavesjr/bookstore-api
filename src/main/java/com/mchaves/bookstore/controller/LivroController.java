package com.mchaves.bookstore.controller;

import com.mchaves.bookstore.domain.Livro;
import com.mchaves.bookstore.dto.LivroDTO;
import com.mchaves.bookstore.service.LivroService;
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
@RequestMapping(value = "/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroDTO>> listAll(){
        List<Livro> livroList = livroService.listAll();
        List<LivroDTO> livroDTOList = livroList
                .stream()
                .map(LivroDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(livroDTOList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id){
        return ResponseEntity.ok(livroService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Livro> create(@Valid @RequestBody Livro livro){
        Livro livroSaved = livroService.save(livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(livroSaved.getId()).toUri();
        return ResponseEntity.created(uri).body(livroSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> update(@Valid @RequestBody LivroDTO livroDTO, @PathVariable Integer id){
        Livro livro = livroService.update(livroDTO, id);
        LivroDTO livroDTOCreated = new LivroDTO(livro);
        return ResponseEntity.ok().body(livroDTOCreated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        livroService.delete(id);
    }
}
