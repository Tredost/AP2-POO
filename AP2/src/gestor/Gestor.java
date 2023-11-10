package gestor;
import java.util.Scanner;
import entidades.LeitoraDeDados;
import entidades.eventos.Evento;
import entidades.ingressos.Ingresso;

public class Gestor {
    public static void rodarGestor() {
        Scanner leitor = new Scanner(System.in);
        Evento evento = null;
        Ingresso ingresso = null;

        while (true) {
            System.out.println("O que deseja fazer?\n  1 - Cadastrar novo evento\n  2 - Comprar ingressos\n  3 - Informações do evento\n  4 - Informações sobre quantidade de ingressos restantes\n");
            int opcao = leitor.nextInt();

            switch (opcao) {

                case 1:
                    evento = LeitoraDeDados.cadastrarEvento(leitor);
                    break;
                case 2:
                    if (evento != null) {
                        ingresso = LeitoraDeDados.comprarIngresso(leitor, evento);
                    } else {
                        System.out.println("CADASTRE UM EVENTO PRIMEIRO!\n");
                    }
                    break;

                case 3:
                    if (evento != null) {
                        System.out.println("Informações:\n" + evento);
                    } else {
                        System.out.println("CADASTRE UM EVENTO PRIMEIRO!\n");
                    }
                    break;

                case 4:
                    if (evento != null) {
                        LeitoraDeDados.consultarIngressosRestantes(evento);
                    } else {
                        System.out.println("CADASTRE UM EVENTO PRIMEIRO!\n");
                    }
                    break;

                default:
                    System.out.println("OPÇÃO NÃO EXISTE!\n");
            }
        }
    }
}
