package ec1.jesus.plasencia.service;

import java.util.List;

import ec1.jesus.plasencia.model.Malla;

public interface MallaService {

	List<Malla> lista();
	Malla obtener(Integer idMalla);
	void guardar(Malla malla);
	void actualizar(Malla malla);
	void eliminar(Integer idMalla);
	
}
