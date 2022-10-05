package ec1.jesus.plasencia.service;

import java.util.List;

import ec1.jesus.plasencia.model.Curso;

public interface CursoService {

	List<Curso> lista();
	Curso obtener(Integer idCurso);
	void guardar(Curso curso);
	void actualizar(Curso curso);
	void eliminar(Integer idCurso);
	
}
