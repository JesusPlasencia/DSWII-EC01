package ec1.jesus.plasencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec1.jesus.plasencia.model.Universidad;
import ec1.jesus.plasencia.repository.UniversidadRepository;

@Service
public class UniversidadServiceImpl implements UniversidadService{

	@Autowired
	private UniversidadRepository repository;
	
	@Override
	public List<Universidad> lista() {
		return repository.findAll();
	}

	@Override
	public Universidad obtener(Integer idUniversidad) {
		return repository.findById(idUniversidad).orElse(null);
	}

	@Override
	public void guardar(Universidad universidad) {
		repository.save(universidad);
	}

	@Override
	public void actualizar(Universidad universidad) {
		repository.saveAndFlush(universidad);
	}

	@Override
	public void eliminar(Integer idUniversidad) {
		repository.deleteById(idUniversidad);
	}

}
