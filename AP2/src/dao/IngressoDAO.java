package dao;
import entidades.eventos.Evento;
import entidades.ingressos.Ingresso;
import entidades.ingressos.IngExpo;
import entidades.ingressos.IngShow;
import entidades.ingressos.IngShow.EspacoEnum;
import entidades.ingressos.IngJogo;
import entidades.ingressos.TipoIngresso;

    public class IngressoDAO {
        private Ingresso ingresso;

        //criar ingresso recebendo os parâmetros da gestora, gestora puxa métodos da leitora

        public String criarIngresso(Evento evento, TipoIngresso tipoIngresso, EspacoEnum espacoEnum) {
            this.ingresso = new IngShow(evento, tipoIngresso, espacoEnum);
            return this.ingresso.toString();
        }

        public String criarIngresso(Evento evento, TipoIngresso tipoIngresso, boolean descontoSocial) {
            this.ingresso = new IngExpo(evento, tipoIngresso, descontoSocial);
            return this.ingresso.toString();
        }

        public String criarIngresso(Evento evento, TipoIngresso tipoIngresso, double descontoTorcedor) {
            this.ingresso = new IngJogo(evento, tipoIngresso, descontoTorcedor);
            return this.ingresso.toString();
        }

        public String toString() {
            return this.ingresso.toString();
        }
    }

