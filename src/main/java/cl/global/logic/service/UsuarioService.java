package cl.global.logic.service;

import cl.global.logic.dto.UsuarioRequestDTO;
import cl.global.logic.dto.UsuarioResponseDTO;

public interface UsuarioService {
	
	/**
	 * Metodo encargado de crear usuarios.
	 * 
	 * @param usuarioRequestDTO
	 * @return usuarioResponseDTO
	 */
	UsuarioResponseDTO crearUsuario(UsuarioRequestDTO usuarioDTO);


}
