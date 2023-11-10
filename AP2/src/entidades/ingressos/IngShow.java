package entidades.ingressos;
import entidades.eventos.Evento;

public class IngShow extends Ingresso {
    public enum EspacoEnum { PISTA, CAMAROTE };
    private EspacoEnum espacoEnum;

    public IngShow(Evento evento, TipoIngresso tipoIngresso, EspacoEnum espacoEnum) {
        super(evento, tipoIngresso);
        this.espacoEnum = espacoEnum;
    }

    public double getPreco(){
        if (this.getTipoIngresso().equals(TipoIngresso.INTEIRA)){
            return this.getEvento().getPrecoCheio();
        }
        return this.getEvento().getPrecoCheio() / 2;
    }

    // toString

    @Override
    public String toString() {
        return super.toString() + "\n" +
            "Local: " + this.espacoEnum + "\n";
    }

    // GETTERS

    public EspacoEnum getEspacoEnum() {
        return this.espacoEnum;
    }

    // SETTERS

    public void setEspacoEnum(EspacoEnum novoEspaco) {
        this.espacoEnum = novoEspaco;
    }
}


/* O ingresso precisa ter qual a localização do ingresso
dentro do local do evento, podendo ser “pista” ou “camarote”; */