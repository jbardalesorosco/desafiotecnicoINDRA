package retotecnico.cambiomoneda.services;

import java.util.List;

import retotecnico.cambiomoneda.entity.tipoMoneda;

public interface ITipoMonedaService {

	public List<tipoMoneda> listTipoMoneda();
	public tipoMoneda findByDesCambio(String descambio);
	public tipoMoneda updateTipoMoneda(tipoMoneda tipoMoneda, Long id);
	
}
