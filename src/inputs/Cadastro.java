package inputs;

import biblioteca.Biblioteca;
import usuarios.Aluno;
import usuarios.Funcionario;
import usuarios.Professor;

import java.util.Scanner;

public class Cadastro {

    private static String inputNome(Scanner scanner){
        System.out.print("Digite o nome: ");
        return scanner.nextLine();
    }

    private static String inputTelefone(Scanner scanner){
        System.out.print("Digite o telefone: ");
        return scanner.nextLine();
    }

    private static void cadastrarAluno(Scanner scanner, Biblioteca biblioteca){

        String nome = inputNome(scanner);
        String telefone = inputTelefone(scanner);

        System.out.print("Digite o curso: ");
        String curso = scanner.next();

        System.out.print("Digite o período: ");
        int periodo = scanner.nextInt();
        System.out.println();

        Aluno aluno = new Aluno(nome, telefone, curso, periodo);
        biblioteca.cadastrarUsuario(aluno);

    }

    private static void cadastrarProfessor(Scanner scanner, Biblioteca biblioteca){

        String nome = inputNome(scanner);
        String telefone = inputTelefone(scanner);

        System.out.print("Digite a disciplina: ");
        String disciplina = scanner.next();
        System.out.println();

        Professor profesor = new Professor(nome, telefone, disciplina);
        biblioteca.cadastrarUsuario(profesor);
    }

    private static void cadastrarFuncionario(Scanner scanner, Biblioteca biblioteca){

        String nome = inputNome(scanner);
        String telefone = inputTelefone(scanner);

        System.out.print("Digite a departamento: ");
        String departamento = scanner.nextLine();

        System.out.print("Digite a cargo: ");
        String cargo = scanner.nextLine();
        System.out.println();

        Funcionario funcionario = new Funcionario(nome, telefone, departamento, cargo);
        biblioteca.cadastrarUsuario(funcionario);

    }

    public static void cadastrar(Scanner scanner, Biblioteca biblioteca) {

        System.out.println("1 - Cadastrar Aluno");
        System.out.println("2 - Cadastrar Professor");
        System.out.println("3 - Cadastrar Funcionário");
        System.out.println("4 - Voltar");
        int opcao = Common.getOpcao(scanner, 4);

        while (true) {
            switch (opcao) {

                case 1:
                    cadastrarAluno(scanner, biblioteca);
                    return;

                case 2:
                    cadastrarProfessor(scanner, biblioteca);
                    return;

                case 3:
                    cadastrarFuncionario(scanner, biblioteca);
                    return;

                case 4:
                    System.out.println("Voltando...");
                    return;

                default:
                    System.out.println("Entrada inválida.");

            }
        }
    }
}
