package entidades.DAO;
import entidades.ingressos.Ingresso;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


    public class IngressoDAO {
        private List<Ingresso> ingressos;
        private final String arquivoIngressos = "ingressos.txt";

        public IngressoDAO() {
            this.ingressos = new ArrayList<>();
        }

        public void salvarDados() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoAlunos, false))) {
                for (Ingresso ingresso : ingressos) {
                    writer.write(aluno.getNome() + "|" + aluno.getCurso() + "|" + aluno.getMatricula());
                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("Erro ao salvar dados: " + e.getMessage());
            }
        }

        public void adicionarAluno(Scanner leitor) {
            System.out.print("Digite a matrícula do aluno: ");
            String matricula = leitor.nextLine();
            System.out.print("Digite o nome do aluno: ");
            String nome = leitor.nextLine();
            System.out.print("Digite o curso do aluno: ");
            String curso = leitor.nextLine();
            this.alunos.add(new Aluno(nome, curso, matricula));
            System.out.println("Aluno adicionado com sucesso!");
        }

        public void removerAluno(Scanner leitor) {
            System.out.print("Informe a matrícula do aluno a ser removido: ");
            String matricula = leitor.nextLine();
            for (Aluno aluno : alunos) {
                if (aluno.getMatricula().equals(matricula)) {
                    alunos.remove(aluno);
                    System.out.println("Aluno removido com sucesso!");
                    break;
                }
            }
            System.err.println("Matricula não encontrada!");
        }

        public void atualizarCurso(Scanner leitor) {
            System.out.print("Digite a matrícula do aluno: ");
            String matricula = leitor.nextLine();
            for (Aluno aluno : alunos) {
                if (aluno.getMatricula().equals(matricula)) {
                    System.out.println("Aluno encontrado: " + aluno.getNome());
                    System.out.println("Curso atual: " + aluno.getCurso());
                    System.out.print("Digite o novo curso do aluno: ");
                    String novoCurso = leitor.nextLine();
                    aluno.setCurso(novoCurso);
                    return;
                }
            }
            System.err.println("Matrícula não encontrada!\n");
        }

        public Aluno buscarMatricula(Scanner leitor) {
            System.out.print("Digite a matrícula do aluno: ");
            String matricula = leitor.nextLine();
            for (Aluno aluno : alunos) {
                if (aluno.getMatricula().equals(matricula)) {
                    return aluno;
                }
            }
            System.err.println("Matricula não encontrada!");
            return null;
        }

        public String toString() {
            String listaAlunos = "";

            for (Aluno aluno : alunos) {
                listaAlunos += aluno + "\n\n";
            }
            return listaAlunos;
        }
    }

