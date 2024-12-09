package livro;

public class Multa {

    private static final String PENDENTE = "Pendente";
    private static final String PAGO = "Pago";

    private double valor;
    private Emprestimo emprestimo;
    private String status;

    public Multa(double valor, Emprestimo emprestimo) {
        this.valor = valor;
        this.emprestimo = emprestimo;
        this.status = PENDENTE;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float calcularMulta(float valor, float multa) {

        return multa;
    }

    public double pagar(double valor) {
        if (valor >= this.valor){
            valor -= this.valor;
            this.valor = 0;
            this.status = PAGO;
            return valor;
        }
        this.valor -= valor;
        return 0;
    }

    public boolean isPendente() {
        return status.equals(PENDENTE);
    }
}
