package ec1.jesus.plasencia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CURSO")
public class Curso {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CURSO")
	private Integer idCurso;

	@Column(name = "CURSO")
	private String curso;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "ID_MALLA")
	private Malla malla;
	
	@ManyToMany(mappedBy = "cursos", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Profesor> profesores = new ArrayList<>();
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public Curso(Integer idCurso, String curso, String descripcion, Malla malla, List<Profesor> profesores) {
		this.idCurso = idCurso;
		this.curso = curso;
		this.descripcion = descripcion;
		this.malla = malla;
		this.profesores = profesores;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Malla getMalla() {
		return malla;
	}

	public void setMalla(Malla malla) {
		this.malla = malla;
	}

	public List<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

}
