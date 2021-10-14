package com.mchaves.bookstore.service;

import com.mchaves.bookstore.domain.Categoria;
import com.mchaves.bookstore.repository.CategoriaRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepostiory categoriaRepostiory;

    public List<Categoria> listAll() {
        return categoriaRepostiory.findAll();
    }

    public Categoria findById(Integer id) {
        return categoriaRepostiory.findById(id).orElseThrow();
    }


}
