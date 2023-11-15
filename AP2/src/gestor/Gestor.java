package gestor;
import java.time.LocalDate;
import java.util.Scanner;
import entidades.LeitoraDeDados;
import entidades.eventos.Evento;
import entidades.ingressos.Ingresso;
import dao.EventoDAO;
import dao.IngressoDAO;

public class Gestor {
    public static void rodarGestor() {

        EventoDAO eventos = new EventoDAO();
        Scanner leitor = new Scanner(System.in);
        Evento evento = null;
        Ingresso ingresso = null;
        boolean executando = true;
        String nome;

        while (executando) {
            System.out.println("O que deseja fazer?\n  1 - Cadastrar novo evento\n  8 - Atualizar evento\n  7 - Remover evento\n  2 - Comprar ingressos\n  3 - Buscar evento\n  4 - Informações sobre quantidade de ingressos restantes\n  5 - Listar eventos\n  6 - Salvar e sair");
            int opcao = LeitoraDeDados.getOpcao(leitor);

            try {
                switch (opcao) {

                    case 1:
                        evento = LeitoraDeDados.cadastrarEvento(leitor);
                        System.out.println(eventos.adicionarEvento(evento));
                        break;
                    case 2:
                        if (eventos != null) {
                            ingresso = LeitoraDeDados.comprarIngresso(leitor, evento);
                        } else {
                            System.out.println("CADASTRE UM EVENTO PRIMEIRO!\n");
                        }
                        break;

                    case 3:
                        nome = LeitoraDeDados.getNome(leitor);
                        System.out.println(eventos.buscarEvento(nome));
                        break;

                    case 4:
                        nome = LeitoraDeDados.getNome(leitor);
                        evento = (eventos.buscarEvento(nome));
                        System.out.println(eventos.consultarIngressosRestantes(evento));
                        break;

                    case 5:
                        if (eventos != null) {
                            System.out.println(eventos);
                        } else {
                            System.out.println("CADASTRE UM EVENTO PRIMEIRO!\n");
                        }
                        break;

                    case 6:
                        eventos.salvarDados();
                        executando = false;
                        System.out.println("Salvando e encerrando o programa!");
                        break;

                    case 7:
                        nome = LeitoraDeDados.getNome(leitor);
                        System.out.println(eventos.removerEvento(nome));
                        break;

                    case 8:
                        nome = LeitoraDeDados.getNome(leitor);
                        String novoLocal = LeitoraDeDados.getNovoLocal(leitor);
                        LocalDate novaData = LeitoraDeDados.getNovaData(leitor);
                        System.out.println(eventos.atualizarEvento(nome, novoLocal, novaData));
                        break;

                    case 9:
                        nome = LeitoraDeDados.getNome(leitor);
                        System.out.println(eventos.removerEvento(nome));
                        break;

                    default:
                        System.out.println("OPÇÃO NÃO EXISTE!\n");
                }
            }  catch(Exception e) {
                System.err.println(e);
            }
        }
    }
}
