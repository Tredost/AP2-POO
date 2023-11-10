package entidades.ingressos;
import entidades.eventos.Evento;

public class IngJogo extends Ingresso {
    private double percentualDescontoTorcedor;

    public IngJogo(Evento evento, TipoIngresso tipoIngresso, double descontoTorcedor){
        super(evento, tipoIngresso);
        this.percentualDescontoTorcedor = descontoTorcedor;
    }

    public double getPreco(){
        double descontoTorcedor = 1 - (this.percentualDescontoTorcedor / 100);

        if (this.getTipoIngresso().equals(TipoIngresso.INTEIRA)) {
            return this.getEvento().getPrecoCheio() * descontoTorcedor;
        }
        return (this.getEvento().getPrecoCheio() * descontoTorcedor) / 2;
    }

    // toString

    @Override
    public String toString() {
        return super.toString() + "\n" +
            "Desconto de torcedor: " + this.percentualDescontoTorcedor + " %\n";
    }

    // GETTERS

    public double getPercentualDescontoTorcedor() {
        return this.percentualDescontoTorcedor;
    }

    // SETTERS

    public void setPercentualDescontoTorcedor(double novoDesconto) {
        this.percentualDescontoTorcedor = novoDesconto;
    }

}


 /* O ingresso possui um atributo percentualDescontoTorcedor,
que é aplicado ao valor do ingresso no cálculo do preço.
Por exemplo, se o desconto de torcedor for 15% e o ingresso foi meia entrada,
com um preço cheio de R$100, o preço final fica 0.85 * 0.5 * 100 = R$42.50. */