import java.security.SecureRandom;

public class PasswordGenerator {

  private static final String CHAR_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // String com todos os caracteres em maiúsculo.
  private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz"; // String com todos caracteres em minúsculo.
  private static final String DIGITS = "0123456789"; // String com todos os dígitos.
  private static final String ALL_CHARS = CHAR_UPPER + CHAR_LOWER + DIGITS; // String com tudos caracteres juntos.

  public String generatePassword(int length) {
    SecureRandom random = new SecureRandom(); // Gera um número aleatório.
    StringBuilder password = new StringBuilder(); // Gera um password de maneira mais eficiente usando o StringBuilder, pois evita o desperdício de memória e melhora o desempenho.

    for (int i = 0; i < length; i++) { // loop para iterar "length" vezes onde a cada iteração um caractere aleatório dentro de "ALL_CHARS" é selecionado.
      int randomIndex = random.nextInt(ALL_CHARS.length()); // Gera o índice entre 0 e a length de ALL_CHARS.
      password.append(ALL_CHARS.charAt(randomIndex)); // Concatena as Strings.
    }

    return password.toString();
  }
}
