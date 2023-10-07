//package org.example;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//
//
//public class TestBook {
//
//    private static EntityManager manager;
//    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
//
//
//    public static void main(String[] args) {
//        // Creacion de gestor de persistencia
//
//        manager = emf.createEntityManager();
//        // Insercion de registros
//        Book b1 = new Book("4214-151-241-322", "Flaquito");
//        Book b2 = new Book("3211-122-3-124", "El libro increible");
//
//        // Iniciando una transaccion
//        manager.getTransaction().begin();
//        manager.persist(b1); // Convierte la entidad en Entity Managed (facilita JPA)
//        manager.persist(b2); // Al ser managed permite realizar operaciones extra
//
//        // Modificacion de un atributo
//        b1.setTitle("Flaquito Modificado");
//
//        // Modificacion de todo
//        // b1 = manager.merge(<nuevoObjeto>)
//
//        // Eliminacion de elemento
//        manager.remove(b1);
//
//        // Commiteando transaccion
//        manager.getTransaction().commit();
//
//
//
//
//
//
//        // Consulta de la tabla libros
//        List<Book> books = (List<Book>) manager.createQuery("FROM Book").getResultList();
//        System.out.println("En esta base de datos hay " + books.size() + " registros.");
//        for (Book b : books) {
//            System.out.println(b.toString());
//        }
//
//
//        // Cerrar el manager para que no este siempre ejecutandose
//        manager.close();
//
//    }
//
//
//}
