package retotecnico.cambiomoneda.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import retotecnico.cambiomoneda.dao.ITipoMonedaDao;
import retotecnico.cambiomoneda.entity.tipoMoneda;
//import retotecnico.cambiomoneda.entity.tipoCambio;
import retotecnico.cambiomoneda.request.cambioMonedaRequest;
import retotecnico.cambiomoneda.response.cambioMonedaResponse;
import retotecnico.cambiomoneda.services.ITipoCambioService;
import retotecnico.cambiomoneda.services.ITipoMonedaService;

@RestController
public class tipoCambioController {
	
	@Autowired
	private ITipoCambioService cambioMonedaService;
	
	@Autowired
	private ITipoMonedaService tipoMonedaService;
	
	@PostMapping("/realizarcambio")
	public ResponseEntity<?> realizarCambio(@RequestBody cambioMonedaRequest cambioMoneda) {
		Map<String, Object> response = new HashMap<>();
		try {
			cambioMonedaResponse responseCambio = cambioMonedaService.realizarCambioMoneda(cambioMoneda);
			return new ResponseEntity<cambioMonedaResponse>(responseCambio, HttpStatus.OK);
		} catch (Exception e) {
			List<String> listMonedas = tipoMonedaService.listTipoMoneda().stream().map(desMoneda -> desMoneda.getDesCambio()).collect(Collectors.toList());			
			response.put("Mensaje", "Error al realizar el tipo de cambio");
			response.put("Monedas disponibles", listMonedas);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
