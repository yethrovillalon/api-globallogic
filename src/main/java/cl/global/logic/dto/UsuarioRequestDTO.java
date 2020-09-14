package cl.global.logic.dto;

import java.util.List;

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
public class UsuarioRequestDTO {
	
	private String nombre;
	private String correo;
	private String contrasena;
	private List<TelefonoDTO> telefonos;

}
