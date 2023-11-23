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

        public String adicionarEvento(String nome, LocalDate data, String local, int ingressosInteira, int ingressosMeia, double precoCheio, int idadeMinima, int duracaoDias) {
           for (Evento evento : this.eventos) {
                if (evento.getNome().equals(nome) && evento.getData().equals(data) && evento.getLocal().equals(local) && evento.getIngressosInteira()==ingressosInteira && evento.getIngressosMeia()== ingressosMeia && evento.getPrecoCheio()==precoCheio /* especificos */) {
                    return "Evento já existente!\n";
                } 
            } 
            this.eventos.add(new Exposicao(nome, data, local, ingressosInteira, ingressosMeia , precoCheio, idadeMinima, duracaoDias));
            return "Evento adicionado com sucesso!\n";
            }// msg de erro
        
            

        public String adicionarEvento(String nome, LocalDate data, String local, int ingressosInteira, int ingressosMeia, double precoCheio, String esporte, String equipe1, String equipe2) {
            for (Evento evento : this.eventos) {
                if (evento.getNome().equals(nome) && evento.getData().equals(data) && evento.getLocal().equals(local) && evento.getIngressosInteira()==ingressosInteira && evento.getIngressosMeia()== ingressosMeia && evento.getPrecoCheio()==precoCheio /*especificos*/) {
                    return "Evento já existente!\n";
                } 
            } 
            this.eventos.add(new Jogo(nome, data, local, ingressosInteira, ingressosMeia , precoCheio, esporte, equipe1, equipe2));
            return "Evento adicionado com sucesso!";
        }     // msg de erro           
        

        public String adicionarEvento(String nome, LocalDate data, String local, int ingressosInteira, int ingressosMeia, double precoCheio, String nomeArtista, String generoMusical) {
           for (Evento evento : this.eventos) {
                if (evento.getNome().equals(nome) && evento.getData().equals(data) && evento.getLocal().equals(local) && evento.getIngressosInteira()==ingressosInteira && evento.getIngressosMeia()== ingressosMeia && evento.getPrecoCheio()==precoCheio /*especificos*/) {
                    return "Evento já existente!\n";
                } 
            } 
            this.eventos.add(new Show(nome, data, local, ingressosInteira, ingressosMeia , precoCheio, nomeArtista, generoMusical));
            return "Evento adicionado com sucesso!";
            } // msg de erro  

        public String removerEvento(String nome) {
            for (Evento evento : this.eventos) {
                if (evento.getNome().equals(nome)) {
                    eventos.remove(evento);
                    return "Evento removido com sucesso!\n";
                }
            }
            return "Evento não encontrado!\n";
        }

        public boolean isEmpty() {
            return this.eventos.isEmpty();
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

        public String consultarIngressosRestantes(Evento evento) {
            return "Quantidade de ingressos inteiras restantes: "+ evento.getIngressosInteira() +
            "\nQuantidade de ingressos meia restantes: " + evento.getIngressosMeia() + "\n";
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

