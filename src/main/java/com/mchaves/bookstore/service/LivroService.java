package com.mchaves.bookstore.service;

import com.mchaves.bookstore.domain.Categoria;
import com.mchaves.bookstore.domain.Livro;
import com.mchaves.bookstore.dto.CategoriaDTO;
import com.mchaves.bookstore.dto.LivroDTO;
import com.mchaves.bookstore.exception.DataIntegrityViolationExceptionLivro;
import com.mchaves.bookstore.exception.ObjectNotFoundException;
import com.mchaves.bookstore.repository.LivroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro findById(Integer id) {
        return livroRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Recurso não encontrado!"));
    }

    public List<Livro> listAll() {
        return livroRepository.findAll();
    }

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro update(LivroDTO livroDTO, Integer id) {
        Livro livroSaved = findById(id);
        BeanUtils.copyProperties(livroDTO, livroSaved, "id");
        livroRepository.save(livroSaved);
        return livroSaved;
    }

    public void delete(Integer id) {
        try {
            livroRepository.delete(findById(id));
        }catch (DataIntegrityViolationException exception){
            throw new DataIntegrityViolationExceptionLivro("Recurso não pode ser excluído, contém categoria associado");
        }

    }
}
