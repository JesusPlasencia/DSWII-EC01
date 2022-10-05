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

import ec1.jesus.plasencia.model.Universidad;
import ec1.jesus.plasencia.service.UniversidadService;

@RestController
@RequestMapping("/universidad/v1")
public class UniversidadController {

	@Autowired
	private UniversidadService service;

	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Universidad>> getUniversidades(){
		return new ResponseEntity<List<Universidad>>(service.lista(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> insertarUniversidad(@RequestBody Universidad universidad) {
		service.guardar(universidad);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Universidad> obtenerUniversidadPorId(@PathVariable int codigo) {
		Universidad universidad = service.obtener(codigo);
		if(universidad == null) {			
			return new ResponseEntity<Universidad>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Universidad>(universidad, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editarUniversidad(@RequestBody Universidad universidad) 
	{
		Universidad foundUniversidad = service.obtener(universidad.getIdUniversidad());
		if(foundUniversidad == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		service.actualizar(universidad);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/eliminar/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarUniversidad(@PathVariable int codigo) 
	{
		Universidad foundUniversidad = service.obtener(codigo);
		if(foundUniversidad == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		service.eliminar(codigo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
