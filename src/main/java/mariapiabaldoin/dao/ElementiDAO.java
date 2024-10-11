package mariapiabaldoin.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import mariapiabaldoin.entities.Elemento;
import mariapiabaldoin.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public class ElementiDAO {

    private final EntityManager entityManager;

    public ElementiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Elemento newElemento) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newElemento);
        transaction.commit();

        System.out.println("L' elemento " + newElemento + " è stato salvato");

    }

    public Elemento getById(String elementoId) {
        Elemento found = entityManager.find(Elemento.class, UUID.fromString(elementoId) );
        if (found == null) throw new NotFoundException(elementoId);
        System.out.println(found.toString());
        return found;
    }

    public void delete(String elementoId) {


        Elemento found = this.getById(elementoId);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();

        System.out.println("L' elemento " + found + " è stato eliminato");

    }

    public List<Elemento> findByAnnoPubblicazione(int anno) {
        TypedQuery<Elemento> query = entityManager.createQuery("SELECT e FROM Elemento e WHERE e.annoPubblicazione = :annoPubblicazione", Elemento.class);
        query.setParameter("annoPubblicazione", anno);
        return query.getResultList();
    }

    public List<Elemento> findByAutore(String autore) {
        TypedQuery<Elemento> query = entityManager.createQuery("SELECT e FROM Elemento e WHERE e.autore = :autore", Elemento.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List<Elemento> findByTitolo(String partialTitolo) {
        TypedQuery<Elemento> query = entityManager.createNamedQuery("findByTitoloParziale", Elemento.class);
        query.setParameter("partialTitolo", partialTitolo + "%");
        return query.getResultList();
    }
}

