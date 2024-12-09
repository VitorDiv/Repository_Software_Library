package exceptions;

public class TelefoneNaoEncontradoException extends RuntimeException {
    public TelefoneNaoEncontradoException(String telefone){
        super("Nenhum usuário com o número de telefone " + telefone + ".");
    }
}
