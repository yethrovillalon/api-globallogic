package cl.global.logic.model;

import java.io.Serializable;
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
@Table(name = "telefono", uniqueConstraints = @UniqueConstraint(columnNames = {"id_telefono"}))
public class TelefonoModel implements Serializable {

	private static final long serialVersionUID = 3280620176790738528L;

	@Id
	@SequenceGenerator(name = "telefono_seq", sequenceName = "telefono_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telefono_seq")
	@Column(name = "id_telefono", unique = true, updatable = false, nullable = false, precision = 12, scale = 0)
	private Integer idTelefono;
	
	@Column(name = "id_usuario", updatable = false, nullable = false, precision = 12, scale = 0)
	private Integer idUsuario;
	
	@Column(name = "numero", length = 15, updatable = false, nullable = false)
	private String numero;
	
	@Column(name = "codigo_ciudad", length = 5, updatable = false, nullable = false)
	private String codigoCiudad;
	
	@Column(name = "codigo_pais", length = 5, updatable = false, nullable = false)
	private String codigoPais;

}
