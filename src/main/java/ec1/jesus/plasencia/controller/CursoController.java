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

import ec1.jesus.plasencia.model.Curso;
import ec1.jesus.plasencia.service.CursoService;

@RestController
@RequestMapping("/curso/v1")
public class CursoController {

	@Autowired
	private CursoService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Curso>> getCursos(){
		return new ResponseEntity<List<Curso>>(service.lista(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> insertarCurso(@RequestBody Curso curso) {
		service.guardar(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable int codigo) {
		Curso curso = service.obtener(codigo);
		if(curso == null) {			
			return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Curso>(curso, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editarCurso(@RequestBody Curso curso) 
	{
		Curso foundCurso = service.obtener(curso.getIdCurso());
		if(foundCurso == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		service.actualizar(curso);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/eliminar/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarCurso(@PathVariable int codigo) 
	{
		Curso foundCurso = service.obtener(codigo);
		if(foundCurso == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		service.eliminar(codigo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
