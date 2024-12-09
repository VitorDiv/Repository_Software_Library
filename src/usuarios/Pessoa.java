package usuarios;

import livro.Emprestimo;
import livro.Livro;
import livro.Multa;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    // Constantes para auxiliar no status da pessoa
    protected static final String NORMAL = "Normal";
    protected static final String PENDENTE = "Pendente";

    private String nome;
    private String telefone;
    private String status;
    private int limiteEmprestimo;
    private List<Livro> livrosEmprestados;
    private List<Emprestimo> historicoEmprestimo;
    private List<Multa> multas;

    private final int id;
    private static int idCounter = 0;

    public Pessoa(String nome, String telefone, int limiteEmprestimo) {
        this.nome = nome;
        this.telefone = telefone;
        this.limiteEmprestimo = limiteEmprestimo;
        this.livrosEmprestados = new ArrayList<>();
        this.historicoEmprestimo = new ArrayList<>();
        this.multas = new ArrayList<>();
        this.status = NORMAL;
        this.id = idCounter;
        idCounter++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    public void setLimiteEmprestimo(int limiteEmprestimo) {
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public List<Emprestimo> getHistoricoEmprestimo() {
        return historicoEmprestimo;
    }

    public void setHistoricoEmprestimo(List<Emprestimo> historicoEmprestimo) {
        this.historicoEmprestimo = historicoEmprestimo;
    }

    public List<Multa> getMultas(){
        return multas;
    }

    public List<Livro> getLivrosEmprestados(){
        return livrosEmprestados;
    }

    public void emprestar(Emprestimo emprestimo){
        historicoEmprestimo.add(emprestimo);
        livrosEmprestados.add(emprestimo.getLivro());
    }

    public void devolver(Livro livro) {
        livrosEmprestados.remove(livro);
        livro.devolver();
    }

    public double getSomaMultas(){
        double total = 0;
        for (Multa multa : multas){
            total += multa.getValor();
        }
        return total;
    }

    public void adicionarMulta(Multa multa){
        multas.add(multa);
    }

    public void pagarMulta(double valor){

        Multa multa;
        while (valor > 0 && !multas.isEmpty()){
            multa = multas.getFirst();
            valor = multa.pagar(valor);
            if (!multa.isPendente()){
                multas.removeFirst();
            }
        }

        if (multas.isEmpty())
            System.out.println("Não há mais multas a pagar.");
        else
            System.out.println("Ainda há R$" + getSomaMultas() + " em multa(s) a pagar.");

        if (valor > 0)
            System.out.println("Troco: R$" + valor);

    }

    public boolean isPendente(){
        return !multas.isEmpty();
    }

    public boolean atingiuLimiteEmprestimos(){
        return livrosEmprestados.size() >= limiteEmprestimo;
    }

    public boolean possuiEmprestimos(){
        return !livrosEmprestados.isEmpty();
    }

}
