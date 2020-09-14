package cl.global.logic.exception;

public class DuplicateViolationException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateViolationException() {

        super("El registro ingresado ya se encuentra en el sistema");
    }
}
