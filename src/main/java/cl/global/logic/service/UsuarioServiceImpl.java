package cl.global.logic.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import cl.global.logic.dto.TelefonoDTO;
import cl.global.logic.dto.UsuarioRequestDTO;
import cl.global.logic.dto.UsuarioResponseDTO;
import cl.global.logic.exception.DuplicateViolationException;
import cl.global.logic.exception.EmailInvalidException;
import cl.global.logic.exception.NoDataFoundException;
import cl.global.logic.exception.PasswordInvalidException;
import cl.global.logic.model.TelefonoModel;
import cl.global.logic.model.UsuarioModel;
import cl.global.logic.repository.TelefonoRepositorio;
import cl.global.logic.repository.UsuarioRepositorio;
import cl.global.logic.seguridad.Seguridad;
import cl.global.logic.util.Util;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepositorio repositoryUsuario;
	
	@Autowired
	private TelefonoRepositorio repositoryTelefono;
	
	@Autowired
	private Seguridad seguridad;
	
	/**
	 * Metodo encargado de crear usuarios.
	 * 
	 * @param usuarioRequestDTO
	 * @return usuarioResponseDTO
	 */
	@Override
	public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO usuarioDTO) {
		log.info("Ejecucion Metodo: Creacion Usuario");
		
		UsuarioResponseDTO response = null;
		
		if (usuarioDTO.getNombre() == null || usuarioDTO.getNombre().isEmpty()) {
		    throw new NoDataFoundException();
		}
		
		if (usuarioDTO.getCorreo() == null || usuarioDTO.getCorreo().isEmpty()) {
		    throw new NoDataFoundException();
		}
		
		if (usuarioDTO.getContrasena() == null || usuarioDTO.getContrasena().isEmpty()) {
		    throw new NoDataFoundException();
		}
		
		if (usuarioDTO.getTelefonos() == null || usuarioDTO.getTelefonos().size() == 0) {
		    throw new NoDataFoundException();
		}
		
		Util util = Util.builder().build();
		
		if (!util.isValidEmail(usuarioDTO.getCorreo())) {
			throw new EmailInvalidException();
		}
		
		if (!util.isValidPassword(usuarioDTO.getContrasena())) {
			throw new PasswordInvalidException();
		}
		
		try {
			
			log.info("Parametros");
			log.info("Nombre ("+usuarioDTO.getNombre()+")");
			log.info("Correo ("+usuarioDTO.getCorreo()+")");
			
			UsuarioModel userModel = repositoryUsuario.save(crearUsuarioModel(usuarioDTO));
			response = crearResponseDTO(userModel);
			Integer idUsuario = response.getId();

			usuarioDTO.getTelefonos().forEach(e -> {
				TelefonoDTO telefono = TelefonoDTO.builder().build();
				telefono.setIdUsuario(idUsuario);
				telefono.setNumero(e.getNumero());
				telefono.setCodigoCiudad(e.getCodigoCiudad());
				telefono.setCodigoPais(e.getCodigoPais());
				
				repositoryTelefono.save(crearTelefonoModel(telefono));
			});
			
		}catch (DataIntegrityViolationException e) {
			log.error("Correo ya existe, Exception : ", e.getMessage());
			throw new DuplicateViolationException();
		}catch (Exception e) {
			log.error("crearUsuario Exception : ", e.getCause());
		}
		log.info("Creacion Terminada");
		return response;
	}
	
	private UsuarioModel crearUsuarioModel(UsuarioRequestDTO usuarioRequestDTO) {
		return UsuarioModel.builder()
				.nombre(usuarioRequestDTO.getNombre())
				.correo(usuarioRequestDTO.getCorreo())
				.contrasena(usuarioRequestDTO.getContrasena())
				.fechaCreacion(new Date())
				.fechaModificacion(new Date())
				.ultimoIngreso(new Date())
				.token(seguridad.getJWTToken(usuarioRequestDTO.getCorreo()))
				.activo(true)
				.build();
	}
	
	private TelefonoModel crearTelefonoModel(TelefonoDTO telefonoDTO) {
		return TelefonoModel.builder()
				.idUsuario(telefonoDTO.getIdUsuario())
				.numero(telefonoDTO.getNumero())
				.codigoCiudad(telefonoDTO.getCodigoCiudad())
				.codigoPais(telefonoDTO.getCodigoPais())
				.build();
	}
	
	private UsuarioResponseDTO crearResponseDTO(UsuarioModel userModel) {
		return UsuarioResponseDTO.builder().id(userModel.getIdUsuario()).fechaCreacion(userModel.getFechaCreacion()).fechaModificacion(userModel.getFechaModificacion()).ultimoIngreso(userModel.getUltimoIngreso()).token(userModel.getToken()).activo(userModel.isActivo()).build();
	}
}
