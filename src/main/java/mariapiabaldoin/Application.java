package mariapiabaldoin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mariapiabaldoin.dao.ElementiDAO;
import mariapiabaldoin.dao.PrestitiDAO;
import mariapiabaldoin.dao.UtentiDAO;
import mariapiabaldoin.entities.*;





public class Application {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("progetto-15");


	public static void main(String[] args) {

		EntityManager em = emf.createEntityManager();

		ElementiDAO elementiDAO = new ElementiDAO(em);
		UtentiDAO utentiDAO = new UtentiDAO(em);
		PrestitiDAO prestitiDAO = new PrestitiDAO(em);



		//Elemento libro1 = new Libro("Geronimo Stilton",2008,50,"Geronimo","fantasia");
		//elementiDAO.save(libro1);

		//Elemento rivista1 = new Rivista("Focus",2015,30,Periodicita.SETTIMANALE);
		//elementiDAO.save(rivista1);

		//Elemento rivista2 = new Rivista("Chi",2016,60,Periodicita.SETTIMANALE);
		//elementiDAO.save(rivista2);

		//Elemento rivista3 = new Rivista("Cioè",2011,40,Periodicita.SETTIMANALE);
		//elementiDAO.save(rivista3);

		Elemento libro1 = elementiDAO.getById("9b553b11-93d0-4494-8c4e-9c8ad7f3b3bf");
		Elemento rivista1 = elementiDAO.getById("22e1a8c9-ea37-4f8b-9760-1a38dae1605b");

		//Utente utente1 = new Utente("Mario","Bros",LocalDate.of(2000,8,15));
		//utentiDAO.save(utente1);
		//Utente utente2 = new Utente("Luigi","Bros",LocalDate.of(2000,8,16));
		//utentiDAO.save(utente2);

		Utente utente1 = utentiDAO.getById(1);
		Utente utente2 = utentiDAO.getById(2);



		//Prestito prestito1 = new Prestito(utente1,libro1,LocalDate.of(2024,9,1),LocalDate.of(2024,9,15));
		//prestitiDAO.save(prestito1);
		//Prestito prestito2 = new Prestito(utente1,rivista3,LocalDate.of(2024,10,9),null);
		//prestitiDAO.save(prestito2);
		//Prestito prestito3 = new Prestito(utente2,rivista2,LocalDate.of(2024,9,2),null);
		//prestitiDAO.save(prestito3);
		//Prestito prestito4 = new Prestito(utente2,rivista1,LocalDate.of(2024,9,3),null);
		//prestitiDAO.save(prestito4);

		//elementiDAO.delete("c404a03b-3a65-44ef-8f05-2ba75cbfd288");

		//Elemento trovato = elementiDAO.getById("15472f7d-600c-461b-aa81-77a9f9669d7b");

		//System.out.println(elementiDAO.findByAnnoPubblicazione(2015).toString());
		//System.out.println(elementiDAO.findByAutore("Geronimo").toString());
		//System.out.println(elementiDAO.findByTitolo("Ger").toString());
		//System.out.println(prestitiDAO.findByTessera(1).toString());
		//System.out.println(prestitiDAO.findAllScadutiNonRestituiti().toString());








		em.close();
		emf.close();

	}
}
