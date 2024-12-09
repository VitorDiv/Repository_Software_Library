import biblioteca.Acervo;
import biblioteca.Biblioteca;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca(new Acervo());

        int opcao;
        boolean rodando = true;
        while (rodando) {
            inputs.Common.exibirOpcoes(biblioteca);
            opcao = inputs.Common.getOpcao(scanner, -1);
            rodando = inputs.Common.executar(scanner, biblioteca, opcao);
        }

        scanner.close();

    }





}
