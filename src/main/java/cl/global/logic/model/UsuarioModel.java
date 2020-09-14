package cl.global.logic.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = {"id_usuario","correo"}))
public class UsuarioModel implements Serializable {

	private static final long serialVersionUID = 3280620176790738528L;

	@Id
	@SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
	@Column(name = "id_usuario", unique = true, updatable = false, nullable = false, precision = 12, scale = 0)
	private Integer idUsuario;
	
	@Column(name = "nombre", length = 20, updatable = false, nullable = false)
	private String nombre;
	
	@Column(name = "correo", unique = true, length = 50, updatable = false, nullable = false)
	private String correo;
	
	@Column(name = "contrasena", length = 20, updatable = false, nullable = false)
	private String contrasena;
	
	@Column(name = "fecha_creacion", length = 20, updatable = false, nullable = false)
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion", length = 20, updatable = false, nullable = true)
	private Date fechaModificacion;
	
	@Column(name = "last_login", length = 20, updatable = false, nullable = false)
	private Date ultimoIngreso;
	
	@Column(name = "activo", updatable = false, nullable = true)
	private boolean activo;
	
	@Column(name = "token", length = 1000, updatable = false, nullable = false)
	private String token;

}
