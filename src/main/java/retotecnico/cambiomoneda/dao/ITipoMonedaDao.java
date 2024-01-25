package retotecnico.cambiomoneda.dao;

import org.springframework.data.repository.CrudRepository;

import retotecnico.cambiomoneda.entity.tipoMoneda;

public interface ITipoMonedaDao extends CrudRepository<tipoMoneda, Long> {

	tipoMoneda findByDesCambio(String descambio);
	
}
