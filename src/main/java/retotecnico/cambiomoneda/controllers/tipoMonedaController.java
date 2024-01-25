package retotecnico.cambiomoneda.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import retotecnico.cambiomoneda.entity.tipoMoneda;
import retotecnico.cambiomoneda.services.ITipoMonedaService;

@RestController
public class tipoMonedaController {
	
	@Autowired
	private ITipoMonedaService tipoMonedaService;

	@GetMapping("/tipomoneda")
	public List<tipoMoneda> listTipoMoneda(){
		return tipoMonedaService.listTipoMoneda();
	}
	
	@PostMapping("/tipomoneda/{id}")
	public ResponseEntity<?> actualizarTipoMoneda(@RequestBody tipoMoneda tipomoneda, @PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		tipoMoneda responsetipoMoneda = tipoMonedaService.updateTipoMoneda(tipomoneda, id);
		if (responsetipoMoneda != null) {
			response.put("Mensaje", "Se actualizo el tipo de cambio!");
			response.put("Cambio", responsetipoMoneda);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} else {
			response.put("Mensaje", "Error, no se pudo editar la moneda actual no existe en la BD");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
	}
	
}
