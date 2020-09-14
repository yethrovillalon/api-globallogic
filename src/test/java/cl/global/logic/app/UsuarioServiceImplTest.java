package cl.global.logic.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import cl.global.logic.dto.TelefonoDTO;
import cl.global.logic.dto.UsuarioRequestDTO;
import cl.global.logic.dto.UsuarioResponseDTO;
import cl.global.logic.exception.DuplicateViolationException;
import cl.global.logic.exception.NoDataFoundException;
import cl.global.logic.exception.EmailInvalidException;
import cl.global.logic.exception.PasswordInvalidException;
import cl.global.logic.model.UsuarioModel;
import cl.global.logic.repository.UsuarioRepositorio;
import cl.global.logic.seguridad.Seguridad;
import cl.global.logic.service.UsuarioServiceImpl;

@SpringBootTest
public class UsuarioServiceImplTest {

	@InjectMocks
	private UsuarioServiceImpl service;
	
	@Mock
	private Seguridad seguridad;
	
	@Mock
	private UsuarioRepositorio repositoryUsuario;
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void creacionUsuarioTest() {
		List<TelefonoDTO> telefonos = new ArrayList<TelefonoDTO>();
		telefonos.add(TelefonoDTO.builder().numero("12345678").codigoCiudad("9").codigoPais("56").build());
		UsuarioRequestDTO request = createRequest("1", "abc@akd.cl", "12Aaa",telefonos);
		Mockito.doReturn(crearUsuarioModel(request)).when(repositoryUsuario).save(Mockito.any());
		UsuarioResponseDTO crearUsuario = service.crearUsuario(request);
		
		assertNotNull(crearUsuario);
	}
	
	@Test()
	public void nombreVacioTest() {
		List<TelefonoDTO> telefonos = new ArrayList<TelefonoDTO>();
		telefonos.add(TelefonoDTO.builder().numero("12345678").codigoCiudad("9").codigoPais("56").build());
		UsuarioRequestDTO request = createRequest("", "abc@akd.cl", "12Aaa",telefonos);
		Mockito.doReturn(crearUsuarioModel(request)).when(repositoryUsuario).save(Mockito.any());
		Exception exception = assertThrows(NoDataFoundException.class, () -> {
			service.crearUsuario(request);
	    });
		
		String expectedMessage = "Peticion de entrada incorrecta";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
		
	}
	
	@Test()
	public void nombreNullTest() {
		List<TelefonoDTO> telefonos = new ArrayList<TelefonoDTO>();
		telefonos.add(TelefonoDTO.builder().numero("12345678").codigoCiudad("9").codigoPais("56").build());
		UsuarioRequestDTO request = createRequest(null, "abc@akd.cl", "12Aaa",telefonos);
		Mockito.doReturn(crearUsuarioModel(request)).when(repositoryUsuario).save(Mockito.any());
		Exception exception = assertThrows(NoDataFoundException.class, () -> {
			service.crearUsuario(request);
	    });
		
		String expectedMessage = "Peticion de entrada incorrecta";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
		
	}
	
