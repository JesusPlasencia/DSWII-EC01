package ec1.jesus.plasencia.service;

import java.util.List;

import ec1.jesus.plasencia.model.Universidad;

public interface UniversidadService {

	List<Universidad> lista();
	Universidad obtener(Integer idUniversidad);
	void guardar(Universidad universidad);
	void actualizar(Universidad universidad);
	void eliminar(Integer idUniversidad);
}
