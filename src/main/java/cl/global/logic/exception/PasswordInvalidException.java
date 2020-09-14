package cl.global.logic.exception;

public class PasswordInvalidException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PasswordInvalidException() {

        super("El formato de la contraseña debe al menos una mayúscula, letras minúsculas y dos números");
    }
}
