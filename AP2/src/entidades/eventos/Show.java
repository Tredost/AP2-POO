package entidades.eventos;


public class Show extends Evento {
    private String nomeArtista, generoMusical;

    public Show(String nomeEvento, String dataEvento, String localEvento, int ingressosInteira, int ingressosMeia, double precoCheio, String nomeArtista, String generoMusical) {
        super(nomeEvento, dataEvento, localEvento, ingressosInteira, ingressosMeia, precoCheio);
        this.nomeArtista = nomeArtista;
        this.generoMusical = generoMusical;
        this.tipo = "Show";
    }

    // toString

    @Override
    public String toString() {
        return "\nShow: " + super.toString() + "\n" +
            "Artista: " + this.nomeArtista + "\n" +
            "Gênero musical: " + this.generoMusical + "\n";
    }

    // GETTERS

    public String getNomeArtista() {
        return this.nomeArtista;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    // SETTERS

    public void setNomeArtista(String novoArtista) {
        this.nomeArtista = novoArtista;
    }

    public void setGeneroMusical(String novoGenero) {
        this.generoMusical = novoGenero;
    }


}


/* o evento deve conter o nome do artista e o gênero da música. */