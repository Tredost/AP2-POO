package dao;
import entidades.ingressos.Ingresso;

import java.time.LocalDate;
import entidades.eventos.Evento;
import entidades.eventos.Exposicao;
import entidades.eventos.Jogo;
import entidades.eventos.Show;
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

        public String criarIngresso(Evento evento, TipoIngresso tipoIngresso, Double descontoTorcedor) {
            this.ingresso = new IngJogo(evento, tipoIngresso, descontoTorcedor);
            return "Evento adicionado com sucesso!";
        }

        public String toString() {
            return this.ingresso.toString();
        }
    }

