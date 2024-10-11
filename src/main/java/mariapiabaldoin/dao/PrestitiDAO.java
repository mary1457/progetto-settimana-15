package mariapiabaldoin.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import mariapiabaldoin.entities.Elemento;
import mariapiabaldoin.entities.Prestito;
import mariapiabaldoin.exceptions.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public class PrestitiDAO {

    private final EntityManager entityManager;

    public PrestitiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Prestito newPrestito) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPrestito);
        transaction.commit();

        System.out.println("Il prestito " + newPrestito + " è stato salvato");

    }

    public Prestito getById(long prestitoId) {
        Prestito found = entityManager.find(Prestito.class, prestitoId);
        if (found == null) throw new NotFoundException(prestitoId);
        System.out.println(found.toString());
        return found;
    }

    public void delete(long prestitoId) {


        Prestito found = this.getById(prestitoId);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();

        System.out.println("Il prestito" + found + " è stato eliminato");

    }

    public List<Prestito> findByTessera( long numero_tessera) {
        TypedQuery<Prestito> query = entityManager.createQuery("SELECT p FROM Prestito p WHERE p.utente.id = :tessera AND p.dataFine >= :data_odierna AND p.dataRestituzione IS NULL ", Prestito.class);
        query.setParameter("tessera", numero_tessera);
        query.setParameter("data_odierna", LocalDate.now());
        return query.getResultList();
    }

    public List<Prestito> findAllScadutiNonRestituiti( ) {
        TypedQuery<Prestito> query = entityManager.createQuery("SELECT p FROM Prestito p WHERE p.dataFine < :data_odierna AND p.dataRestituzione IS NULL ", Prestito.class);
        query.setParameter("data_odierna", LocalDate.now());
        return query.getResultList();
    }
}
