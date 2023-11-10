import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);
    System.out.println("Qual a data do evento(dd/mm/yyyy)?\n");
    String str = leitor.nextLine();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate data = LocalDate.parse(str, dtf);

    System.out.println(data);
    leitor.close();
    }
}
