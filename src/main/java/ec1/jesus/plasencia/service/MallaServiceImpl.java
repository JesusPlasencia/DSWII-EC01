package ec1.jesus.plasencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec1.jesus.plasencia.model.Malla;
import ec1.jesus.plasencia.repository.MallaRepository;

@Service
public class MallaServiceImpl implements MallaService{

	@Autowired
	private MallaRepository repository;
	
	@Override
	public List<Malla> lista() {
		return repository.findAll();
	}

	@Override
	public Malla obtener(Integer idMalla) {
		return repository.findById(idMalla).orElse(null);
	}

	@Override
	public void guardar(Malla malla) {
		repository.save(malla);
	}

	@Override
	public void actualizar(Malla malla) {
		repository.saveAndFlush(malla);
	}

	@Override
	public void eliminar(Integer idMalla) {
		repository.deleteById(idMalla);
	}

}
