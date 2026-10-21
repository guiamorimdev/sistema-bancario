package exception;

public class TipoContaInvalidoException extends RuntimeException{
    public TipoContaInvalidoException(String mensagem){
        super(mensagem);
    }
}
