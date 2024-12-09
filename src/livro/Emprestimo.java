package livro;

import usuarios.Pessoa;

import java.time.LocalDate;

public class Emprestimo {

    private Livro livro;
    private Pessoa usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private String status;
    
    public Emprestimo(Livro livro, Pessoa usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public Pessoa getUsuario() {
        return usuario;
    }
    public void setUsuario(Pessoa usuario) {
        this.usuario = usuario;
    }
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }
    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String finalizarEmprestimo() {
        if (livro.isDisponivel()) {
            return "Erro: O livro já está disponível e não há empréstimo ativo.";
        }
    
        livro.devolver();
        status = "Finalizado";
        usuario.setLimiteEmprestimo(usuario.getLimiteEmprestimo() + 1);
    
        return "Empréstimo finalizado para o livro: " + livro.getTitulo() + " pelo usuário: " + usuario.getNome();
    }
    

}
