package entidades.DAO;
import entidades.eventos.Evento;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


    public class EventoDAO {
        private List<Evento> eventos;
        private final String arquivoEventos = "eventos.txt";

        public EventoDAO() {
            this.eventos = new ArrayList<>();
        }

        public void salvarDados() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoEventos, false))) {
                for (Evento evento : eventos) {
                    writer.write(evento.getNome() + "|" + evento.getData() + "|" + evento.getLocal());
                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("Erro ao salvar dados: " + e.getMessage());
            }
        }

        public void adicionarEvento(Scanner leitor) {
            System.out.print("Digite a matrícula do aluno: ");
            String matricula = leitor.nextLine();
            System.out.print("Digite o nome do aluno: ");
            String nome = leitor.nextLine();
            System.out.print("Digite o curso do aluno: ");
            String curso = leitor.nextLine();
            this.eventos.add(new Evento(nome, curso, matricula, int, int , double));
            System.out.println("Aluno adicionado com sucesso!");
        }

        public void removerEvento(Scanner leitor) {
            System.out.print("Informe o nome do evento a ser removido: ");
            String nome = leitor.nextLine();
            for (Evento evento : eventos) {
                if (evento.getNome().equals(nome)) {
                    eventos.remove(evento);
                    System.out.println("Evento removido com sucesso!");
                    break;
                }
            }
            System.err.println("Matricula não encontrada!");
        }

        public void atualizarCurso(Scanner leitor) {
            System.out.print("Digite a matrícula do aluno: ");
            String matricula = leitor.nextLine();
            for (Evento evento : eventos) {
                if (evento.getNome().equals(matricula)) {
                    System.out.println("Aluno encontrado: " + evento.getNome());
                    System.out.println("Curso atual: " + evento.getCurso());
                    System.out.print("Digite o novo curso do aluno: ");
                    String novoCurso = leitor.nextLine();
                    evento.setCurso(novoCurso);
                    return;
                }
            }
            System.err.println("Matrícula não encontrada!\n");
        }

        public Evento buscarEvento(Scanner leitor) {
            System.out.print("Digite o nome do evento: ");
            String nome = leitor.nextLine();
            for (Evento evento : eventos) {
                if (evento.getNome().equals(nome)) {
                    return evento;
                }
            }
            System.err.println("Evento não encontrado!");
            return null;
        }

        public String toString() {
            String listaEventos = "";

            for (Evento evento : eventos) {
                listaEventos += evento + "\n\n";
            }
            return listaEventos;
        }
    }
