import java.util.*;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> senhasGeradas = new ArrayList<>(); ///  Array com as listas já criadas
    PasswordGenerator generator = new PasswordGenerator();
    System.out.println("Digite a quantidade de senhas a serem geradas:");
    int quantidadeSenhas = sc.nextInt();

    for (int i = 0; i < quantidadeSenhas; i++) {
      String senha = generator.generatePassword(8);
      senhasGeradas.add(senha);
    }

    String nomeArquivo = "senhas.txt";

    // Chamando os métodos da classe FileHandler para escrever e ler as senhas
    File.escreverSenhas(senhasGeradas, nomeArquivo);
    ArrayList<String> senhasLidas = File.lerSenhas(nomeArquivo);

    // Agora as senhas estão armazenadas na lista 'senhasLidas' e podem ser usadas conforme necessário
    for (String senha : senhasLidas) {
      System.out.println("Senha lida: " + senha);
    }
    sc.close();
  }
}
