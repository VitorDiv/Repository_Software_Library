package livro;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Livro {

    // Constantes para auxiliar no status do livro
    private final static String EMPRESTADO = "Emprestado";
    private final static String DISPONIVEL = "Disponível";

    private static int idCounter = 1;

    private final int id;
    private final String titulo;
    private final String autor;
    private final int anoPublicacao;
    private String status;
    private LocalDate dataDevolucao;
    private Emprestimo emprestimo;


    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.emprestimo = null;

        this.id = idCounter;
        idCounter++;
        this.status = DISPONIVEL;
        this.dataDevolucao = null;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getStatus() {
        return status;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao){
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void emprestar(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
        this.dataDevolucao = emprestimo.getDataDevolucao();
        this.status = EMPRESTADO;
    }

    public void devolver() {
        this.dataDevolucao = null;
        this.status = DISPONIVEL;
    }

    public void renovar(int numDeDias) {
        dataDevolucao = dataDevolucao.plusDays(numDeDias);
    }

    public boolean isDisponivel() {
        return this.status.equals(DISPONIVEL);
    }

    public double calcularMulta(LocalDate dataAtual){

        if (dataAtual.isAfter(dataDevolucao)){
            return 0.75 * ChronoUnit.DAYS.between(dataDevolucao, dataAtual);
        }
        return 0;
    }

    public void imprimir() {
        System.out.println("======================================");

        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de publicação: " + anoPublicacao);
        System.out.println("Status: " + status);
        if (!isDisponivel()){
            System.out.println("Data de devolução: " + dataDevolucao);
        }

        System.out.println("======================================");
    }

}
