package retotecnico.cambiomoneda.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class cambioMonedaResponse {

	private Float monto;

	private Float montoConTipoCambio;

	private String monedaOrigen;
	
	private String monedaDestino;
		
	private Float tipoCambio;
}
