package gestor;
import java.time.LocalDate;
import java.util.Scanner;

import dao.EventoDAO;
import dao.IngressoDAO;
import entidades.LeitoraDeDados;
import entidades.eventos.Evento;
import entidades.ingressos.Ingresso;

public class Gestor {
    public static void rodarGestor() {

        EventoDAO eventos = new EventoDAO();
        Scanner leitor = new Scanner(System.in);
        Evento evento = null;
        Ingresso ingresso = null;
        boolean executando = true;
        String nome, local, nomeArtista, generoMusical, esporte, equipe1, equipe2;
        LocalDate data;
        int opcao, ingressosInteira, ingressosMeia, idadeMinima, duracaoDias;
        Double precoCheio;


        while (executando) {
            System.out.println("O que deseja fazer?\n  1 - Cadastrar novo evento\n  2 - Atualizar evento\n  3 - Remover evento\n  4 - Comprar ingressos\n  5 - Buscar evento\n  6 - Informações sobre quantidade de ingressos restantes\n  7 - Listar eventos\n  8 - Salvar e sair");
            opcao = LeitoraDeDados.getOpcao(leitor);

            try {
                switch (opcao) {

                    case 1:
                        cadastrarEvento(leitor, eventos);
                        break;

                    case 2:
                        atualizarEvento(leitor, eventos);
                        break;

                    case 3:
                        removerEvento(leitor, eventos);
                        break;

                    case 4:
                        if (eventos != null) {
                            //ingresso = LeitoraDeDados.comprarIngresso(leitor, evento);
                        } else {
                            System.out.println("CADASTRE UM EVENTO PRIMEIRO!\n");
                        }
                        break;

                    case 5:
                        buscarEvento(leitor, eventos);
                        break;

                    case 6:
                        exibirIngressosRestantes(leitor, eventos);
                        break;

                    case 7:
                        listarEventos(eventos);
                        break;

                    case 8:
                        executando = encerrarPrograma(eventos);
                        break;

                    default:
                        System.out.println("OPÇÃO NÃO EXISTE!\n");
                }
            }  catch(Exception e) {
                System.err.println(e);
            }
        }
    }


public static void cadastrarEvento(Scanner leitor, EventoDAO eventos) {
    String nome, local, nomeArtista, generoMusical, esporte, equipe1, equipe2;
    LocalDate data;
    int opcao, ingressosInteira, ingressosMeia, idadeMinima, duracaoDias;
    Double precoCheio; 
    System.out.println("Qual tipo de evento deseja cadastar?\n  1 - Exposição\n  2 - Jogo\n  3 - Show\n");
    opcao = LeitoraDeDados.getOpcao(leitor);
    nome = LeitoraDeDados.getNome(leitor);
    data = LeitoraDeDados.getData(leitor);
    local = LeitoraDeDados.getLocal(leitor);
    ingressosInteira = LeitoraDeDados.getIngressosInteira(leitor);
    ingressosMeia = LeitoraDeDados.getIngressosMeia(leitor);
    precoCheio = LeitoraDeDados.getPrecoCheio(leitor);

    switch (opcao) {
        case 1:
            idadeMinima = LeitoraDeDados.getIdadeMinima(leitor);
            duracaoDias = LeitoraDeDados.getDuracaoDias(leitor);
            System.out.println(eventos.adicionarEvento(nome, data, local, ingressosInteira, ingressosMeia, precoCheio, idadeMinima, duracaoDias));        
            break;

        case 2:
            esporte = LeitoraDeDados.getEsporte(leitor);
            equipe1 = LeitoraDeDados.getEquipe1(leitor);
            equipe2 = LeitoraDeDados.getEquipe2(leitor);
            System.out.println(eventos.adicionarEvento(nome, data, local, ingressosInteira, ingressosMeia, precoCheio, esporte, equipe1, equipe2));    
            break;

        case 3:
            nomeArtista = LeitoraDeDados.getNomeArtista(leitor);
            generoMusical = LeitoraDeDados.getGeneroMusical(leitor);
            System.out.println(eventos.adicionarEvento(nome, data, local, ingressosInteira, ingressosMeia, precoCheio, nomeArtista, generoMusical));
            break;

        default:
            break;

    }
}

public static void atualizarEvento(Scanner leitor, EventoDAO eventos) {
    String nome = LeitoraDeDados.getNome(leitor);
    String novoLocal = LeitoraDeDados.getNovoLocal(leitor);
    LocalDate novaData = LeitoraDeDados.getNovaData(leitor);
    System.out.println(eventos.atualizarEvento(nome, novoLocal, novaData));

}

public static void removerEvento(Scanner leitor, EventoDAO eventos) {
    String nome = LeitoraDeDados.getNome(leitor);
    System.out.println(eventos.removerEvento(nome));

}

public static void buscarEvento(Scanner leitor, EventoDAO eventos) {
    String nome = LeitoraDeDados.getNome(leitor);
    if (eventos.buscarEvento(nome) != null) {
        System.out.println(eventos.buscarEvento(nome));
    } else {
        System.out.println("Evento não encontrado!\n");
    }

}

public static void exibirIngressosRestantes(Scanner leitor, EventoDAO eventos) {
    String nome = LeitoraDeDados.getNome(leitor);
    Evento evento = (eventos.buscarEvento(nome));
    System.out.println(eventos.consultarIngressosRestantes(evento));

}

public static void listarEventos(EventoDAO eventos) {
    if (!eventos.isEmpty()) {
        System.out.println(eventos);
    } else {
        System.out.println("CADASTRE UM EVENTO PRIMEIRO!\n");
    }
}

public static boolean encerrarPrograma(EventoDAO eventos) {
    eventos.salvarDados();
    System.out.println("Salvando e encerrando o programa!");
    return false;

}

}