package mariapiabaldoin.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestiti")

public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "elemento_id")
    private Elemento elemento;

    @Column(name = "data_inizio", nullable = false)
    private LocalDate dataInizio;

    @Column(name = "data_fine", nullable = false)
    private LocalDate dataFine;

    @Column(name = "data_restituzione", nullable = true)
    private LocalDate dataRestituzione;

    public Prestito(Utente utente, Elemento elemento, LocalDate dataInizio, LocalDate dataRestituzione) {
        this.utente = utente;
        this.elemento = elemento;
        this.dataInizio = dataInizio;
        this.dataFine=this.dataInizio.plusDays(30);
        this.dataRestituzione = dataRestituzione;
    }

    public Prestito() {

    }

    public long getId() {
        return id;
    }



    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public LocalDate getDataRestituzione() {
        return dataRestituzione;
    }

    public void setDataRestituzione(LocalDate dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", elemento=" + elemento +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", dataRestituzione=" + dataRestituzione +
                '}';
    }
}
