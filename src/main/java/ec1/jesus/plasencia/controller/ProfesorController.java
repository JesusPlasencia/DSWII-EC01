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

import ec1.jesus.plasencia.model.Profesor;
import ec1.jesus.plasencia.service.ProfesorService;

@RestController
@RequestMapping("/profesor/v1")
public class ProfesorController {

	@Autowired
	private ProfesorService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Profesor>> getProfesores(){
		return new ResponseEntity<List<Profesor>>(service.lista(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> insertarProfesor(@RequestBody Profesor profesor) {
		service.guardar(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Profesor> obtenerProfesorPorId(@PathVariable int codigo) {
		Profesor profesor = service.obtener(codigo);
		if(profesor == null) {			
			return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Profesor>(profesor, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editarProfesor(@RequestBody Profesor profesor) 
	{
		Profesor foundProfesor = service.obtener(profesor.getIdProfesor());
		if(foundProfesor == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		service.actualizar(profesor);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/eliminar/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarProfesor(@PathVariable int codigo) 
	{
		Profesor foundProfesor = service.obtener(codigo);
		if(foundProfesor == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		service.eliminar(codigo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
