package gestor;
import java.time.LocalDate;
import java.util.Scanner;

import dao.EventoDAO;
import dao.IngressoDAO;
import entidades.LeitoraDeDados;
import entidades.eventos.Evento;
import entidades.ingressos.TipoIngresso;
import entidades.ingressos.IngShow.EspacoEnum;

public class Gestor {
    public static void rodarGestor() {

        EventoDAO eventos = new EventoDAO();
        Scanner leitor = new Scanner(System.in);
        boolean executando = true;
        int opcao;


        while (executando) {
            System.out.println("O que deseja fazer?\n  1 - Cadastrar novo evento\n  2 - Atualizar evento\n  3 - Remover evento\n  4 - Comprar ingressos\n  5 - Buscar evento\n  6 - Informações sobre quantidade de ingressos restantes\n  7 - Listar eventos\n  8 - Salvar e sair");
            opcao = LeitoraDeDados.getOpcao(8);

            try {
                switch (opcao) {

                    case 1:
                        cadastrarEvento(leitor, eventos);
                        break;

                    case 2:
                        listarNomeEventos(eventos);
                        atualizarEvento(leitor, eventos);
                        break;

                    case 3:
                        listarNomeEventos(eventos);
                        removerEvento(leitor, eventos);
                        break;

                    case 4:
                        listarNomeEventos(eventos);
                        comprarIngresso(leitor, eventos);
                        break;

                    case 5:
                        listarNomeEventos(eventos);
                        buscarEvento(leitor, eventos);
                        break;

                    case 6:
                        listarNomeEventos(eventos);
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
            }  catch(Exception erro) {
                System.err.println(erro + "\n");
            }
        }
    }


public static void cadastrarEvento(Scanner leitor, EventoDAO eventos) {
    String nome, local, nomeArtista, generoMusical, esporte, equipe1, equipe2;
    LocalDate data;
    int opcao, ingressosInteira, ingressosMeia, idadeMinima, duracaoDias;
    Double precoCheio;
    System.out.println("Qual tipo de evento deseja cadastar?\n  1 - Exposição\n  2 - Jogo\n  3 - Show\n");
    opcao = LeitoraDeDados.getOpcao(3);
    nome = LeitoraDeDados.getNome();
    data = LeitoraDeDados.getData();
    local = LeitoraDeDados.getLocal();
    ingressosInteira = LeitoraDeDados.getIngressosInteira();
    ingressosMeia = LeitoraDeDados.getIngressosMeia();
    precoCheio = LeitoraDeDados.getPrecoCheio();

    switch (opcao) {
        case 1:
            idadeMinima = LeitoraDeDados.getIdadeMinima();
            duracaoDias = LeitoraDeDados.getDuracaoDias();
            System.out.println(eventos.adicionarEvento(nome, data, local, ingressosInteira, ingressosMeia, precoCheio, idadeMinima, duracaoDias));
            break;

        case 2:
            esporte = LeitoraDeDados.getEsporte();
            equipe1 = LeitoraDeDados.getEquipe1();
            equipe2 = LeitoraDeDados.getEquipe2();
            System.out.println(eventos.adicionarEvento(nome, data, local, ingressosInteira, ingressosMeia, precoCheio, esporte, equipe1, equipe2));
            break;

        case 3:
            nomeArtista = LeitoraDeDados.getNomeArtista();
            generoMusical = LeitoraDeDados.getGeneroMusical();
            System.out.println(eventos.adicionarEvento(nome, data, local, ingressosInteira, ingressosMeia, precoCheio, nomeArtista, generoMusical));
            break;

        default:
            break;

    }
}

public static void atualizarEvento(Scanner leitor, EventoDAO eventos) {
    if (!eventos.isEmpty()) {
        String nome = LeitoraDeDados.getNome();
            if (eventos.jaExiste(nome)) {
                String novoLocal = LeitoraDeDados.getNovoLocal();
                LocalDate novaData = LeitoraDeDados.getNovaData();
                System.out.println(eventos.atualizarEvento(nome, novoLocal, novaData));
            }else{
                System.out.println("Evento não encontrado!");
            }
        }
    }

public static void removerEvento(Scanner leitor, EventoDAO eventos) {
    if (!eventos.isEmpty()) {
        String nome = LeitoraDeDados.getNome();
        System.out.println(eventos.removerEvento(nome));
    }
}

public static void buscarEvento(Scanner leitor, EventoDAO eventos) {
    if (!eventos.isEmpty()) {
        String nome = LeitoraDeDados.getNome();
        if (eventos.buscarEvento(nome) != null) {
            System.out.println(eventos.buscarEvento(nome));
        } else {
            System.out.println("Evento não encontrado!\n");
        }
    }

}

public static void exibirIngressosRestantes(Scanner leitor, EventoDAO eventos) {
    if (!eventos.isEmpty()) {
        String nome = LeitoraDeDados.getNome();
        Evento evento = (eventos.buscarEvento(nome));
        System.out.println(eventos.consultarIngressosRestantes(evento));
    }    
}

public static void listarEventos(EventoDAO eventos) {
    if (!eventos.isEmpty()) {
        System.out.println(eventos);
    } else {
        System.out.println("CADASTRE UM EVENTO PRIMEIRO!\n");
    }
}

public static void listarNomeEventos(EventoDAO eventos) {
    if (!eventos.isEmpty()) {
        System.out.println(eventos.listarNomeDosEventos());
    } else {
        System.out.println("CADASTRE UM EVENTO PRIMEIRO!\n");
    }
} 

public static void comprarIngresso(Scanner leitor, EventoDAO eventos) {
    if (!eventos.isEmpty()) {
        String nome = LeitoraDeDados.getNome();
        TipoIngresso tipoIngresso = LeitoraDeDados.getTipoIngresso();
        int quantidade = LeitoraDeDados.getQuantidade();
        Evento evento = eventos.buscarEvento(nome);
        if (!evento.isIngressoDisponivel(tipoIngresso, quantidade)) {
            System.out.println("Não existem ingressos disponíveis para sua compra!\n");
            return;
        }
        IngressoDAO ingressoDAO = new IngressoDAO();
        switch (evento.getTipo()) {
            case "Exposição":
                boolean descontoSocial = LeitoraDeDados.getDescontoSocial();
                System.out.println(ingressoDAO.criarIngresso(evento, tipoIngresso, descontoSocial));
                evento.venderIngresso(tipoIngresso, quantidade);
                break;

            case "Jogo":
                Double descontoTorcedor = LeitoraDeDados.getDescontoTorcedor();
                System.out.println(ingressoDAO.criarIngresso(evento, tipoIngresso, descontoTorcedor));
                evento.venderIngresso(tipoIngresso, quantidade);
                break;

            case "Show":
                EspacoEnum espacoEnum = LeitoraDeDados.getEspacoEnum();
                System.out.println(ingressoDAO.criarIngresso(evento, tipoIngresso, espacoEnum));
                evento.venderIngresso(tipoIngresso, quantidade);
                break;

            default:
                break;

        }
    }

}

public static boolean encerrarPrograma(EventoDAO eventos) {
    eventos.salvarDados();
    System.out.println("Salvando e encerrando o programa!");
    return false;

}

}