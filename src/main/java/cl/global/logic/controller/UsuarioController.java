package cl.global.logic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.global.logic.dto.UsuarioRequestDTO;
import cl.global.logic.dto.UsuarioResponseDTO;
import cl.global.logic.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping(value = "/registro", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioResponseDTO login(@RequestBody UsuarioRequestDTO usuario) {
		return service.crearUsuario(usuario);
	}

}
