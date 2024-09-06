import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Exibir calculadora
        SwingUtilities.invokeLater(() -> {
            CalculadoraJurosCompostosUI calculadoraUI = new CalculadoraJurosCompostosUI();
            calculadoraUI.setVisible(true);
        });
    }
}
