package inputs;

import biblioteca.Biblioteca;
import exceptions.NenhumLivroDisponivelException;
import exceptions.TelefoneNaoEncontradoException;
import exceptions.UsuarioNaoEncontradoException;
import livro.Livro;
import usuarios.Pessoa;

import javax.naming.BinaryRefAddr;
import java.util.List;
import java.util.Scanner;

public class Common {

    private static final int CADASTRAR = 1;
    private static final int ADICIONAR_LIVRO = 2;
    private static final int FAZER_EMPRESTIMO = 3;
    private static final int FINALIZAR_EMPRESTIMO = 4;
    private static final int PAGAR_MULTA = 5;
    private static final int GERAR_RELATORIO = 6;
    private static final int ADIANTAR_DATA = 7;
    private static final int SAIR = 8;
    private static final int ADICIONAR_DADOS = 9;

    private static boolean dadosAdicionados = false;

    public static int getOpcao(Scanner scanner, int numOpcoes){

        if (numOpcoes == -1)
            numOpcoes = ADICIONAR_DADOS;

        while (true){
            System.out.print("Escolha uma opção: ");
            if (scanner.hasNextInt()) {
                int opcao = scanner.nextInt();
                if (opcao >= 0 && opcao <= numOpcoes) {
                    scanner.nextLine();
                    return opcao;
                }
            }
            scanner.next();
            System.out.println("Opção inválida.");
        }

    }

    public static void exibirOpcoes(Biblioteca biblioteca){
        System.out.println(biblioteca.getDataDehoje());
        System.out.println(CADASTRAR + " - Cadastrar usuário");
        System.out.println(ADICIONAR_LIVRO + " - Adicionar livro");
        System.out.println(FAZER_EMPRESTIMO + " - Fazer empréstimo");
        System.out.println(FINALIZAR_EMPRESTIMO + " - Finalizar empréstimo");
        System.out.println(PAGAR_MULTA + " - Pagar multa(s)");
        System.out.println(GERAR_RELATORIO + " - Gerar relatório");
        System.out.println(ADIANTAR_DATA + " - Adiantar data");
        System.out.println(SAIR + " - Finalizar programa");
        if (!dadosAdicionados){
            System.out.println(ADICIONAR_DADOS + " - Adicionar dados fictícios");
        }
    }

    public static boolean executar(Scanner scanner, Biblioteca biblioteca, int opcao){

        System.out.println();
        switch (opcao){

            case ADICIONAR_DADOS:
                dadosAdicionados = true;
                DadosFicticios.adicionar(biblioteca);
                break;

            case CADASTRAR:
                Cadastro.cadastrar(scanner, biblioteca);
                break;

            case ADICIONAR_LIVRO:
                AdicionarLivro.adicionarLivro(scanner, biblioteca);
                break;

            case FAZER_EMPRESTIMO:
                Emprestimo.fazerEmprestimo(scanner, biblioteca);
                break;

            case FINALIZAR_EMPRESTIMO:
                Emprestimo.finalizarEmprestimo(scanner, biblioteca);
                break;

            case PAGAR_MULTA:
                PagarMulta.pagar(scanner, biblioteca);
                break;

            case GERAR_RELATORIO:
                Relatorio.gerar(scanner, biblioteca);
                break;

            case ADIANTAR_DATA:
                AdiantarData.adiantar(scanner, biblioteca);
                break;

            case SAIR:
                System.out.println("Finalizando programa...");
                return false;

            default:
                System.out.println("Entrada inválida");

        }
        System.out.println();
        return true;

    }

    public static Pessoa inputUsuario(Scanner scanner, Biblioteca biblioteca){

        while (true) {

            System.out.print("Digite o nome do usuário: ");
            String nome = scanner.nextLine();

            List<Pessoa> usuarios = biblioteca.pesquisarUsuarioPorNome(nome);
            if (usuarios.isEmpty()) {
                throw new UsuarioNaoEncontradoException(nome);
            }

            if (usuarios.size() == 1)
                return usuarios.getFirst();

            System.out.println("Existem " + usuarios.size() + " usuários com esse nome.");
            System.out.print("Digite o número de telefone: ");
            String telefone = scanner.nextLine();
            try {
                return biblioteca.pesquisarUsuarioPorTelefone(telefone);
            } catch (TelefoneNaoEncontradoException e){
                System.out.println("Entrada inválida.");
            }
        }
    }

    public static Livro inputLivro(Scanner scanner, List<Livro> livros){

        if (livros.isEmpty()){
            throw new NenhumLivroDisponivelException();
        }

        while (true) {
            System.out.println("\nLivros:");
            int n = 1;
            for (Livro livro : livros) {
                System.out.println(n + " - " + livro.getTitulo());
                n++;
            }
            System.out.print("\nDigite o número de um livro: ");
            n = scanner.nextInt();
            try {
                return livros.get(n - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Entrada inválida.");
            }
        }
    }

    public static double inputDouble(Scanner scanner){

        while (true){

            System.out.print("Digite um valor (R$): ");
            if (scanner.hasNextDouble())
                return scanner.nextDouble();
            System.out.println("Entrada inválida.");

        }

    }

    public static int inputInt(Scanner scanner){
        while (true){
            System.out.print("Digite o ano de  publicação: ");
            if (scanner.hasNextInt())
                return scanner.nextInt();
            System.out.println("Entrada inválida.");
        }
    }

}
