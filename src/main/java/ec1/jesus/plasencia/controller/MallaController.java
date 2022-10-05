package ec1.jesus.plasencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ec1.jesus.plasencia.model.Malla;
import ec1.jesus.plasencia.service.MallaService;

@RestController
@RequestMapping("/malla/v1")
public class MallaController {

	@Autowired
	private MallaService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Malla>> getMallas(){
		return new ResponseEntity<List<Malla>>(service.lista(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> insertarMalla(@RequestBody Malla malla) {
		service.guardar(malla);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Malla> obtenerMallaPorId(@PathVariable int codigo) {
		Malla malla = service.obtener(codigo);
		if(malla == null) {			
			return new ResponseEntity<Malla>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Malla>(malla, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editarMalla(@RequestBody Malla malla) 
	{
		Malla foundMalla = service.obtener(malla.getIdMalla());
		if(foundMalla == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		service.actualizar(malla);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/eliminar/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarMalla(@PathVariable int codigo) 
	{
		Malla foundMalla = service.obtener(codigo);
		if(foundMalla == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		service.eliminar(codigo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
