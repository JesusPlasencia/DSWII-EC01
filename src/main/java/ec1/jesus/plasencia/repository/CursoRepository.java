package ec1.jesus.plasencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec1.jesus.plasencia.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
