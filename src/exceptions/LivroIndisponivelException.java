package exceptions;

public class LivroIndisponivelException extends RuntimeException {
    public LivroIndisponivelException(String titulo) {
        super("Livro " + titulo + " indisponível.");
    }
}
