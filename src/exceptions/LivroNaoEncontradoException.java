package exceptions;

public class LivroNaoEncontradoException extends RuntimeException {
    public LivroNaoEncontradoException(String titulo) {
        super("Livro " + titulo + " não encontrado.");
    }
}
