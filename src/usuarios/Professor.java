package usuarios;

import livro.Livro;

public class Professor extends Pessoa{

    private String disciplina;
    
    public Professor(String nome, String telefone, String disciplina) {
        super(nome, telefone, 10);
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String solicitarEmprestimo(Livro livro, String emprestimo){

            if (!livro.isDisponivel()) {
                return "livro.Livro não disponível para empréstimo";
            }
            
            if (getLimiteEmprestimo() <= 0) {
                return "Limite de empréstimos excedido";
            }

            setLimiteEmprestimo(getLimiteEmprestimo() - 1);
            
            emprestimo = "Empréstimo realizado para o professor " + getNome() + 
                         " - Disciplina: " + getDisciplina() + 
                         " - livro.Livro: " + livro.getTitulo();
            
            return emprestimo;
        }
}
