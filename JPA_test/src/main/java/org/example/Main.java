package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.SQLOutput;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        // Instancia del DAO
        LibroDAO libroDAO = new LibroDAO();

        // 1. Agregar Libros
        Libro libro1 = new Libro();
        libro1.setId(1L);
        libro1.setTitulo("El principazo");
        libro1.setAutor("The GOAT");
        libro1.setPrecio(10.0);

        Libro libro2 = new Libro();
        libro2.setId(2L);
        libro2.setTitulo("1984");
        libro2.setAutor("George Orwell");
        libro2.setPrecio(15.0);

        libroDAO.agregarLibro(libro1);
        libroDAO.agregarLibro(libro2);

        // 2. Obtener un libro por ID y mostrarlo
        Libro libroObtenido = libroDAO.obtenerLibro(1L);
        System.out.println("Libro obtenido: " + libroObtenido.getTitulo());

        // 3. Actualizar un libro
        libroObtenido.setPrecio(12.0);
        libroDAO.actualizarLibro(libroObtenido);

        // 4. Consulta adicional

        List<Libro> librosCaros = libroDAO.librosPorPrecioMinimo(10.0);
        System.out.println("Libros con precio mayor a 10: ");
        for (Libro libro : librosCaros) {
            System.out.println(libro.getTitulo() + " - " + libro.getPrecio());
        }

        // 5. Eliminar un libro
        libroDAO.eliminarLibro(1L);
    }
}