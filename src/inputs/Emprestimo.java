package inputs;

import java.util.List;
import java.util.Scanner;
import biblioteca.Biblioteca;
import exceptions.*;
import livro.Livro;
import usuarios.Pessoa;

public class Emprestimo {

    public static void fazerEmprestimo(Scanner scanner, Biblioteca biblioteca){

        Pessoa usuario;
        try {
            usuario = Common.inputUsuario(scanner, biblioteca);
        } catch (UsuarioNaoEncontradoException e){
            System.out.println("Erro: usuário não encontrado.");
            return;
        }

        if (usuario.atingiuLimiteEmprestimos()){
            System.out.println("Empréstimo negado: " + usuario.getNome() + " atingiu seu limite de empréstimos (" + usuario.getLimiteEmprestimo() + ")");
            return;
        }

        Livro livro;
        try {
            livro = Common.inputLivro(scanner, biblioteca.getLivrosDisponiveis());
        } catch (LivroNaoEncontradoException e) {
            System.out.println("Erro: Livro não encontrado.");
            return;
        } catch (NenhumLivroDisponivelException e){
            System.out.println("Nenhum livro disponível para empréstimo.");
            return;
        }

        if (!livro.isDisponivel()){
            System.out.println("Livro indisponível até " + livro.getDataDevolucao());
            return;
        }
        biblioteca.fazerEmprestimo(usuario, livro);

    }



    public static void finalizarEmprestimo(Scanner scanner, Biblioteca biblioteca){

        Pessoa usuario;
        try {
            usuario = Common.inputUsuario(scanner, biblioteca);
        } catch (UsuarioNaoEncontradoException e){
            System.out.println("Erro: usuário não encontrado.");
            return;
        }

        if (!usuario.possuiEmprestimos()){
            System.out.println(usuario.getNome() + " não possui nenhum livro para devolver.");
            return;
        }

        Livro livro = Common.inputLivro(scanner, biblioteca.getLivrosEmprestados());
        biblioteca.finalizarEmprestimo(livro);

    }

}
