package cl.global.logic.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("mensaje", "URL no encontrada");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);	
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("mensaje", "Servicio suspendido, por favor contartarse con el administrador");
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> handleNodataFoundException(
        NoDataFoundException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("mensaje", "Peticion de entrada incorrecta");

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(EmailInvalidException.class)
    public ResponseEntity<Object> handleEmailInvalidException(EmailInvalidException ex, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("mensaje", "El formato del correo es incorrecto (aaaaaaa@dominio.cl​)");
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(PasswordInvalidException.class)
    public ResponseEntity<Object> handlePasswordInvalidException(PasswordInvalidException ex, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("mensaje", "El formato de la contraseña debe al menos una mayúscula, letras minúsculas y dos números");
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(DuplicateViolationException.class)
    public ResponseEntity<Object> handleDuplicateViolationException(DuplicateViolationException ex, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
        body.put("mensaje", "El registro ingresado ya se encuentra en el sistema");
        return new ResponseEntity<>(body, HttpStatus.FOUND);
    }
}
