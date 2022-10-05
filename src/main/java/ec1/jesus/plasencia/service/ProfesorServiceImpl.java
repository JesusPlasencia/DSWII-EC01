package ec1.jesus.plasencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec1.jesus.plasencia.model.Profesor;
import ec1.jesus.plasencia.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService{

	@Autowired
	private ProfesorRepository repository;
	
	@Override
	public List<Profesor> lista() {
		return repository.findAll();
	}

	@Override
	public Profesor obtener(Integer idProfesor) {
		return repository.findById(idProfesor).orElse(null);
	}

	@Override
	public void guardar(Profesor profesor) {
		repository.save(profesor);
	}

	@Override
	public void actualizar(Profesor profesor) {
		repository.saveAndFlush(profesor);
	}

	@Override
	public void eliminar(Integer idProfesor) {
		repository.deleteById(idProfesor);
	}

	
	
}
