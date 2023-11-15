package daos;
import entidades.eventos.Evento;
import entidades.ingressos.Ingresso;
import entidades.ingressos.TipoIngresso;

    public class IngressoDAO {

        public boolean isIngressoDisponivel(Evento evento, TipoIngresso tipoIngresso, int quantidade) {
            if (tipoIngresso.equals(TipoIngresso.INTEIRA) && quantidade <= evento.getIngressosInteira()){
                return true;
            }
            else if (tipoIngresso.equals(TipoIngresso.MEIA) && quantidade <= evento.getIngressosMeia()) {
                return true;
            }
                return false;
        }

        public void venderIngresso(Evento evento, TipoIngresso tipoIngresso, int quantidade) {
            int novaQntd;

            if (tipoIngresso.equals(TipoIngresso.INTEIRA)){
                novaQntd = evento.getIngressosInteira();
                novaQntd -= quantidade;
                evento.setIngressosInteira(novaQntd);
            }
            else {
                novaQntd = evento.getIngressosMeia();
                novaQntd -= quantidade;
                evento.setIngressosMeia(novaQntd);
            }
        }

        public String emitirRecibo(Evento evento, Ingresso ingresso, TipoIngresso tipoIngresso, int quantidade) {
            double valor = ingresso.getPreco() * quantidade;
            evento.venderIngresso(tipoIngresso, quantidade);
            return "Compra realizada!\n  " + quantidade + "x " + tipoIngresso + "\n  TOTAL: R$ " + String.format("%.2f", valor) + "\n";
        }

        public String toString() {
            return " ";
        }
    }

