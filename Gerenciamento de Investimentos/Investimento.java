import java.util.ArrayList;
import java.util.List;

public class Investimento {
    private String tipo;
    private double investimentoInicial;
    private List<Double> aportesMensais;
    private String dataVencimento;

    public Investimento(String tipo, double investimentoInicial, String dataVencimento) {
        this.tipo = tipo;
        this.investimentoInicial = investimentoInicial;
        this.dataVencimento = dataVencimento;
        this.aportesMensais = new ArrayList<>();
    }

    public String getTipo() {
        return tipo;
    }

    public double getInvestimentoInicial() {
        return investimentoInicial;
    }

    public List<Double> getAportesMensais() {
        return aportesMensais;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void addAporte(double aporte) {
        aportesMensais.add(aporte);
    }

    public double calcularTotalInvestido() {
        double total = investimentoInicial;
        for (double aporte : aportesMensais) {
            total += aporte;
        }
        return total;
    }

    public double calcularTotalAportes() {
        double total = 0;
        for (double aporte : aportesMensais) {
            total += aporte;
        }
        return total;
    }
}
