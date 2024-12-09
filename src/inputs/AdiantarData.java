package inputs;

import biblioteca.Biblioteca;

import java.util.Scanner;

public class AdiantarData {

    protected static void adiantar(Scanner scanner, Biblioteca biblioteca){
        int numsDias = inputDias(scanner);
        biblioteca.adiantarData(numsDias);
    }

    private static int inputDias(Scanner scanner){

        while (true){
            System.out.print("Digite um número de dias: ");
            if (scanner.hasNextInt())
                return scanner.nextInt();
            System.out.println("Entrada inválida.");
        }

    }

}
