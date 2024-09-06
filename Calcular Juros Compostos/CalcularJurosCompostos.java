public class CalcularJurosCompostos {

    // Método que calcula os juros compostos
    public double calcular(double principal, double taxa, int periodos) {
        return principal * Math.pow(1 + taxa, periodos); // Fórmula Juros Compostos
    }
}
