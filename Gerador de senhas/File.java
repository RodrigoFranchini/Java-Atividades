import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class File {

  public static void escreverSenhas(
    ArrayList<String> senhasGeradas,
    String nomeArquivo
  ) {
    try (
      BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))
    ) {
      for (String senha : senhasGeradas) {
        writer.write(senha);
        writer.newLine();
      }
      System.out.println(
        "Senhas foram escritas no arquivo '" + nomeArquivo + "'."
      );
    } catch (IOException e) {
      System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
    }
  }

  public static ArrayList<String> lerSenhas(String nomeArquivo) {
    ArrayList<String> senhasLidas = new ArrayList<>();
    try (
      BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))
    ) {
      String linha;
      while ((linha = reader.readLine()) != null) {
        senhasLidas.add(linha);
      }
    } catch (IOException e) {
      System.err.println("Erro ao ler do arquivo: " + e.getMessage());
    }
    return senhasLidas;
  }
}
