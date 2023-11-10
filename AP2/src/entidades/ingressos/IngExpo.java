package entidades.ingressos;
import entidades.eventos.Evento;

public class IngExpo extends Ingresso{
    private boolean descontoSocial;

    public IngExpo(Evento evento, TipoIngresso tipoIngresso, boolean descontoSocial) {
        super(evento, tipoIngresso);
        this.descontoSocial = descontoSocial;
    }

    public double getPreco(){
        if(this.descontoSocial){
            return 0;
        } else if (this.getTipoIngresso().equals(TipoIngresso.INTEIRA)) {
            return this.getEvento().getPrecoCheio();
        } else {
            return this.getEvento().getPrecoCheio() / 2; }
    }

    // toString

    @Override
    public String toString() {
        if (this.descontoSocial){
            return super.toString() + "\n" +
            "Desconto Social: SIM\n";
        } else {
            return super.toString() + "\n" +
            "Desconto Social: NÃO\n";
        }
    }

    // GETTERS

    public boolean getDescontoSocial() {
        return this.descontoSocial;
    }

    // SETTERS

    public void setDescontoSocial(boolean novoDesconto) {
        this.descontoSocial = novoDesconto;
    }

}

/* O ingresso deve possuir um novo atributo booleano, chamado descontoSocial.
Caso esse valor seja true, o preço de venda do ingresso é zerado; */