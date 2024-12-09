package inputs;

import biblioteca.Biblioteca;

import java.util.Scanner;

public class Relatorio {

    public static void gerar(Scanner scanner, Biblioteca biblioteca){

        System.out.println("1 - Relatório de Empréstimos");
        System.out.println("2 - Relatório de Multas");
        System.out.println("3 - Relatório de Usuários");
        System.out.println("4 - Voltar");

        int opcao = inputs.Common.getOpcao(scanner, 4);
        System.out.println();

        switch (opcao){
            case 1:
                biblioteca.gerarRelatorioEmprestimos();
                break;
            case 2:
                biblioteca.gerarRelatorioMultas();
                break;
            case 3:
                biblioteca.gerarRelatorioUsuarios();
                break;
            case 4:
                System.out.println("Voltando...");
                break;
            default:
                System.out.println("Erro.");
        }
        System.out.println();

    }

}
