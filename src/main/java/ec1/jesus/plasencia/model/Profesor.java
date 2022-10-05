package ec1.jesus.plasencia.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROFESOR")
public class Profesor {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROFESOR")
	private Integer idProfesor;

	@Column(name = "PROFESOR")
	private String profesor;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "curso_profesor",
			joinColumns = @JoinColumn(
					name = "id_profesor",
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_profesor) references profesor(id_profesor)")
				),
			inverseJoinColumns = @JoinColumn(
					name = "id_curso",
					nullable = false,
					unique = true,
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_curso) references curso(id_curso)")
				)
			)
	private List<Curso> cursos = new ArrayList<>();
	
	public Profesor() {
		// TODO Auto-generated constructor stub
	}

	public Profesor(Integer idProfesor, String profesor, List<Curso> cursos) {
		this.idProfesor = idProfesor;
		this.profesor = profesor;
		this.cursos = cursos;
	}

	public Integer getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

}
