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
            System.out.println("O que deseja fazer?\n  1 - Cadastrar novo evento\n  2 - Atualizar evento\n  3 - Remover evento\n  4 - Comprar ingressos\n  5 - Buscar evento\n  6 - Informações sobre quantidade de ingressos restantes\n  7 - Listar eventos\n  8 - Salvar e sair");
            int opcao = LeitoraDeDados.getOpcao(leitor);

            try {
                switch (opcao) {

                    case 1:
                        evento = LeitoraDeDados.cadastrarEvento(leitor);
                        System.out.println(eventos.adicionarEvento(evento));
                        break;

                    case 2:
                        nome = LeitoraDeDados.getNome(leitor);
                        String novoLocal = LeitoraDeDados.getNovoLocal(leitor);
                        LocalDate novaData = LeitoraDeDados.getNovaData(leitor);
                        System.out.println(eventos.atualizarEvento(nome, novoLocal, novaData));
                        break;

                    case 3:
                        nome = LeitoraDeDados.getNome(leitor);
                        System.out.println(eventos.removerEvento(nome));
                        break;

                    case 4:
                        if (eventos != null) {
                            ingresso = LeitoraDeDados.comprarIngresso(leitor, evento);
                        } else {
                            System.out.println("CADASTRE UM EVENTO PRIMEIRO!\n");
                        }
                        break;

                    case 5:
                        nome = LeitoraDeDados.getNome(leitor);
                        System.out.println(eventos.buscarEvento(nome));
                        break;

                    case 6:
                        nome = LeitoraDeDados.getNome(leitor);
                        evento = (eventos.buscarEvento(nome));
                        System.out.println(eventos.consultarIngressosRestantes(evento));
                        break;

                    case 7:
                        if (eventos != null) {
                            System.out.println(eventos);
                        } else {
                            System.out.println("CADASTRE UM EVENTO PRIMEIRO!\n");
                        }
                        break;

                    case 8:
                        eventos.salvarDados();
                        executando = false;
                        System.out.println("Salvando e encerrando o programa!");
                        break;

                    case 9:
                        
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
