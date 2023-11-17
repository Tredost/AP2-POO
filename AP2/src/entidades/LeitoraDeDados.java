package entidades;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import gestor.Gestor;
import entidades.ingressos.TipoIngresso;
import entidades.ingressos.IngShow.EspacoEnum;

public class LeitoraDeDados {

/* public static void cadastrarEvento(Scanner leitor) {
    

    System.out.println("Qual tipo de evento deseja cadastar?\n  1 - Exposição\n  2 - Jogo\n  3 - Show\n");
    int tipoEvento = leitor.nextInt();

    while (true) {
        if (tipoEvento <= 0 || tipoEvento > 3) {
            System.out.println("Opção inválida! Tente denovo.\n");
            tipoEvento = leitor.nextInt();
        } else {
            break;
        }
    }

    leitor.nextLine();

    System.out.println("Qual nome do evento?\n");
    String nome = leitor.nextLine();

    System.out.println("Qual a data do evento (dia/mês/ano)?\n");
    String dataStr = leitor.nextLine();
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate data = LocalDate.parse(dataStr, formatador);

    System.out.println("Qual o local do evento?\n");
    String local = leitor.nextLine();

    System.out.println("Quantos ingressos INTEIRA existem?\n");
    int ingressosInteira = leitor.nextInt();

    System.out.println("Quantos ingressos MEIA existem?\n");
    int ingressosMeia = leitor.nextInt();

    System.out.println("Qual o preço cheio do ingresso?\n");
    double precoCheio = leitor.nextDouble();

    switch (tipoEvento) {

        case 1:

            System.out.println("Qual a idade mínima?\n");
            int idadeMinima = leitor.nextInt();

            System.out.println("Quantos dias de duração?\n");
            int duracaoDias = leitor.nextInt();

            

        case 2:

            leitor.nextLine();

            System.out.println("Qual o esporte?\n");
            String esporte = leitor.nextLine();

            System.out.println("Qual a primeira equipe?\n");
            String equipe1 = leitor.nextLine();

            System.out.println("Qual a segunda equipe?\n");
            String equipe2 = leitor.nextLine();

            

        case 3:
            leitor.nextLine();

            System.out.println("Qual o nome do artista?\n");
            String nomeArtista = leitor.nextLine();

            System.out.println("Qual o gênero musical?\n");
            String generoMusical = leitor.nextLine();

        

        default:

        
    }
} 

public static Ingresso comprarIngresso(Scanner leitor, Evento evento) {
    Ingresso ingresso = null;
    int confirmacao;

    System.out.println("Qual o tipo de ingresso deseja comprar?\n  1 - INTEIRA\n  2 - MEIA\n");
    TipoIngresso tipoIngresso;
    int tipoInt = leitor.nextInt();

    while (true) {
        if (tipoInt == 1) {
            tipoIngresso = TipoIngresso.INTEIRA;
            break;
        } else if (tipoInt == 2) {
            tipoIngresso = TipoIngresso.MEIA;
            break;
        } else {
            System.out.println("Tipo de ingresso inválido! Tente novamente.\n");
            tipoInt = leitor.nextInt();
        }
    }

    System.out.println("Quantos ingressos deseja?\n");
    int quantidade = leitor.nextInt();

    while (true) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida! Tente novamente.\n");
            quantidade = leitor.nextInt();
        } else {
            break;
        }
    }

    if (!evento.isIngressoDisponivel(tipoIngresso, quantidade)) {
        System.out.println("Não existem ingressos disponíveis para sua compra :(\n");
        return ingresso;
    }

    switch (evento.getTipo()) {

        case "Exposição":
            System.out.println("Possui desconto social?\n  1 - SIM\n  2 - NÃO\n");
            int descontoInt = leitor.nextInt();
            boolean descontoSocial;

            while (true) {
                if (descontoInt == 1) {
                    descontoSocial = true;
                    break;
                } else if (descontoInt == 2) {
                    descontoSocial = false;
                    break;
                } else {
                    System.out.println("Opção inválida! Tente novamente.\n");
                    descontoInt = leitor.nextInt();
                }
            }

            ingresso = new IngExpo(evento, tipoIngresso, descontoSocial);
            System.out.println("CONFIMA AS INFORMAÇÕES A SEGUIR:\n\nQuantidade: " + quantidade + "\n" +  ingresso + "\n  1 - SIM\n  2 - NÃO\n");
            confirmacao = leitor.nextInt();

            while (true) {
                if (confirmacao == 1) {
                    break;
                } else if (confirmacao == 2) {
                    System.out.println("Compra cancelada!\n");
                    ingresso = null;
                    return ingresso;
                } else {
                    System.out.println("Opção inválida! Tente novamente.\n");
                    confirmacao = leitor.nextInt();
                }
            }

            emitirRecibo(evento, ingresso, tipoIngresso, quantidade);
            return ingresso;

        case "Jogo":
            System.out.println("Se possui desconto torcedor digite aqui!\n");
            double descontoTorcedor = leitor.nextDouble();

            while (true) {
                if (descontoTorcedor < 0) {
                    System.out.println("Valor inválido! Tente novamente.\n");
                    descontoTorcedor = leitor.nextInt();
                } else {
                    break;
                }
            }

            ingresso = new IngJogo(evento, tipoIngresso, descontoTorcedor);

            System.out.println("CONFIMA AS INFORMAÇÕES A SEGUIR:\n\nQuantidade: " + quantidade + "\n" + ingresso + "\n  1 - SIM\n  2 - NÃO\n");
            confirmacao = leitor.nextInt();

            while (true) {
                if (confirmacao == 1) {
                    break;
                } else if (confirmacao == 2) {
                    System.out.println("Compra cancelada!\n");
                    ingresso = null;
                    return ingresso;
                } else {
                    System.out.println("Opção inválida! Tente novamente.\n");
                    confirmacao = leitor.nextInt();
                }
            }

            emitirRecibo(evento, ingresso, tipoIngresso, quantidade);
            return ingresso;

        case "Show":
            System.out.println("Qual o espaço do show deseja ficar?\n  1 - PISTA\n  2 - CAMAROTE\n");
            EspacoEnum espacoEnum;
            int espacoInt = leitor.nextInt();

            while (true) {
                if (espacoInt == 1) {
                    espacoEnum = EspacoEnum.PISTA;
                    break;
                } else if (espacoInt == 2) {
                    espacoEnum = EspacoEnum.CAMAROTE;
                    break;
                } else {
                    System.out.println("Espaço inválido! Tente novamente.\n");
                    espacoInt = leitor.nextInt();
                }
            }

            ingresso = //besteira

            System.out.println("CONFIMA AS INFORMAÇÕES A SEGUIR:\n\nQuantidade: " + quantidade + "\n" +  ingresso + "\n  1 - SIM\n  2 - NÃO\n");
            confirmacao = leitor.nextInt();

            while (true) {
                if (confirmacao == 1) {
                    break;
                } else if (confirmacao == 2) {
                    System.out.println("Compra cancelada!\n");
                    ingresso = null;
                    return ingresso;
                } else {
                    System.out.println("Opção inválida! Tente novamente.\n");
                    confirmacao = leitor.nextInt();
                }
            }

            
            return ingresso;

        default:
            return ingresso;
        }
} */

public static String getNome(Scanner leitor){
    System.out.println("Digite o nome do evento: ");
    leitor.nextLine();
    return leitor.nextLine();
}

public static int getIngressosInteira(Scanner leitor) {
    System.out.println("Quantos ingressos INTEIRA existem?\n");
    return leitor.nextInt();
}

public static int getIngressosMeia(Scanner leitor) {
    System.out.println("Quantos ingressos MEIA existem?\n");
    return leitor.nextInt();
}

public static Double getPrecoCheio(Scanner leitor) {
    System.out.println("Qual o preço cheio do ingresso?\n");
    return leitor.nextDouble();
}

public static String getLocal(Scanner leitor) {
    System.out.println("Qual o local do evento?\n");
    return leitor.nextLine();
}

public static String getNovoLocal(Scanner leitor) {
    System.out.println("Qual o novo local?\n");
    return leitor.nextLine();
}

public static LocalDate getData(Scanner leitor) {
    System.out.println("Qual a data do evento? (dia/mês/ano)\n");
    String dataStr = leitor.nextLine();
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate data = LocalDate.parse(dataStr, formatador);
    return data;
}

public static LocalDate getNovaData(Scanner leitor) {
    System.out.println("Qual a nova data? (dia/mês/ano)\n");
    String dataStr = leitor.nextLine();
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate data = LocalDate.parse(dataStr, formatador);
    return data;
}

public static Integer getOpcao(Scanner leitor){
    return leitor.nextInt();
}
    
public static int getIdadeMinima(Scanner leitor) {
    System.out.println("Qual a idade mínima?\n");
    return leitor.nextInt(); 
}

public static int getDuracaoDias(Scanner leitor) {
    System.out.println("Quantos dias de duração?\n");
    return leitor.nextInt(); 
}

public static String getNomeArtista(Scanner leitor) {
    System.out.println("Qual o nome do artista?\n");
    return leitor.nextLine();
}

public static String getGeneroMusical(Scanner leitor) {
    System.out.println("Qual o gênero musical?\n");
    return leitor.nextLine();
}

public static String getEsporte(Scanner leitor) {
    System.out.println("Qual o esporte?\n");
    return leitor.nextLine();
}

public static String getEquipe1(Scanner leitor) {
    System.out.println("Qual a primeira equipe?\n");
    return leitor.nextLine();
}

public static String getEquipe2(Scanner leitor) {
    System.out.println("Qual a segunda equipe?\n");
    return leitor.nextLine();
}
            
}




