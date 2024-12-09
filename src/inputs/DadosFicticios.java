package inputs;

import biblioteca.Biblioteca;
import livro.Livro;
import usuarios.Aluno;
import usuarios.Funcionario;
import usuarios.Professor;

public class DadosFicticios {

    public static void adicionar(Biblioteca biblioteca){

        biblioteca.cadastrarUsuario(
                new Aluno("Antonio", "111111111", "Engenharia de Software", 1)
        );

        biblioteca.cadastrarUsuario(
                new Aluno("Bruna", "222222222", "Engenharia Mecânica", 2)
        );

        biblioteca.cadastrarUsuario(
                new Professor("Carlos", "333333333", "Medicina")
        );

        biblioteca.cadastrarUsuario(
                new Professor("Daniela", "444444444", "Biomedicina")
        );

        biblioteca.cadastrarUsuario(
                new Funcionario("Eric", "555555555", "Recursos Humanos", "Analista de Pessoal")
        );

        biblioteca.cadastrarUsuario(
                new Funcionario("Ana", "777777777", "Financeiro", "Contador")
        );

        biblioteca.adicionarLivro(
                new Livro("Diário de um Banana 1", "Robert Einstein", 2012)
        );

        biblioteca.adicionarLivro(
                new Livro("Diário de um Banana 5", "Robert Einstein", 2016)
        );

        biblioteca.adicionarLivro(
                new Livro("Diário de um Banana 11", "Robert Einstein", 2020)
        );

        biblioteca.adicionarLivro(
                new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943)
        );

        biblioteca.adicionarLivro(
                new Livro("1984", "George Orwell", 1949)
        );

        biblioteca.adicionarLivro(
                new Livro("Dom Quixote", "Miguel de Cervantes", 1605)
        );

        biblioteca.adicionarLivro(
                new Livro("O Hobbit", "J.R.R. Tolkien", 1937)
        );

        biblioteca.adicionarLivro(
                new Livro("A Culpa é das Estrelas", "John Green", 2012)
        );

        biblioteca.adicionarLivro(
                new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997)
        );

        biblioteca.adicionarLivro(
                new Livro("Orgulho e Preconceito", "Jane Austen", 1813)
        );

        biblioteca.adicionarLivro(
                new Livro("O Código Da Vinci", "Dan Brown", 2003)
        );

        biblioteca.adicionarLivro(
                new Livro("A Menina que Roubava Livros", "Markus Zusak", 2005)
        );


    }

}
