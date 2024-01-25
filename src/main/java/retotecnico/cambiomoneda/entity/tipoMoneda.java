package retotecnico.cambiomoneda.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tipomoneda")
@Data
public class tipoMoneda implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2789884541418332920L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "descambio")
	private String desCambio;
	
	@Column(name = "tipocambio")
	private Float tipoCambio;

}
