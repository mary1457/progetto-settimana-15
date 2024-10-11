package mariapiabaldoin.entities;

import jakarta.persistence.*;


@Entity

@Table(name = "riviste")

public class  Rivista extends Elemento {

    @Column(name = "periodicita", nullable = false)
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista(String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Rivista() {

    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                "} " + super.toString();
    }
}
