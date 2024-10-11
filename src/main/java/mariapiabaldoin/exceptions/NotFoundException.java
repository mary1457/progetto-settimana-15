package mariapiabaldoin.exceptions;

public class NotFoundException extends RuntimeException {
	public NotFoundException(String id) {super("L'" + id + " non è stato trovato");
	}

	public NotFoundException(long id) {super("L'" + id + " non è stato trovato");
	}


}

