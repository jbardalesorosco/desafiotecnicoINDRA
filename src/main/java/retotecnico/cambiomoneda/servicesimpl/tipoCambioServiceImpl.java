package retotecnico.cambiomoneda.servicesimpl;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retotecnico.cambiomoneda.entity.tipoMoneda;
import retotecnico.cambiomoneda.request.cambioMonedaRequest;
import retotecnico.cambiomoneda.response.cambioMonedaResponse;
import retotecnico.cambiomoneda.services.ITipoCambioService;
import retotecnico.cambiomoneda.services.ITipoMonedaService;

@Service
public class tipoCambioServiceImpl implements ITipoCambioService {

	@Autowired
	private ITipoMonedaService tipoMoneda;
	
	@Override
	public cambioMonedaResponse realizarCambioMoneda(cambioMonedaRequest cambioMoneda) {
		tipoMoneda tipoMonedaOrigen = tipoMoneda.findByDesCambio(cambioMoneda.getMonedaOrigen());
		tipoMoneda tipoMonedaDestino = tipoMoneda.findByDesCambio(cambioMoneda.getMonedaDestino());
		float montoConTipoCambio = cambioMoneda.getMonto() * (tipoMonedaOrigen.getTipoCambio() / tipoMonedaDestino.getTipoCambio());
		DecimalFormat df = new DecimalFormat("#.####");
		
		return cambioMonedaResponse.builder()
		.monto(cambioMoneda.getMonto())
		.montoConTipoCambio(Float.valueOf(df.format(montoConTipoCambio)))
		.monedaOrigen(tipoMonedaOrigen.getDesCambio())
		.monedaDestino(tipoMonedaDestino.getDesCambio())
		.tipoCambio(tipoMonedaDestino.getTipoCambio())
		.build();
	}
	

}