	@Test()
	public void correoVacioTest() {
		List<TelefonoDTO> telefonos = new ArrayList<TelefonoDTO>();
		telefonos.add(TelefonoDTO.builder().numero("12345678").codigoCiudad("9").codigoPais("56").build());
		UsuarioRequestDTO request = createRequest("a", "", "12Aaa",telefonos);
		Mockito.doReturn(crearUsuarioModel(request)).when(repositoryUsuario).save(Mockito.any());
		Exception exception = assertThrows(NoDataFoundException.class, () -> {
			service.crearUsuario(request);
	    });
		
		String expectedMessage = "Peticion de entrada incorrecta";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test()
	public void correoNullTest() {
		List<TelefonoDTO> telefonos = new ArrayList<TelefonoDTO>();
		telefonos.add(TelefonoDTO.builder().numero("12345678").codigoCiudad("9").codigoPais("56").build());
		UsuarioRequestDTO request = createRequest("a", null, "12Aaa",telefonos);
		Mockito.doReturn(crearUsuarioModel(request)).when(repositoryUsuario).save(Mockito.any());
		Exception exception = assertThrows(NoDataFoundException.class, () -> {
			service.crearUsuario(request);
	    });
		
		String expectedMessage = "Peticion de entrada incorrecta";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test()
	public void contrasenaVacioTest() {
		List<TelefonoDTO> telefonos = new ArrayList<TelefonoDTO>();
		telefonos.add(TelefonoDTO.builder().numero("12345678").codigoCiudad("9").codigoPais("56").build());
		UsuarioRequestDTO request = createRequest("a", "abc@abc.cl", "",telefonos);
		Mockito.doReturn(crearUsuarioModel(request)).when(repositoryUsuario).save(Mockito.any());
		Exception exception = assertThrows(NoDataFoundException.class, () -> {
			service.crearUsuario(request);
	    });
		
		String expectedMessage = "Peticion de entrada incorrecta";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test()
	public void contrasenaNullTest() {
		List<TelefonoDTO> telefonos = new ArrayList<TelefonoDTO>();
		telefonos.add(TelefonoDTO.builder().numero("12345678").codigoCiudad("9").codigoPais("56").build());
		UsuarioRequestDTO request = createRequest("a", "abc@abc.cl", null,telefonos);
		Mockito.doReturn(crearUsuarioModel(request)).when(repositoryUsuario).save(Mockito.any());
		Exception exception = assertThrows(NoDataFoundException.class, () -> {
			service.crearUsuario(request);
	    });
		
		String expectedMessage = "Peticion de entrada incorrecta";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test()
	public void telefonosVacioTest() {
		List<TelefonoDTO> telefonos = new ArrayList<TelefonoDTO>();
		UsuarioRequestDTO request = createRequest("a", "abc@abc.cl", "12Aaa",telefonos);
		Mockito.doReturn(crearUsuarioModel(request)).when(repositoryUsuario).save(Mockito.any());
		Exception exception = assertThrows(NoDataFoundException.class, () -> {
			service.crearUsuario(request);
	    });
		
		String expectedMessage = "Peticion de entrada incorrecta";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test()
	public void telefonosNullTest() {
		List<TelefonoDTO> telefonos = null;
		UsuarioRequestDTO request = createRequest("a", "abc@abc.cl", "12Aaa",telefonos);
		Mockito.doReturn(crearUsuarioModel(request)).when(repositoryUsuario).save(Mockito.any());
		Exception exception = assertThrows(NoDataFoundException.class, () -> {
			service.crearUsuario(request);
	    });
		
		String expectedMessage = "Peticion de entrada incorrecta";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test()
	public void contrasenaInvalidTest() {
		List<TelefonoDTO> telefonos = new ArrayList<TelefonoDTO>();
		telefonos.add(TelefonoDTO.builder().numero("12345678").codigoCiudad("9").codigoPais("56").build());
		UsuarioRequestDTO request = createRequest("a", "abc@abc_cl", "12Aaa",telefonos);
		Mockito.doReturn(crearUsuarioModel(request)).when(repositoryUsuario).save(Mockito.any());
		Exception exception = assertThrows(EmailInvalidException.class, () -> {
			service.crearUsuario(request);
	    });
		
		String expectedMessage = "El formato del correo es incorrecto (aaaaaaa@dominio.cl​)";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test()
	public void passwordInvalidTest() {
		List<TelefonoDTO> telefonos = new ArrayList<TelefonoDTO>();
		telefonos.add(TelefonoDTO.builder().numero("12345678").codigoCiudad("9").codigoPais("56").build());
		UsuarioRequestDTO request = createRequest("a", "abc@abc.cl", "1Aaa",telefonos);
		Mockito.doReturn(crearUsuarioModel(request)).when(repositoryUsuario).save(Mockito.any());
		Exception exception = assertThrows(PasswordInvalidException.class, () -> {
			service.crearUsuario(request);
	    });
		
		String expectedMessage = "El formato de la contraseña debe al menos una mayúscula, letras minúsculas y dos números";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void duplicadoTest() {
		List<TelefonoDTO> telefonos = new ArrayList<TelefonoDTO>();
		telefonos.add(TelefonoDTO.builder().numero("12345678").codigoCiudad("9").codigoPais("56").build());
		
		UsuarioRequestDTO request = createRequest("aa", "abc@akd.cl", "12Aaa",telefonos);
		Mockito.doThrow(DataIntegrityViolationException.class).when(repositoryUsuario).save(Mockito.any());
		Exception exception = assertThrows(DuplicateViolationException.class, () -> {
			service.crearUsuario(request);
	    });
		
		String expectedMessage = "El registro ingresado ya se encuentra en el sistema";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void exceptionGeneralTest() {
		List<TelefonoDTO> telefonos = new ArrayList<TelefonoDTO>();
		telefonos.add(TelefonoDTO.builder().numero("12345678").codigoCiudad("9").codigoPais("56").build());
		
		UsuarioRequestDTO request = createRequest("aa", "abc@akd.cl", "12Aaa",telefonos);
		Mockito.doThrow(DuplicateViolationException.class).when(repositoryUsuario).save(Mockito.any());
		service.crearUsuario(request);
	}
	
	public UsuarioRequestDTO createRequest(String nombre, String correo, String contrasena, List<TelefonoDTO> telefonos) {
		return UsuarioRequestDTO.builder().nombre(nombre).correo(correo).contrasena(contrasena).telefonos(telefonos).build();
	}
	
	public UsuarioModel crearUsuarioModel(UsuarioRequestDTO usuarioRequestDTO) {
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

}
