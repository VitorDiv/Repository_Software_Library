package exceptions;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException(String nome) {
        super("Usuário com nome '" + nome + "' não encontrado.");
    }

}
