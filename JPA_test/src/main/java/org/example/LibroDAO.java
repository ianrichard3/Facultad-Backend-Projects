package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class LibroDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TiendaLibros");
    private EntityManager em = emf.createEntityManager();

    public void agregarLibro(Libro libro) {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }

    public Libro obtenerLibro(long id) {
        return em.find(Libro.class, id);
    }

    public void actualizarLibro(Libro libro) {
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
    }

    public void eliminarLibro(long id) {
        em.getTransaction().begin();
        Libro libro = em.find(Libro.class, id);
        if (libro != null) {
            em.remove(libro);
        }
        em.getTransaction().commit();
    }

    public List<Libro> librosPorPrecioMinimo(double precioMinimo) {
        TypedQuery<Libro> query = em.createQuery(
                "SELECT l FROM Libro l WHERE l.precio > :precioMinimo",
                Libro.class);
        query.setParameter("precioMinimo", precioMinimo);
        return query.getResultList();
    }


}
