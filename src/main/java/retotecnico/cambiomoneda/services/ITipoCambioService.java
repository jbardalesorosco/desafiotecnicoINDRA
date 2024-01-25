package retotecnico.cambiomoneda.services;

import retotecnico.cambiomoneda.request.cambioMonedaRequest;
import retotecnico.cambiomoneda.response.cambioMonedaResponse;

public interface ITipoCambioService {
	
	public cambioMonedaResponse realizarCambioMoneda(cambioMonedaRequest cambioMoneda);
}
