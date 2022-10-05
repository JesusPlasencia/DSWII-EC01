package ec1.jesus.plasencia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MALLA_CURRICULAR")
public class Malla {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MALLA")
	private Integer idMalla;

	@Column(name = "AÑO")
	private String año;
	
	@OneToOne(cascade = { CascadeType.ALL })
	private Universidad universidad;
	
	@OneToMany(mappedBy = "malla")
	private List<Curso> curso;

	public Malla() {
		// TODO Auto-generated constructor stub
	}

	public Malla(Integer idMalla, String año, Universidad universidad, List<Curso> curso) {
		this.idMalla = idMalla;
		this.año = año;
		this.universidad = universidad;
		this.curso = curso;
	}

	public Integer getIdMalla() {
		return idMalla;
	}

	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public Universidad getUniversidad() {
		return universidad;
	}

	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}

	public List<Curso> getCurso() {
		return curso;
	}

	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}

}
