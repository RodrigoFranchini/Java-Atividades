import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GerenciamentoInvestimentos {
    private List<Investimento> investimentos;

    public GerenciamentoInvestimentos() {
        investimentos = new ArrayList<>();
    }

    public void registrarInvestimento(Investimento investimento) {
        investimentos.add(investimento);
    }

    public void exibirHistoricoAportes(Investimento investimento) {
        System.out.println("Tipo: " + investimento.getTipo());
        System.out.println("Investimento Inicial: " + investimento.getInvestimentoInicial());
        System.out.println("Data de Vencimento: " + investimento.getDataVencimento());
        System.out.println("Aportes Mensais: " + investimento.getAportesMensais());
    }

    public void exibirTiposInvestimentos() {
        for (Investimento investimento : investimentos) {
            System.out.println("Tipo: " + investimento.getTipo());
        }
    }

    public double calcularTotalInvestido() {
        double total = 0;
        for (Investimento investimento : investimentos) {
            total += investimento.calcularTotalInvestido();
        }
        return total;
    }

    public void exportarParaCSV(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("Tipo,Investimento Inicial,Data de Vencimento,Aportes Mensais,Total Investido\n");
            for (Investimento investimento : investimentos) {
                writer.append(investimento.getTipo()).append(",");
                writer.append(String.valueOf(investimento.getInvestimentoInicial())).append(",");
                writer.append(investimento.getDataVencimento()).append(",");
                writer.append(investimento.getAportesMensais().toString()).append(",");
                writer.append(String.valueOf(investimento.calcularTotalInvestido())).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciamentoInvestimentos meuInvestimento = new GerenciamentoInvestimentos();

        System.out.println("Digite o tipo de investimento:");
        String tipo = sc.nextLine();
        System.out.println("Digite o investimento inicial:");
        double investimentoInicial = sc.nextDouble();
        sc.nextLine(); // Consumir a nova linha
        System.out.println("Digite a data de vencimento (dd/MM/yyyy):");
        String dataVencimento = sc.nextLine();
        Investimento investimento = new Investimento(tipo, investimentoInicial, dataVencimento);

        System.out.println("Quantos aportes mensais serão feitos?");
        int a = sc.nextInt();
        sc.nextLine();
        int aporte = 0;
        for (int j = 0; j < a; j++) {
            System.out.println("Quanto será aportado no " + (j + 1) + " mês?");
            aporte = sc.nextInt();
            investimento.addAporte(aporte);
        }

        meuInvestimento.registrarInvestimento(investimento);
        meuInvestimento.exportarParaCSV("meusinvestimentos.csv");
        sc.close();
    }
}
