package dao;
import entidades.eventos.Evento;
import entidades.eventos.Exposicao;
import entidades.eventos.Jogo;
import entidades.eventos.Show;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


    public class EventoDAO {
        private List<Evento> eventos;
        private final String arquivoEventos = "eventos.txt";

        public EventoDAO() {
            this.eventos = new ArrayList<>();
        }

        public void salvarDados() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoEventos, false))) {
                for (Evento evento : this.eventos) {
                    writer.write(evento.toDados());
                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("Erro ao salvar dados: " + e.getMessage());
            }
        }

        public String adicionarEvento(Evento evento) {
            this.eventos.add(evento);
            return "Evento adicionado com sucesso!\n";
        }

        public String removerEvento(String nome) {
            for (Evento evento : this.eventos) {
                if (evento.getNome().equals(nome)) {
                    eventos.remove(evento);
                    return "Evento removido com sucesso!\n";
                }
            }
            return "Evento não encontrado!\n";
        }

        public String atualizarEvento(String nome,String novoLocal,LocalDate novaData) {
            for (Evento evento : this.eventos) {
                if (evento.getNome().equals(nome)) {
                    evento.setLocal(novoLocal);
                    evento.setData(novaData);
                    return "Evento atualizado com sucesso!\n";
                }
            }
            return "Evento não encontrado!\n";
        }

        public Evento buscarEvento(String nome) {
            for (Evento evento : this.eventos) {
                if (evento.getNome().equals(nome)) {
                    return evento;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            String listaEventos = "";

            for (Evento evento : this.eventos) {
                listaEventos += evento + "\n\n";
            }
            return listaEventos;
        }
    }