/*   String nomeEvento, String dataEvento, String localEvento, int ingressosInteira, int ingressosMeia, double precoCheio, String nomeArtista,
        String generoMusical

Foi solicitado que você elabore uma interface por linha de comando
de forma que o usuário possa realizar as seguintes operações:

Cadastre um novo evento;

Realize a venda de um ingresso, em que o usuário escolhe o tipo do ingresso (inteira ou meia)
e apresenta as características particulares do ingresso (desconto social, por exemplo),
e o programa gera um ingresso e exibe na tela as informações. O usuário deve confirmar se
as informações estão corretas e o programa deve sinalizar que a compra foi realizada;

Exibir informações do evento;

Exibir o número de ingressos restantes;

Exibir informações do último ingresso vendido;

O programa só precisa armazenar um evento e um ingresso por vez.
Ou seja, se um novo evento for cadastrado, o evento anterior é apagado.

===============================================================================================

O aplicativo deve permitir que o usuário visualize a lista de partidas disponíveis para venda;

Para cada partida, o usuário deve poder escolher a quantidade e o tipo de ingressos desejados;

O aplicativo deve calcular o preço total da compra de acordo com a quantidade e o tipo de ingressos selecionados;

Após o pagamento, o usuário deve receber uma mensagem com as informações sobre a partida e a quantidade e o tipo de ingressos comprados.

*/


