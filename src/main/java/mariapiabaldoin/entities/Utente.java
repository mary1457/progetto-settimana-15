package mariapiabaldoin.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity

@Table(name = "utenti")

public class Utente {
    @Id
    @GeneratedValue
    private long numero_tessera;

    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestitiList;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "data_nascita", nullable = false)
    private LocalDate dataNascita;

    public Utente(String nome , String cognome, LocalDate dataNascita) {

        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    public Utente() {
    }

    public long getNumero_tessera() {
        return numero_tessera;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public List<Prestito> getPrestitiList() {
        return prestitiList;
    }

    public void setPrestitiList(List<Prestito> prestitiList) {
        this.prestitiList = prestitiList;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "numero_tessera=" + numero_tessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }
}
