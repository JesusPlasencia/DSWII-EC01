package ec1.jesus.plasencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec1.jesus.plasencia.model.Curso;
import ec1.jesus.plasencia.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService{

	@Autowired
	private CursoRepository repository;
	
	@Override
	public List<Curso> lista() {
		return repository.findAll();
	}

	@Override
	public Curso obtener(Integer idCurso) {
		return repository.findById(idCurso).orElse(null);
	}

	@Override
	public void guardar(Curso curso) {
		repository.save(curso);
	}

	@Override
	public void actualizar(Curso curso) {
		repository.saveAndFlush(curso);
	}

	@Override
	public void eliminar(Integer idCurso) {
		repository.deleteById(idCurso);
	}

}
