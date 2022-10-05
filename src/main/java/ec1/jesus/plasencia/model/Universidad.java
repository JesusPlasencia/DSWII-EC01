package ec1.jesus.plasencia.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UNIVERSIDAD")
public class Universidad {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_UNIVERSIDAD")
	private Integer idUniversidad;

	@Column(name = "UNIVERSIDAD")
	private String universidad;
	
	@OneToOne(cascade = { CascadeType.ALL })
	private Malla malla;
	
	public Universidad() {
		
	}

	public Universidad(Integer idUniversidad, String universidad, Malla malla) {
		this.idUniversidad = idUniversidad;
		this.universidad = universidad;
		this.malla = malla;
	}

	public Integer getIdUniversidad() {
		return idUniversidad;
	}

	public void setIdUniversidad(Integer idUniversidad) {
		this.idUniversidad = idUniversidad;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public Malla getMalla() {
		return malla;
	}

	public void setMalla(Malla malla) {
		this.malla = malla;
	}
	
}
