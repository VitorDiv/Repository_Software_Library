package usuarios;

public class Aluno extends Pessoa{

    private String curso;
    private int periodo;
    
    public Aluno(String nome, String telefone, String curso, int periodo) {
        super(nome, telefone, 3);
        this.curso = curso;
        this.periodo = periodo;
    }

    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public int getPeriodo() {
        return periodo;
    }
    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }



}
