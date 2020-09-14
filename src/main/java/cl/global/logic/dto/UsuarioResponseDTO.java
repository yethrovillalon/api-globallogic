package cl.global.logic.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {
	
	private Integer id;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date ultimoIngreso;
	private String token;
	private Boolean activo;
}
