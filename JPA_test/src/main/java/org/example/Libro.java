package org.example;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Libro {
    @Id
    private long id;
    private String titulo;
    private String autor;
    private double precio;

    public void setAutor(String autor){
        this.autor = autor;
    }
    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public double getPrecio() {
        return precio;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }


}
