package mariapiabaldoin.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mariapiabaldoin.entities.Utente;
import mariapiabaldoin.exceptions.NotFoundException;

public class UtentiDAO {

    private final EntityManager entityManager;

    public UtentiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Utente newUtente) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newUtente);
        transaction.commit();

        System.out.println("L' utente " + newUtente + " è stato salvato");

    }

    public Utente getById(long utenteId) {
        Utente found = entityManager.find(Utente.class, utenteId);
        if (found == null) throw new NotFoundException(utenteId);
        System.out.println(found.toString());
        return found;
    }

    public void delete(long utenteId) {


        Utente found = this.getById(utenteId);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();

        System.out.println("L' utente" + found + " è stato eliminato");

    }
}
