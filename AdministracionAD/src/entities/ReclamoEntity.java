package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="reclamos")
public class ReclamoEntity {

	public ReclamoEntity() {}
	
	@Id
	@Column(name = "idReclamo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReclamo;
	
	@Column(name = "documento")
	private String documento;
	
	@Column(name = "codigo")
	private int codigo;
	
	@Column(name = "ubicacion")
	private String ubicacion;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "identificador")
	private int identificador;
	
	public ReclamoEntity(int id, String documento, int codigo, String ubicacion, String descripcion, int identificador) {
		this.idReclamo = id;
		this.documento = documento;
		this.codigo = codigo;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.identificador = identificador;
	}

	public Integer getId() {
		return idReclamo;
	}

	public void setId(Integer id) {
		this.idReclamo = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
		
}
