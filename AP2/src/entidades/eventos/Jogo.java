package entidades.eventos;

import java.time.LocalDate;

public class Jogo extends Evento {
    private String esporte, equipe1, equipe2;

    public Jogo(String nome, LocalDate data, String local, int ingressosInteira, int ingressosMeia, double precoCheio, String esporte, String equipe1, String equipe2) {
        super(nome, data, local, ingressosInteira, ingressosMeia, precoCheio);
        this.esporte = esporte;
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.tipo = "Jogo";
    }

    // toString

    @Override
    public String toString() {
        return "\nJogo: " + super.toString() + "\n" +
            "Esporte: " + this.esporte + "\n" +
            "Equipes: " + this.equipe1 + " x " + this.equipe2 + "\n";
    }

    // GETTERS

    public String getEsporte() {
        return this.esporte;
    }

    public String getEquipe1() {
        return this.equipe1;
    }

    public String getEquipe2() {
        return this.equipe2;
    }

    // SETTERS

    public void setEsporte(String novoEsporte) {
        this.esporte = novoEsporte;
    }

    public void setEquipe1(String novaEquipe) {
        this.equipe1 = novaEquipe;
    }

    public void setEquipe2(String novaEquipe) {
        this.equipe2 = novaEquipe;
    }
}


/* o evento deve conter o esporte e as equipes que estão competindo. */