package entidades;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import gestor.Gestor;
import entidades.ingressos.TipoIngresso;
import entidades.ingressos.IngShow.EspacoEnum;

public class LeitoraDeDados {

    static Scanner leitor = new Scanner(System.in);

public static String getNome(){
    System.out.println("\nQual o nome do evento? ");
    leitor.nextLine();
    return leitor.nextLine();
} // adicionar excessão nome vazio

public static int getIngressosInteira() {
    System.out.println("\nQuantos ingressos INTEIRA existem? ");
    return leitor.nextInt();
}

public static int getIngressosMeia() {
    System.out.println("\nQuantos ingressos MEIA existem? ");
    return leitor.nextInt();
}

public static Double getPrecoCheio() {
    System.out.println("\nQual o preço cheio do ingresso? ");
    return leitor.nextDouble();
}

public static String getLocal() {
    System.out.println("\nQual o local do evento? ");
    return leitor.nextLine();
}

public static String getNovoLocal() {
    System.out.println("\nQual o novo local? ");
    return leitor.nextLine();
}

public static LocalDate getData() {
    System.out.println("\nQual a data do evento? (dia/mês/ano)");
    String dataStr = leitor.nextLine();
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate data = LocalDate.parse(dataStr, formatador);
    return data;
}

public static LocalDate getNovaData() {
    System.out.println("\nQual a nova data? (dia/mês/ano)");
    String dataStr = leitor.nextLine();
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate data = LocalDate.parse(dataStr, formatador);
    return data;
}

public static Integer getOpcao(int Max){
    int opcao = leitor.nextInt();
    while (true) {
        if (opcao <= 0 || opcao > Max) {
            System.out.println("\nValor inválido! Tente novamente.");
            opcao = leitor.nextInt();
        } else {
            return opcao;
        }
    }
}

public static int getIdadeMinima() {
    System.out.println("\nQual a idade mínima?");
    return leitor.nextInt();
}

public static int getDuracaoDias() {
    System.out.println("\nQuantos dias de duração?");
    return leitor.nextInt();
}

public static int getQuantidade() {
    System.out.println("\nQuantos ingressos deseja?");
    int quantidade = leitor.nextInt();
    while (true) {
        if (quantidade <= 0) {
            System.out.println("\nQuantidade inválida! Tente novamente.");
            quantidade = leitor.nextInt();
        } else {
            return quantidade;
        }
    }
}

public static String getNomeArtista() {
    leitor.nextLine();
    System.out.println("\nQual o nome do artista?");
    return leitor.nextLine();
}

public static String getGeneroMusical() {
    System.out.println("\nQual o gênero musical?");
    return leitor.nextLine();
}

public static String getEsporte() {
    leitor.nextLine();
    System.out.println("\nQual o esporte?");
    return leitor.nextLine();
}

public static String getEquipe1() {
    System.out.println("\nQual a primeira equipe?");
    return leitor.nextLine();
}

public static String getEquipe2() {
    System.out.println("\nQual a segunda equipe?");
    return leitor.nextLine();
}

public static TipoIngresso getTipoIngresso() {
    System.out.println("\nQual o tipo de ingresso deseja comprar?\n  1 - INTEIRA\n  2 - MEIA");
    int tipoInt = leitor.nextInt();

    while (true) {
        if (tipoInt == 1) {
            return TipoIngresso.INTEIRA;
        } else if (tipoInt == 2) {
            return TipoIngresso.MEIA;
        } else {
            System.out.println("\nTipo de ingresso inválido! Tente novamente.");
            tipoInt = leitor.nextInt();
        }
    }
}

public static boolean getDescontoSocial() {
    System.out.println("\nPossui desconto social?\n  1 - SIM\n  2 - NÃO ");
    int descontoInt = leitor.nextInt();

    while (true) {
        if (descontoInt == 1) {
            return true;
        } else if (descontoInt == 2) {
            return false;
        } else {
            System.out.println("\nOpção inválida! Tente novamente.");
            descontoInt = leitor.nextInt();
        }
    }
}

public static Double getDescontoTorcedor() {
    System.out.println("\nSe possui desconto torcedor digite aqui!");
    double descontoTorcedor = leitor.nextDouble();

    while (true) {
        if (descontoTorcedor < 0 || descontoTorcedor > 100 ) {
            System.out.println("\nValor inválido! Tente novamente.");
            descontoTorcedor = leitor.nextInt();
        } else {
            return descontoTorcedor;
        }
    }
}

public static EspacoEnum getEspacoEnum() {
    System.out.println("\nQual o espaço do show deseja ficar?\n  1 - PISTA\n  2 - CAMAROTE");
    EspacoEnum espacoEnum;
    int espacoInt = leitor.nextInt();

    while (true) {
        if (espacoInt == 1) {
            return EspacoEnum.PISTA;
        } else if (espacoInt == 2) {
            return EspacoEnum.CAMAROTE;
        } else {
            System.out.println("\nEspaço inválido! Tente novamente.");
            espacoInt = leitor.nextInt();
        }
    }
}

}


