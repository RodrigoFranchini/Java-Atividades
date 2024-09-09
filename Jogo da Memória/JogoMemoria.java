import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.ArrayList;

public class JogoMemoria extends JFrame implements ActionListener {
    private int gridSize;
    private JButton[] buttons;
    private ArrayList<String> cards;
    private JButton firstButton;
    private JButton secondButton;
    private int pairsFound = 0;

    public JogoMemoria(int gridSize) {
        this.gridSize = gridSize;

        // Configura a janela
        setTitle("Memory Game");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(gridSize, gridSize));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializa os botões e valores das cartas
        buttons = new JButton[gridSize * gridSize];
        cards = new ArrayList<>();

        // Adiciona pares de valores (A, B, C, etc.)
        for (char c = 'A'; c < 'A' + (gridSize * gridSize) / 2; c++) {
            cards.add(String.valueOf(c));
            cards.add(String.valueOf(c));
        }

        // Embaralha os valores
        Collections.shuffle(cards);

        // Adiciona botões e atribui valores embaralhados
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.BOLD, 24));
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        // Verifica se um botão já está aberto ou se já foram clicados dois botões
        if (firstButton != null && secondButton != null) {
            return;
        }

        // Identifica o índice do botão clicado
        int index = -1;
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i] == clickedButton) {
                index = i;
                break;
            }
        }

        // Define o texto do botão clicado
        clickedButton.setText(cards.get(index));

        if (firstButton == null) {
            firstButton = clickedButton;
        } else {
            secondButton = clickedButton;

            // Verifica se os botões clicados têm valores iguais
            if (firstButton.getText().equals(secondButton.getText())) {
                firstButton.setEnabled(false);
                secondButton.setEnabled(false);
                pairsFound++;
                firstButton = null;
                secondButton = null;

                // Verifica se o jogo acabou
                if (pairsFound == (gridSize * gridSize) / 2) {
                    JOptionPane.showMessageDialog(this, "You Won!");
                }
            } else {
                // Adiciona um atraso para mostrar as cartas por um breve momento
                Timer timer = new Timer(500, ev -> {
                    firstButton.setText("");
                    secondButton.setText("");
                    firstButton = null;
                    secondButton = null;
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }

    public static void main(String[] args) {
        int gridSize = 0;

        // Loop para garantir que o usuário insira um tamanho de grade válido
        while (true) {
            String input = JOptionPane.showInputDialog(null, "Enter the grid size (e.g., 2 for 2x2, 4 for 4x4):");

            try {
                gridSize = Integer.parseInt(input);

                // Verifica se o tamanho é válido (pelo menos 2x2 e par)
                if (gridSize >= 2 && gridSize % 2 == 0) {
                    break; // Saia do loop se o tamanho for válido
                } else {
                    JOptionPane.showMessageDialog(null, "Grid size must be an even number and at least 2.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        }

        // Inicia o jogo com o tamanho da grade fornecido pelo usuário
        new JogoMemoria(gridSize);
    }
}
