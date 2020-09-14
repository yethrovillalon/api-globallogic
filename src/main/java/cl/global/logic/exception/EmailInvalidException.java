package cl.global.logic.exception;

public class EmailInvalidException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public EmailInvalidException() {

        super("El formato del correo es incorrecto (aaaaaaa@dominio.cl​)");
    }

}
