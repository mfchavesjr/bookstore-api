package com.mchaves.bookstore.repository;

import com.mchaves.bookstore.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepostiory extends JpaRepository<Categoria, Integer> {
}
