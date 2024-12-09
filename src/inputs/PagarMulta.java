package inputs;

import biblioteca.Biblioteca;
import exceptions.UsuarioNaoEncontradoException;
import usuarios.Pessoa;

import java.util.Scanner;

public class PagarMulta {

    public static void pagar(Scanner scanner, Biblioteca biblioteca){

        Pessoa usuario;
        try {
            usuario = Common.inputUsuario(scanner, biblioteca);
        } catch (UsuarioNaoEncontradoException e){
            System.out.println("Usuário não encontrado");
            return;
        }
        if (usuario.getSomaMultas() == 0){
            System.out.println(usuario.getNome() + " não possui nenhuma multa pendente.");
            return;
        }

        System.out.println("Total a pagar: R$" + usuario.getSomaMultas());

        double valor = Common.inputDouble(scanner);
        biblioteca.pagarMulta(usuario, valor);

    }

}
