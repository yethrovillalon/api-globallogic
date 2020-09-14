package cl.global.logic.dto;

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
public class TelefonoDTO {
	
	private Integer idUsuario;
	private String numero;
	private String codigoCiudad;
	private String codigoPais;

}
