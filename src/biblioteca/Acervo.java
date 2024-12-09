package biblioteca;

import exceptions.LivroNaoEncontradoException;
import livro.Livro;

import java.util.ArrayList;
import java.util.List;

public class Acervo {

    private final List<Livro> livros;

    public Acervo(){
        this.livros = new ArrayList<>();
    }
    
    public List<Livro> getLivros() {
        return livros;
    }
    
    public void adicionarLivro(Livro livro){
        for (Livro livroBiblioteca : livros){
            if (livro.getTitulo().equals(livroBiblioteca.getTitulo())){
                System.out.println("O livro '" + livro.getTitulo() + "' já está registrado na biblioteca.");
                return;
            }
        }
        livros.add(livro);
    }
    
    public void removerLivro(Livro livro){
        if (livros.remove(livro)){
            System.out.println("Livro " + livro.getTitulo() + "removido com sucesso");
            return;
        }
        System.out.println("Erro: O acervo não contém o livro " + livro.getTitulo());
    }
    
    public List<Livro> pesquisarLivros(String pesquisa){
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : livros){
            if (livro.getTitulo().equals(pesquisa) || livro.getAutor().equals(pesquisa)){
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public Livro pesquisarLivro(String titulo){
        for (Livro livro : livros){
            if (titulo.equals(livro.getTitulo())){
                return livro;
            }
        }
        throw new LivroNaoEncontradoException(titulo);
    }
    
    public boolean contemLivro(String pesquisa) {
        for (Livro livro : livros){
            if (livro.getTitulo().equals(pesquisa)){
                return true;
            }
        }
        return false;
    }


    
    public List<Livro> getLivrosDisponiveis() {
        List<Livro> livrosDisponiveis = new ArrayList<>();
        for (Livro livro : livros){
            if (livro.isDisponivel()){
                livrosDisponiveis.add(livro);
            }
        }
        return livrosDisponiveis;
    }

}
