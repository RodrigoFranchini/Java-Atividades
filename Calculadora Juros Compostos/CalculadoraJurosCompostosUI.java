import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CalculadoraJurosCompostosUI extends JFrame {

    // Componentes da interface
    private JTextField principalField;
    private JTextField taxaField;
    private JTextField periodosField;
    private JLabel resultadoLabel;
    private CalcularJurosCompostos calculadora;

    public CalculadoraJurosCompostosUI() {
        // Instancia a classe de cálculo de juros compostos
        calculadora = new CalcularJurosCompostos();

        setTitle("Calculadora de Juros Compostos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Inicializando os componentes
        principalField = new JTextField();
        taxaField = new JTextField();
        periodosField = new JTextField();
        resultadoLabel = new JLabel("Resultado: ");
        JButton calcularButton = new JButton("Calcular");

        // Adicionando os componentes à janela
        add(new JLabel("Principal (Valor Inicial): "));
        add(principalField);
        add(new JLabel("Taxa de Juros (%): "));
        add(taxaField);
        add(new JLabel("Número de Períodos: "));
        add(periodosField);
        add(new JLabel(""));
        add(calcularButton);
        add(new JLabel(""));
        add(resultadoLabel);

        // Adicionando funcionalidade ao botão de calcular
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularJurosCompostos();
            }
        });
    }

    private void calcularJurosCompostos() {
        try {
            double principal = Double.parseDouble(principalField.getText());
            double taxa = Double.parseDouble(taxaField.getText()) / 100;
            int periodos = Integer.parseInt(periodosField.getText());

            // Chamando o método de cálculo da classe CalculadoraJurosCompostos
            double montante = calculadora.calcular(principal, taxa, periodos);

            // Formatando o resultado para duas casas decimais
            DecimalFormat df = new DecimalFormat("#.##");
            resultadoLabel.setText("Resultado: " + df.format(montante));

        } catch (NumberFormatException ex) {
            // Tratamento de erro caso os valores inseridos não sejam números válidos
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
