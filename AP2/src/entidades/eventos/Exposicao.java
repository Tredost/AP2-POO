package entidades.eventos;


public class Exposicao extends Evento {
    private int idadeMinima, duracaoDias;

    public Exposicao(String nomeEvento, String dataEvento, String localEvento, int ingressosInteira, int ingressosMeia, double precoCheio, int idadeMinima, int duracaoDias) {
        super(nomeEvento, dataEvento, localEvento, ingressosInteira, ingressosMeia, precoCheio);
        this.idadeMinima = idadeMinima;
        this.duracaoDias = duracaoDias;
        this.tipo = "Exposição";
    }

    // toString

    @Override
    public String toString() {
        return "\nExposição: " + super.toString() + "\n" +
            "Idade mínima recomendada: " + this.idadeMinima + " anos\n" +
            "Duração: " + this.duracaoDias + " dias\n";
    }

    // GETTERS

    public int getIdadeMinima() {
        return this.idadeMinima;
    }

    public int getDuracaoDias() {
        return this.duracaoDias;
    }

    // SETTERS

    public void setIdadeMinima(int novaIdade) {
        this.idadeMinima = novaIdade;
    }

    public void setDuracaoDias(int novaDuracao) {
        this.duracaoDias = novaDuracao;
    }
}


/* o evento deve conter a faixa etária mínima recomendada e a duração, em dias, da exposição. */