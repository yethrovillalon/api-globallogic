package cl.global.logic.exception;

public class NoDataFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoDataFoundException() {

        super("Peticion de entrada incorrecta");
    }
}