package exceptions;

public class NenhumLivroDisponivelException extends RuntimeException {
    public NenhumLivroDisponivelException() {
        super("Não há nenhum livro disponível na biblioteca.");
    }
}
