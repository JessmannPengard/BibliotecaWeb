package com.formacom.biblioteca.Models;

public class Libro {

    Integer id;
    String codigo;
    String titulo;
    String genero;

    public Libro() {
    }

    public Libro(int id, String codigo, String titulo, String genero) {
        this.id = id;
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}'+"\n";
    }

}
