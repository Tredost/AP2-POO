package entidades.eventos;
import entidades.ingressos.TipoIngresso;

public abstract class Evento {
    private String nomeEvento, dataEvento, localEvento;
    private int ingressosInteira, ingressosMeia, ingressosInteiraOriginal, ingressosMeiaOriginal;
    private double precoCheio;
    protected String tipo;

    public Evento(String nomeEvento, String dataEvento, String localEvento, int ingressosInteira, int ingressosMeia, double precoCheio) {
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
        this.localEvento = localEvento;
        this.ingressosInteiraOriginal = ingressosInteira;
        this.ingressosMeiaOriginal = ingressosMeia;
        this.ingressosInteira = ingressosInteira;
        this.ingressosMeia = ingressosMeia;
        this.precoCheio = precoCheio;
    }

    public boolean isIngressoDisponivel(TipoIngresso tipoIngresso, int quantidade) {
        if (tipoIngresso.equals(TipoIngresso.INTEIRA) && quantidade <= this.ingressosInteira){
            return true;
        }
        else if (tipoIngresso.equals(TipoIngresso.MEIA) && quantidade <= this.ingressosMeia) {
            return true;
        }
            return false;
    }

    public void venderIngresso(TipoIngresso tipoIngresso, int quantidade) {
        if (tipoIngresso.equals(TipoIngresso.INTEIRA)){
            this.ingressosInteira -= quantidade;
        }
        else {
            this.ingressosMeia -= quantidade;
        }
    }

    // toString

    public String toString() {
        return this.nomeEvento + "\n" +
            "Data: " + this.dataEvento + "\n" +
            "Local: " + this.localEvento + "\n" +
            "Quantidade de ingressos inteira: " + this.ingressosInteiraOriginal + "\n" +
            "Quantidade de ingressos meia: " + this.ingressosMeiaOriginal + "\n" +
            "Preço cheio do ingresso: R$ " + String.format("%.2f", this.precoCheio);
    }

    // GETTERS

    public String getNomeEvento() {
        return this.nomeEvento;
    }

    public String getDataEvento() {
        return this.dataEvento;
    }

    public String getLocalEvento() {
        return this.localEvento;
    }

    public int getIngressosInteiraOriginal() {
        return this.ingressosInteiraOriginal;
    }

    public int getIngressosMeiaOriginal() {
        return this.ingressosMeiaOriginal;
    }


    public int getIngressosInteira() {
        return this.ingressosInteira;
    }

    public int getIngressosMeia() {
        return this.ingressosMeia;
    }

    public double getPrecoCheio() {
        return this.precoCheio;
    }

    public String getTipo() {
        return this.tipo;
    }

    // SETTERS

    public void setNomeEvento(String novoNome) {
        this.nomeEvento = novoNome;
    }

    public void setDataEvento(String novaData) {
        this.dataEvento = novaData;
    }

    public void setLocalEvento(String novoLocal) {
        this.localEvento = novoLocal;
    }

    public void setIngressosInteira(int novaQntd) {
        this.ingressosInteira = novaQntd;
    }

    public void setIngressosMeia(int novaQntd) {
        this.ingressosMeia = novaQntd;
    }

    public void setPrecoCheio(double novoPreco) {
        this.precoCheio = novoPreco;
    }

    public void setTipo(String novoTipo) {
        this.tipo = novoTipo;
    }

}


/*

Evento: classe abstrata que representa um evento. Deve conter os seguintes atributos e métodos:
Atributo nome (String): nome do evento;
Atributo data (String): data e horário do evento;
Atributo local (String): local onde será realizado o evento;
Atributo ingressosInteira (int): quantidade de ingressos tipo inteira disponíveis;
Atributo ingressosMeia (int): quantidade de ingressos tipo meia disponíveis;
Atributo precoCheio (double): valor do ingresso cheio para o evento, sem o desconto de meia entrada;
Método isIngressoDisponivel(TipoIngresso tipo, int quantidade): verifica se há ingressos disponíveis para o tipo e quantidade especificados;
Método venderIngresso(TipoIngresso tipo): realiza a venda de ingressos do tipo e quantidade especificados e retorna o valor total da venda;
Implemente os métodos getters e setters conforme a necessidade;

 */
