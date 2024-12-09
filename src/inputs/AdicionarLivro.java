package inputs;

import biblioteca.Biblioteca;
import livro.Livro;

import java.util.Scanner;

public class AdicionarLivro {

    protected static void adicionarLivro(Scanner scanner, Biblioteca biblioteca){

        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o autor: ");
        String autor = scanner.nextLine();

        int anoPublicacao = Common.inputInt(scanner);

        biblioteca.adicionarLivro(new Livro(titulo, autor, anoPublicacao));

    }

}
