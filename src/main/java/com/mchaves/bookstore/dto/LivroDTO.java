package com.mchaves.bookstore.dto;

import com.mchaves.bookstore.domain.Livro;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class LivroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "Campo TÍTULO é requerido")
    @Length(min = 3, max = 50, message = "O campo TÍTULO deve ter entre 3 e 50 caracteres")
    private String titulo;
    @NotEmpty(message = "Campo AUTOR é requerido")
    @Length(min = 3, max = 50, message = "O campo AUTOR deve ter entre 3 e 50 caracteres")
    private String autor;
    @NotEmpty(message = "Campo TEXTO é requerido")
    @Length(min = 10, message = "O campo TEXTO deve ter no mínimo 10 caracteres")
    private String texto;

    public LivroDTO() {
        super();
    }

    public LivroDTO(Livro livro) {
        super();
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        this.texto = livro.getTexto();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
