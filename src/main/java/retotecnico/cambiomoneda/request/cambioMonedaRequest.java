package retotecnico.cambiomoneda.request;

import lombok.Data;

@Data
public class cambioMonedaRequest {

	private Float monto;

	private String monedaOrigen;
	
	private String monedaDestino;
}
