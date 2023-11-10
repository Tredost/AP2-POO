package entidades.ingressos;
import entidades.eventos.Evento;

public abstract class Ingresso {
    private Evento evento;
    private TipoIngresso tipoIngresso;

    public Ingresso(Evento evento, TipoIngresso tipoIngresso) {
        this.evento = evento;
        this.tipoIngresso = tipoIngresso;
    }

    public abstract double getPreco();

    // toString

    public String toString() {
        return "Tipo do ingresso: " + this.tipoIngresso;
    }

    // GETTERS

    public Evento getEvento() {
        return this.evento;
    }

    public TipoIngresso getTipoIngresso() {
        return this.tipoIngresso;
    }

    // SETTERS

    public void setEvento(Evento novoEvento) {
        this.evento = novoEvento;
    }

    public void setTipoIngresso(TipoIngresso novoTipoIngresso) {
        this.tipoIngresso = novoTipoIngresso;
    }
}


/*

classe abstrata que representa um ingresso vendido. Deve conter os seguintes atributos e métodos:
Atributo evento (Evento): evento para o qual o ingresso foi vendido;
Atributo tipo (TipoIngresso): indica se é inteira ou meia entrada;
Método getPreco(): retorna o preço a depender do tipo de ingresso.

*/