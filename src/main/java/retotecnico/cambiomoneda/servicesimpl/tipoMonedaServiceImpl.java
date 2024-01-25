package retotecnico.cambiomoneda.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retotecnico.cambiomoneda.dao.ITipoMonedaDao;
import retotecnico.cambiomoneda.entity.tipoMoneda;
import retotecnico.cambiomoneda.services.ITipoMonedaService;

@Service
public class tipoMonedaServiceImpl implements ITipoMonedaService {
	
	@Autowired
	private ITipoMonedaDao tipoMonedaDao;

	@Override
	public List<tipoMoneda> listTipoMoneda() {
		return (List<tipoMoneda>) tipoMonedaDao.findAll();
	}

	@Override
	public tipoMoneda findByDesCambio(String descambio) {
		return tipoMonedaDao.findByDesCambio(descambio);
	}

	@Override
	public tipoMoneda updateTipoMoneda(tipoMoneda tipoMoneda, Long id) {
		Optional<tipoMoneda> tipomonedaActual = tipoMonedaDao.findById(id);
		if(tipomonedaActual.isPresent()) {
			tipomonedaActual.get().setTipoCambio(tipoMoneda.getTipoCambio());	
			return tipoMonedaDao.save(tipomonedaActual.get());
		} else {
			return null;
		}
	}
	
}
