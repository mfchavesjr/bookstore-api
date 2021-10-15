package com.mchaves.bookstore.service;

import com.mchaves.bookstore.domain.Categoria;
import com.mchaves.bookstore.dto.CategoriaDTO;
import com.mchaves.bookstore.exception.DataIntegrityViolationExceptionCategoria;
import com.mchaves.bookstore.exception.ObjectNotFoundException;
import com.mchaves.bookstore.repository.CategoriaRepostiory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        return categoriaRepostiory.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Recurso não encontrado!"));
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepostiory.save(categoria);
    }

    public Categoria update(CategoriaDTO categoriaDTO, Integer id) {
        Categoria categoriaSaved = findById(id);
        BeanUtils.copyProperties(categoriaDTO, categoriaSaved, "id");
        categoriaRepostiory.save(categoriaSaved);
        return categoriaSaved;
    }

    public void delete(Integer id) {
        try {
            categoriaRepostiory.delete(findById(id));
        }catch (DataIntegrityViolationException exception){
            throw new DataIntegrityViolationExceptionCategoria("Recurso não pode ser excluído, contém livros associados");
        }

    }
}
