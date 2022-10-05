package ec1.jesus.plasencia.service;

import java.util.List;

import ec1.jesus.plasencia.model.Profesor;

public interface ProfesorService {

	List<Profesor> lista();
	Profesor obtener(Integer idProfesor);
	void guardar(Profesor profesor);
	void actualizar(Profesor profesor);
	void eliminar(Integer idProfesor);
	
}
